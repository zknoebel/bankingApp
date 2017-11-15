package banking;

import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private int currencyType;
    private boolean admin = false;

    User(String username, String password, int currencyType) {
        this.username = username;
        this.password = password;
        this.currencyType = currencyType;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(int currencyType) {
        this.currencyType = currencyType;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    void add(AccountManager accountManager, Scanner scanner) {
        //todo only allow adding to user's account
//        accountManager.addFunds(scanner);
    }

    void adduser() throws IllegalAccessException {
        throw new IllegalAccessException("Not Admin");
    }

    void account(AccountManager accountManager, Scanner scanner) {
        //todo only only allow access to accounts for signed in user
//        accountManager.manageAccount(scanner);
    }

    void conversions(CurrencyConverter currencyConverter) throws IllegalAccessException {
        throw new IllegalAccessException("Not Admin");
    }

    void create(AccountManager accountManager, Scanner scanner) {
        //todo only allow creation of accounts for signed in user
//        accountManager.makeAccount(scanner);
    }

    void delete(AccountManager accountManager, Scanner scanner) {
        //todo only allow deletion of accounts for signed in user
//        accountManager.deleteAccount(scanner);
    }

    //todo
    void deluser() throws IllegalAccessException {
        throw new IllegalAccessException("Not Admin");
    }

    void help(OutputMethods outputMethods) {
        outputMethods.helpScreen();
    }

    CurrencyConverter maint(CurrencyConverter currencyConverter, AccountManager accountManager, Scanner scanner) throws IllegalAccessException {
        throw new IllegalAccessException("Not Admin");
    }

    void list(AccountManager accountManager) throws IllegalAccessException {
        throw new IllegalAccessException("Not Admin");
    }

    void subtract(AccountManager accountManager, Scanner scanner) {
        //todo only allow subtraction from user's account
//        accountManager.subtractFunds(scanner);
    }

    void transfer(AccountManager accountManager, Scanner scanner) {
//        accountManager.transferFunds(scanner);
        //todo only allow transfer from user's account
    }

    void withdraw(AccountManager accountManager, Scanner scanner) {
        subtract(accountManager, scanner);
    }
}
