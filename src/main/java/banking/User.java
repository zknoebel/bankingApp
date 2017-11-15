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

        accountManager.addFunds(scanner);
    }

    //todo
    void adduser() {
        //add user to database
        //set user's preferred currency to CurrencyType
        //set the user's password
        //save the password (hashed with salt)
        //ex [username, salt, hashed password]
    }

    void account(AccountManager accountManager, Scanner scanner) {
        accountManager.manageAccount(scanner);
    }

    void conversions(CurrencyConverter currencyConverter) {
        System.out.println(currencyConverter.toString());
    }

    void create(AccountManager accountManager, Scanner scanner) {
        accountManager.makeAccount(scanner);
    }

    void delete(AccountManager accountManager, Scanner scanner) {
        accountManager.deleteAccount(scanner);
    }

    //todo
    void deluser() {
        //delete user from database
    }

    void help(OutputMethods outputMethods) {
        outputMethods.helpScreen();
    }

    CurrencyConverter maint(CurrencyConverter currencyConverter, AccountManager accountManager, Scanner scanner) {
        System.out.println(currencyConverter.toString());
        return accountManager.updateCurrencyWeights(scanner);
    }

    void list(AccountManager accountManager) {
        accountManager.showAllAccounts();
    }

    //todo add to help menu
    void subtract(AccountManager accountManager, Scanner scanner) {
        accountManager.subtractFunds(scanner);
    }

    void transfer(AccountManager accountManager, Scanner scanner) {
        accountManager.transferFunds(scanner);
    }

    void withdraw(AccountManager accountManager, Scanner scanner) {
        subtract(accountManager, scanner);
    }
}
