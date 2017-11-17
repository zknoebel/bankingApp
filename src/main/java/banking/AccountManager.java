package banking;

import javax.persistence.*;
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

    private void add(int currencyType, Account account, Double amountToAdd) {
        Double convertedAmount = currencyConverter.convert(currencyType, account.getCurrencyType(), amountToAdd);

        Double newBalance = account.getBalance() + convertedAmount;
        account.setBalance(newBalance);

        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();

    }

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

    void closeEntityManger() {
        entityManager.close();
        emfactory.close();
    }

    void manageAccount(Scanner scanner) {
        Account account = validateAccount(null, scanner);

        outputMethods.accountScreen(account);

        changeAttribute(account, scanner);
    }

    private void changeAttribute(Account account, Scanner scanner) {
        String input = scanner.nextLine();

        String attribute = sanitizer.lettersOnlyString(input);

        switch (attribute) {
            case "USERNAME":
                updateUsername(account, scanner);
                break;

            default:
                break;
        }

    }

    User login(Scanner scanner) {
        String username = getUsername(scanner);
        User user = findUser(username);

        String password = getPassword(scanner);

        if(user.getPassword().equals(password)){
            return user;
        }
        outputMethods.incorrectUsernameOrPassword();
        return new AnonymousUser();
    }

    User logout() {
        return new AnonymousUser();
    }

    private void updateUsername(Account account, Scanner scanner) {
        String username = getUsername(scanner);

        account.setUsername(username);

        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
    }

    private Account getAccountToTransferFrom(Scanner scanner) {
        outputMethods.accountToTransferFromPrompt();
        return validateAccount(null, scanner);
    }

    private Account getAccountToTransferTo(Scanner scanner) {
        outputMethods.accountToTransferToPrompt();
        return validateAccount(null, scanner);
    }

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

    void makeUser(Scanner scanner) {
        String username = getUsername(scanner);
        User user = findUser(username);

        if (user == null) {
            String password = getPassword(scanner);
            int currencyType = getAccountCurrencyType(scanner);
            user = new NormalUser(username, password, currencyType);

            saveUser(user);
        } else {
            outputMethods.usernameInUse();
        }


    }

    int makeSalt() {
        Random random = new Random();
        return random.nextInt(256) + 1;
    }

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

    void subtractFunds(Scanner scanner) {
        Account account = validateAccount(null, scanner);
        subtractFundsFromAccount(scanner, account.getAccountNumber());
    }

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

        subtract(currencyType, account, amountToSubtract);

    }

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

        subtract(currencyType, accountToTransferFrom, amount[0]);
        add(currencyType, accountToTransferTo, amount[0]);
    }

    private void subtract(int currencyType, Account account, Double amountToSubtract) {
        Double convertedAmount = currencyConverter.convert(currencyType, account.getCurrencyType(), amountToSubtract);

        Double newBalance = account.getBalance() - convertedAmount;
        account.setBalance(newBalance);

        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();

    }

    CurrencyConverter updateCurrencyWeights(Scanner scanner) {
        CurrencyConverter cc = currencyConverter.weightManger(scanner);
        this.currencyConverter = cc;
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
        return cc;
    }

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

    @SuppressWarnings("unchecked")
    void showAllAccounts() {

        try {
            Query ql = entityManager.createQuery("SELECT a FROM Account a");
            List<Account> accounts = ql.getResultList();
            for (Account a : accounts) {
                System.out.print(a);
            }
        } catch (PersistenceException pe) {
            System.out.println("No accounts have been saved yet.");
        }
    }

    @SuppressWarnings("unchecked")
    void showAllUsers() {
        try {
            Query ql = entityManager.createQuery("SELECT a FROM NormalUser a");
            List<User> accounts = ql.getResultList();
            for (User u : accounts) {
                System.out.println(u);
            }
            System.out.println();
        } catch (PersistenceException pe) {
            System.out.println("No users have been saved yet.");
        }

    }

    private Account findAccount(long id) {
        return entityManager.find(Account.class, id);
    }

    private NormalUser findNormalUser(String username) {
        return entityManager.find(NormalUser.class, username);
    }

    private User findUser(String username) {
        //todo add admin
        return findNormalUser(username);
    }

    private void saveAccount(Account account) {
        entityManager.persist(account);
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
    }

    private void saveUser(User user) {
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
    }

    private long getAccountNumber(Scanner scanner) {
        try {
            outputMethods.accountNumberPrompt();
            String input = scanner.nextLine();
            return sanitizer.accountNumber(input);

        } catch (NumberFormatException nfe) {
            return getAccountNumber(scanner);
        }

    }

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

    private String getPassword(Scanner scanner) {
        String password = "";

        while (password.equals("")) {
            outputMethods.passwordPrompt();
            String input = scanner.nextLine();

            //todo any string
            password = sanitizer.lettersOnlyString(input);

            if (password.equals("")) {
                outputMethods.invalidPassword();
            }

            outputMethods.confirmPassword();
            input = scanner.nextLine();
            input = sanitizer.lettersOnlyString(input);
            if (!input.equals(password)) {
                outputMethods.nonMatchingPassword();
                password = "";
            }
        }

        return password;
    }

    private Double getAccountBalance(Scanner scanner) {
        try {
            outputMethods.accountBalancePrompt();
            String input = scanner.nextLine();
            return sanitizer.accountBalance(input);

        } catch (NumberFormatException nfe) {
            return getAccountBalance(scanner);
        }

    }

    private Double[] getAmountToAdd(Scanner scanner) {
        try {
            outputMethods.amountToAddPrompt();
            String input = scanner.nextLine();

            return sanitizer.typeAndAmountOfMoney(input);
        } catch (NumberFormatException nfe) {
            return getAmountToAdd(scanner);
        }
    }

    private Double[] getAmountToSubtract(Scanner scanner) {
        try {
            outputMethods.amountToWithdrawPrompt();
            String input = scanner.nextLine();

            return sanitizer.typeAndAmountOfMoney(input);
        } catch (NumberFormatException nfe) {
            return getAmountToSubtract(scanner);
        }
    }

    private Double[] getAmountToTransfer(Scanner scanner) {
        try {
            outputMethods.amountToTransferPrompt();
            String input = scanner.nextLine();

            return sanitizer.typeAndAmountOfMoney(input);
        } catch (NumberFormatException nfe) {
            return getAmountToTransfer(scanner);
        }
    }

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
