package banking;

import com.objectdb.o.HST;

import javax.persistence.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class AccountManager {
    private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("$objectdb/db/bankingApp.odb");
    private EntityManager entityManager;

    private Sanitizer sanitizer = new Sanitizer();
    private OutputMethods outputMethods = new OutputMethods();
    private CurrencyConverter currencyConverter = new CurrencyConverter();

    AccountManager() {
        entityManager = emfactory.createEntityManager();
        entityManager.getTransaction().begin();

    }

    //add money to a bank account and save it
    private void add(int currencyType, Account account, Double amountToAdd) {
        Double convertedAmount = currencyConverter.convert(currencyType, account.getCurrencyType(), amountToAdd);

        Double newBalance = account.getBalance() + convertedAmount;
        account.setBalance(newBalance);

        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();

    }

    //remove a user from the database
    void deleteAccount(Scanner scanner) {
        long accountNumber = getAccountNumber(scanner);

        try {
            Account account = findAccount(accountNumber);
            entityManager.remove(account);
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
        } catch (IllegalArgumentException iae) {
            outputMethods.noExistingAccount(accountNumber);
        }
    }

    //remove a user from the database
    void deleteUser(Scanner scanner) {
        String username = getUsername(scanner);

        try {
            User user = findUser(username);
            entityManager.remove(user);
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
        } catch (IllegalArgumentException iae) {
            outputMethods.noExistingUser(username);
        }
    }

    //close the entity manager used to save things to the database
    void closeEntityManger() {
        entityManager.close();
        emfactory.close();
    }

    //change an attribute with the account. ie. preferred currency type
    //used by administrators (can change any account)
    void manageAccount(Scanner scanner) {
        Account account = validateAccount(null, scanner);

        outputMethods.accountScreen(account);

        changeAttribute(account, scanner);
    }

    //change an attribute with the account. ie. preferred currency type
    //used by normal users (can only change accounts that the user owns)
    void manageAccount(Scanner scanner, User user) {
        Account account = validateAccount(null, scanner);

        outputMethods.accountScreen(account);

        if (user.getUsername().equals(account.getUsername())) {
            changeAttribute(account, scanner);
        } else {
            outputMethods.invalidAccountNumber();
        }
    }

    //change one of the attributes in an account
    private void changeAttribute(Account account, Scanner scanner) {
        String input = scanner.nextLine();

        String attribute = sanitizer.lettersOnlyString(input);

        switch (attribute) {
            case "USERNAME":
                updateUsername(account, scanner);
                break;

            case "CURRENCY":
                updateCurrencyType(account, scanner);
                break;

            default:
                break;
        }

    }

    //logs a user into an account.
    //using login while already logged in, will log the user out and then sign them into the new account
    User login(Scanner scanner) throws NoSuchAlgorithmException {
        String username = getUsername(scanner);
        User user = findUser(username);

        String password = getPassword(scanner, false);

        if (user != null) {
            password += user.getSalt();
            password = passwordHash(password);

            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        outputMethods.incorrectUsernameOrPassword();
        return new AnonymousUser();
    }

    //logs the user out. They will then be an anonymous user
    User logout() {
        outputMethods.loggedOut();
        return new AnonymousUser();
    }

    //change username on an account
    private void updateUsername(Account account, Scanner scanner) {
        String username = getUsername(scanner);

        account.setUsername(username);

        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
    }

    //change currency type on an account
    private void updateCurrencyType(Account account, Scanner scanner) {
        int currencyType = getAccountCurrencyType(scanner);

        account.setCurrencyType(currencyType);

        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();

    }


    //when transferring money between account, this method will get the account to have money taken out of
    private Account getAccountToTransferFrom(Scanner scanner) {
        outputMethods.accountToTransferFromPrompt();
        return validateAccount(null, scanner);
    }

    //when transferring money between account, this method will get the account to have money put into
    private Account getAccountToTransferTo(Scanner scanner) {
        outputMethods.accountToTransferToPrompt();
        return validateAccount(null, scanner);
    }

    //make sure this is an actual account
    private Account validateAccount(Account account, Scanner scanner) {

        while (account == null) {
            Long accountNumber = getAccountNumber(scanner);

            account = findAccount(accountNumber);

            if (account == null) {
                outputMethods.invalidAccountNumber();
            }
        }

        return account;
    }

    //create and add a bank account to the database
    void makeAccount(Scanner scanner) {
        int currencyType = -1;

        long accountNumber = getAccountNumber(scanner);
        Account testAccount = findAccount(accountNumber);

        if (testAccount == null) {
            Account account = new Account(accountNumber);

            Double[] balance = getAmountToAdd(scanner);

            if (balance[1].equals((double) -1)) {
                currencyType = getAccountCurrencyType(scanner);

            } else {
                currencyType = balance[1].intValue();
            }

            account.setBalance(balance[0]);
            account.setCurrencyType(currencyType);
            String username = getUsername(scanner);
            account.setUsername(username);

            saveAccount(account);
        } else {
            outputMethods.accountNumberInUse();
        }

    }

    //create and add a user to the database
    void makeUser(Scanner scanner) throws NoSuchAlgorithmException {
        String username = getUsername(scanner);
        User user = findUser(username);

        if (user == null) {
            String password = getPassword(scanner, true);
            boolean isAdmin = getAdminValue(scanner);
            int salt = makeSalt();

            //salt the password
            password += salt;
            password = passwordHash(password);

            if (isAdmin) {
                user = new AdminUser(username, password, salt);
            } else {
                int currencyType = getAccountCurrencyType(scanner);
                user = new NormalUser(username, password, currencyType, salt);
            }

            saveUser(user);
        } else {
            outputMethods.usernameInUse();
        }


    }

    //make a random salt between 0 and 32767
    int makeSalt() {
        Random random = new Random();
        return random.nextInt(32768);
    }

    //takes a plain text password and encrypts it
    String passwordHash(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        messageDigest.update(password.getBytes(StandardCharsets.UTF_16));
        byte[] digest = messageDigest.digest();

        return String.format("%064x", new BigInteger(1, digest));
    }

    //add money to any account
    void addFunds(Scanner scanner) {
        int currencyType = -1;

        Account account = validateAccount(null, scanner);

        Double[] amountToAdd = getAmountToAdd(scanner);

        if (amountToAdd[1].equals((double) -1)) {
            currencyType = getAccountCurrencyType(scanner);
        } else {
            currencyType = amountToAdd[1].intValue();
        }

        add(currencyType, account, amountToAdd[0]);
    }

    //add money to an account that belongs to the user
    void addFunds(Scanner scanner, User user) {
        int currencyType = -1;

        Account account = validateAccount(null, scanner);

        List<Account> accounts = allAccounts(false);
        List<Account> usersAccounts = new ArrayList<>();
        for (Account a : accounts) {
            if (a.getUsername().equals(user.getUsername())) {
                usersAccounts.add(a);
            }
        }

        if (usersAccounts.contains(account)) {
            Double[] amountToAdd = getAmountToAdd(scanner);

            if (amountToAdd[1].equals((double) -1)) {
                currencyType = getAccountCurrencyType(scanner);
            } else {
                currencyType = amountToAdd[1].intValue();
            }

            add(currencyType, account, amountToAdd[0]);
        } else {
            outputMethods.invalidAccountNumber();
        }
    }

    //subtract money from any account
    void subtractFunds(Scanner scanner) {
        Account account = validateAccount(null, scanner);
        subtractFundsFromAccount(scanner, account.getAccountNumber());
    }

    //subtract money from an account that belongs to the user
    void subtractFunds(Scanner scanner, User user) {
        Account account = validateAccount(null, scanner);
        if (user.getUsername().equals(account.getUsername())) {
            subtractFundsFromAccount(scanner, account.getAccountNumber());
        } else {
            outputMethods.invalidAccountNumber();
        }
    }

    //subtract funds from the account with account number accountNumber
    void subtractFundsFromAccount(Scanner scanner, Long accountNumber) {
        Account account = findAccount(accountNumber);
        Double[] amount = getAmountToSubtract(scanner);
        int currencyType = -1;

        Double amountToSubtract = amount[0];

        if (amount[1].equals((double) -1)) {
            currencyType = getAccountCurrencyType(scanner);
        } else {
            currencyType = amount[1].intValue();
        }

        if (!subtract(currencyType, account, amountToSubtract)) {
            outputMethods.insufficientFunds();
        }

    }

    //move money from one bank account to another
    void transferFunds(Scanner scanner) {
        int currencyType = -1;
        //get account to take from
        Account accountToTransferFrom = getAccountToTransferFrom(scanner);
        //get account to add to
        Account accountToTransferTo = getAccountToTransferTo(scanner);
        //get amount
        Double[] amount = getAmountToTransfer(scanner);
        //get currency type
        if (amount[1].equals((double) -1)) {
            currencyType = getAccountCurrencyType(scanner);
        } else {
            currencyType = amount[1].intValue();
        }

        if (subtract(currencyType, accountToTransferFrom, amount[0])) {
            add(currencyType, accountToTransferTo, amount[0]);
        } else {
            outputMethods.insufficientFunds();
        }
    }

    //move money from an account that the user owns to another account in the database
    void transferFunds(Scanner scanner, User user) {
        int currencyType = -1;
        //get account to take from
        Account accountToTransferFrom = getAccountToTransferFrom(scanner);

        if (accountToTransferFrom.getUsername().equals(user.getUsername())) {
            //get account to add to
            Account accountToTransferTo = getAccountToTransferTo(scanner);
            //get amount
            Double[] amount = getAmountToTransfer(scanner);
            //get currency type
            if (amount[1].equals((double) -1)) {
                currencyType = getAccountCurrencyType(scanner);
            } else {
                currencyType = amount[1].intValue();
            }

            if (subtract(currencyType, accountToTransferFrom, amount[0])) {
                add(currencyType, accountToTransferTo, amount[0]);
            } else {
                outputMethods.insufficientFunds();
            }
        } else {
            outputMethods.invalidAccountNumber();
        }
    }

    //take money from an account, but only if there is at least that much money in the account (don't go below 0)
    private boolean subtract(int currencyType, Account account, Double amountToSubtract) {
        Double convertedAmount = currencyConverter.convert(currencyType, account.getCurrencyType(), amountToSubtract);
        Double newBalance = account.getBalance() - convertedAmount;

        if (newBalance > 0) {
            account.setBalance(newBalance);

            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();

            return true;
        }

        return false;
    }

    //change the ratios for currency conversions
    CurrencyConverter updateCurrencyWeights(Scanner scanner) {
        CurrencyConverter cc = currencyConverter.weightManger(scanner);
        this.currencyConverter = cc;
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
        return cc;
    }

    //check to see if there is a currency converter in the database. If not, make a new one.
    CurrencyConverter checkForCurrencyConverter() {

        CurrencyConverter currencyConverter;

        currencyConverter = entityManager.find(CurrencyConverter.class, 1);
        if (currencyConverter == null) {
            currencyConverter = new CurrencyConverter();
            currencyConverter.setDollarWeight(1d);
            currencyConverter.setEuroWeight(1d);
            currencyConverter.setYenWeight(1d);

            entityManager.persist(currencyConverter);
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
        }

        this.currencyConverter = currencyConverter;
        return currencyConverter;


    }

    //get a list of all of the accounts
    @SuppressWarnings("unchecked")
    List<Account> allAccounts(boolean print) {
        List<Account> accounts = new ArrayList<>();

        try {
            Query ql = entityManager.createQuery("SELECT a FROM Account a");
            accounts = ql.getResultList();
            if (print) {
                for (Account a : accounts) {
                    System.out.print(a);
                }
            }
        } catch (PersistenceException pe) {
            System.out.println("No accounts have been saved yet.");
        }

        return accounts;
    }

    //get a list of all of the users
    @SuppressWarnings("unchecked")
    List<User> allUsers(boolean print) {
        List<User> users = new ArrayList<>();

        try {
            Query ql = entityManager.createQuery("SELECT a FROM NormalUser a");
            users = ql.getResultList();
            ql = entityManager.createQuery("SELECT a FROM AdminUser a");
            users.addAll(ql.getResultList());
            if (print) {
                for (User u : users) {
                    System.out.println(u);
                }
                System.out.println();
            }
        } catch (PersistenceException pe) {
            System.out.println("No users have been saved yet.");
        }

        return users;
    }

    //get an account from the database using the account number
    private Account findAccount(long id) {
        return entityManager.find(Account.class, id);
    }

    //get a normal user from the database using the username
    private NormalUser findNormalUser(String username) {
        return entityManager.find(NormalUser.class, username);
    }

    //get an admin user from the database using the username
    private AdminUser findAdminUser(String username) {
        return entityManager.find(AdminUser.class, username);
    }

    //get a user (normal or admin) from the database using the username
    private User findUser(String username) {
        User user = findAdminUser(username);

        if (user == null) {
            user = findNormalUser(username);
        }
        return user;
    }

    //update an account in the database
    private void saveAccount(Account account) {
        entityManager.persist(account);
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
    }

    //update a user inthe database
    private void saveUser(User user) {
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
    }

    //get an account number from the user
    private long getAccountNumber(Scanner scanner) {
        try {
            outputMethods.accountNumberPrompt();
            String input = scanner.nextLine();
            return sanitizer.accountNumber(input);

        } catch (NumberFormatException nfe) {
            return getAccountNumber(scanner);
        }

    }

    //get a username from the user
    private String getUsername(Scanner scanner) {
        String username = "";

        while (username.equals("")) {
            outputMethods.usernamePrompt();
            String input = scanner.nextLine();

            username = sanitizer.lettersOnlyString(input);

            if (username.equals("")) {
                outputMethods.invalidUsername();
            }
        }

        return username;
    }

    //get a password from the user
    private String getPassword(Scanner scanner, boolean confirm) {
        String password = "";

        while (password.equals("")) {
            outputMethods.passwordPrompt();
            String input = scanner.nextLine();

            //todo any string
            password = sanitizer.lettersOnlyString(input);

            if (password.equals("")) {
                outputMethods.invalidPassword();
            }

            if (confirm) {
                outputMethods.confirmPassword();
                input = scanner.nextLine();
                input = sanitizer.lettersOnlyString(input);
                if (!input.equals(password)) {
                    outputMethods.nonMatchingPassword();
                    password = "";
                }
            }
        }

        return password;
    }

    //check if the logged in user is an admin
    private boolean getAdminValue(Scanner scanner) {
        String isAdmin = "";
        Boolean adminValue = null;

        while (adminValue == null) {
            outputMethods.isAdminPrompt();
            String input = scanner.nextLine();

            isAdmin = sanitizer.lettersOnlyString(input);

            if (isAdmin.equals("T") || isAdmin.equals("TRUE")) {
                adminValue = true;
            }

            if (isAdmin.equals("F") || isAdmin.equals("FALSE")) {
                adminValue = false;
            }

            if (adminValue == null) {
                outputMethods.invalidBoolean();
            }

        }

        return adminValue;

    }

    //get a starting account balance from the user
    private Double getAccountBalance(Scanner scanner) {
        try {
            outputMethods.accountBalancePrompt();
            String input = scanner.nextLine();
            return sanitizer.accountBalance(input);

        } catch (NumberFormatException nfe) {
            return getAccountBalance(scanner);
        }

    }

    //get an amount of money to add to an account from the user
    private Double[] getAmountToAdd(Scanner scanner) {
        try {
            outputMethods.amountToAddPrompt();
            String input = scanner.nextLine();

            return sanitizer.typeAndAmountOfMoney(input);
        } catch (NumberFormatException nfe) {
            return getAmountToAdd(scanner);
        }
    }

    //get an amount of money to subtract from an account from the user
    private Double[] getAmountToSubtract(Scanner scanner) {
        try {
            outputMethods.amountToWithdrawPrompt();
            String input = scanner.nextLine();

            return sanitizer.typeAndAmountOfMoney(input);
        } catch (NumberFormatException nfe) {
            return getAmountToSubtract(scanner);
        }
    }

    //get an amount of money to transfer from one account to another from the user
    private Double[] getAmountToTransfer(Scanner scanner) {
        try {
            outputMethods.amountToTransferPrompt();
            String input = scanner.nextLine();

            return sanitizer.typeAndAmountOfMoney(input);
        } catch (NumberFormatException nfe) {
            return getAmountToTransfer(scanner);
        }
    }

    //get the currency type of an account from the user
    private int getAccountCurrencyType(Scanner scanner) {
        try {
            outputMethods.currencyTypePrompt();
            String input = scanner.nextLine();
            return sanitizer.currencyType(input.toUpperCase());

        } catch (IllegalArgumentException iae) {
            return getAccountCurrencyType(scanner);
        }

    }
}
