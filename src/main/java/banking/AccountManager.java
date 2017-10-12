package banking;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
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

    void addFunds(Scanner scanner) {

        Account account = validateAccount(null, scanner);

        int currencyType = getAccountCurrencyType(scanner);

        Double amountToAdd = getAmountToAdd(scanner);

        add(currencyType, account, amountToAdd);
    }

    private void add(int currencyType, Account account, Double amountToAdd) {
        Double convertedAmount = currencyConverter.convert(currencyType, account.getCurrencyType(), amountToAdd);

        Double newBalance = account.getBalance() + convertedAmount;
        account.setBalance(newBalance);

        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();

    }

    void makeAccount(Scanner scanner) {

        long accountNumber = getAccountNumber(scanner);
        Account testAccount = findAccount(accountNumber);

        if (testAccount == null) {
            Account account = new Account(accountNumber);

            int currencyType = getAccountCurrencyType(scanner);
            account.setCurrencyType(currencyType);

            Double balance = getAccountBalance(scanner);
            account.setBalance(balance);

            String username = getUsername(scanner);
            account.setUsername(username);

            saveAccount(account);
        } else {
            outputMethods.accountNumberInUse();
        }

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
        outputMethods.accountNumberPrompt();

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

    private void updateUsername(Account account, Scanner scanner) {
        String username = getUsername(scanner);

        account.setUsername(username);

        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
    }

    void transferFunds(Scanner scanner) {
        //get account to take from
        Account accountToTransferFrom = getAccountToTransferFrom(scanner);
        //get account to add to
        Account accountToTransferTo = getAccountToTransferTo(scanner);
        //get currency type
        int currencyType = getAccountCurrencyType(scanner);
        //get amount
        Double amount = getAmountToTransfer(scanner);
        subtract(currencyType, accountToTransferFrom, amount);
        add(currencyType, accountToTransferTo, amount);
    }

    private Account getAccountToTransferFrom(Scanner scanner) {
        outputMethods.accountToTransferFromPrompt();
        return validateAccount(null, scanner);
    }

    private Account getAccountToTransferTo(Scanner scanner) {
        outputMethods.accountToTransferToPrompt();
        return validateAccount(null, scanner);
    }

    private Double getAmountToTransfer(Scanner scanner) {

        try {
            outputMethods.amountToTransferPrompt();
            String input = scanner.nextLine();
            Double amountToTransfer = sanitizer.accountBalance(input);

            return amountToTransfer;
        } catch (NumberFormatException nfe) {
            return getAmountToTransfer(scanner);
        }
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

    void subtractFunds(Scanner scanner) {
        Account account = validateAccount(null, scanner);

        int currencyType = getAccountCurrencyType(scanner);

        Double amountToSubtract = getAmountToSubtract(scanner);

        subtract(currencyType, account, amountToSubtract);
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

        Query ql = entityManager.createQuery("SELECT a FROM Account a");
        List<Account> accounts = ql.getResultList();
        for (Account a : accounts) {
            System.out.print(a);
        }
    }

    private Account findAccount(long id) {
        return entityManager.find(Account.class, id);
    }

    private void saveAccount(Account account) {
        entityManager.persist(account);
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
    }

    private long getAccountNumber(Scanner scanner) {
        try {
            outputMethods.accountNumberPrompt();
            String input = scanner.nextLine();
            long accountNumber = sanitizer.accountNumber(input);

            return accountNumber;

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

    private Double getAccountBalance(Scanner scanner) {
        try {
            outputMethods.accountBalancePrompt();
            String input = scanner.nextLine();
            Double accountBalance = sanitizer.accountBalance(input);

            return accountBalance;
        } catch (NumberFormatException nfe) {
            return getAccountBalance(scanner);
        }

    }

    private Double getAmountToAdd(Scanner scanner) {
        try {
            outputMethods.amountToAddPrompt();
            String input = scanner.nextLine();
            Double amountToAdd = sanitizer.accountBalance(input);

            return amountToAdd;
        } catch (NumberFormatException nfe) {
            return getAmountToAdd(scanner);
        }
    }

    private Double getAmountToSubtract(Scanner scanner) {
        try {
            outputMethods.amountToWithdrawPrompt();
            String input = scanner.nextLine();
            Double amountToSubtract = sanitizer.accountBalance(input);

            return amountToSubtract;
        } catch (NumberFormatException nfe) {
            return getAmountToSubtract(scanner);
        }
    }

    private int getAccountCurrencyType(Scanner scanner) {
        try {
            outputMethods.currencyTypePrompt();
            String input = scanner.nextLine();
            int currencyType = sanitizer.currencyType(input.toUpperCase());

            return currencyType;

        } catch (IllegalArgumentException iae) {
            return getAccountCurrencyType(scanner);
        }

    }
}
