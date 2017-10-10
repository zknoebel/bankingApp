package banking;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class AccountManager {
    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("$objectdb/db/bankingApp.odb");
    EntityManager entityManager;


    Sanitizer sanitizer = new Sanitizer();
    OutputMethods outputMethods = new OutputMethods();

    public AccountManager() {
        entityManager = emfactory.createEntityManager();
        entityManager.getTransaction().begin();

    }

    public void addFunds(Scanner scanner) {
        //todo
    }

    public void makeAccount(Scanner scanner) {
        long accountNumber = getAccountNumber(scanner);
        Account account = new Account(accountNumber);

        int currencyType = getAccountCurrencyType(scanner);
        account.setCurrencyType(currencyType);

        Double balance = getAccountBalance(scanner);
        account.setBalance(balance);

        saveAccount(account);
    }

    public void closeEntityManger(){
        entityManager.close();
        emfactory.close();
    }

    public void manageAccount(Scanner scanner) {
        //todo
    }

    public void transferFunds(Scanner scanner) {
        //todo
    }

    public void subtractFunds(Scanner scanner) {
        //todo
    }

    public void showAllAccounts() {

        Query ql = entityManager.createQuery("SELECT a FROM Account a");
        List<Account> accounts = ql.getResultList();
        for(Account a : accounts) {
            System.out.print(a);
        }
    }

    private Account findAccount(long id) {
        //todo
        return null;
    }

    private void saveAccount(Account account) {
        entityManager.persist(account);
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();

        //todo
    }

    private long getAccountNumber(Scanner scanner) {
        try {
            outputMethods.printAccountNumberPrompt();
            String input = scanner.nextLine();
            long accountNumber = sanitizer.accountNumber(input);


            System.out.print("Account Number: ");
            System.out.println(accountNumber);

            return accountNumber;

        } catch (NumberFormatException nfe) {
            return getAccountNumber(scanner);
        }

    }

    private Double getAccountBalance(Scanner scanner) {
        try{
            outputMethods.printAccountBalancePrompt();
            String input = scanner.nextLine();
            Double accountBalance = sanitizer.accountBalance(input);

            System.out.print("Account Balance: ");
            System.out.println(accountBalance);

            return accountBalance;
        }
        catch (NumberFormatException nfe) {
            return getAccountBalance(scanner);
        }

    }

    private int getAccountCurrencyType(Scanner scanner) {
        try {
            outputMethods.printCurrencyTypePrompt();
            String input = scanner.nextLine();
            int currencyType = sanitizer.currencyType(input.toUpperCase());

            System.out.print("Currency Type: ");
            System.out.println(currencyType);

            return currencyType;

        } catch (IllegalArgumentException iae) {
            return getAccountCurrencyType(scanner);
        }

    }
}
