package banking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Scanner;

@Entity
@Table()
public class NormalUser implements User {
    @Id
    private String username;

    @Column
    private String password;

    //dollars 0
    //euros 1
    //yen 2
    @Column
    private int currencyType;

    @Column
    private boolean admin = false;

    public NormalUser(){
        username = "not set";
        password = "password";
        currencyType = 0;
    }

    NormalUser(String username, String password, int currencyType) {
        this.username = username;
        this.password = password;
        this.currencyType = currencyType;

    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int getCurrencyType() {
        return currencyType;
    }

    @Override
    public void setCurrencyType(int currencyType) {
        this.currencyType = currencyType;
    }

    @Override
    public boolean isAdmin() {
        return admin;
    }

    @Override
    public void setAdmin(boolean admin) {
        //empty
    }

    @Override
    public void add(AccountManager accountManager, Scanner scanner) {
        //todo only allow adding to user's account
//        accountManager.addFunds(scanner);
    }

    @Override
    public void adduser(AccountManager accountManager, Scanner scanner) throws IllegalAccessException {
        throw new IllegalAccessException("Not AdminUser");
    }

    @Override
    public void account(AccountManager accountManager, Scanner scanner) {
        //todo only only allow access to accounts for signed in user
//        accountManager.manageAccount(scanner);
    }

    @Override
    public void conversions(CurrencyConverter currencyConverter) throws IllegalAccessException {
        throw new IllegalAccessException("Not AdminUser");
    }

    @Override
    public void create(AccountManager accountManager, Scanner scanner) {
        //todo only allow creation of accounts for signed in user
//        accountManager.makeAccount(scanner);
    }

    @Override
    public void delete(AccountManager accountManager, Scanner scanner) {
        //todo only allow deletion of accounts for signed in user
//        accountManager.deleteAccount(scanner);
    }

    //todo
    @Override
    public void deluser(AccountManager accountManager, Scanner scanner) throws IllegalAccessException {
        throw new IllegalAccessException("Not AdminUser");
    }

    @Override
    public void help(OutputMethods outputMethods) {
        outputMethods.helpScreen();
    }

    @Override
    public CurrencyConverter maint(CurrencyConverter currencyConverter, AccountManager accountManager, Scanner scanner) throws IllegalAccessException {
        throw new IllegalAccessException("Not AdminUser");
    }

    @Override
    public void list(AccountManager accountManager) throws IllegalAccessException {
        throw new IllegalAccessException("Not AdminUser");
    }

    @Override
    public void subtract(AccountManager accountManager, Scanner scanner) {
        //todo only allow subtraction from user's account
//        accountManager.subtractFunds(scanner);
    }

    @Override
    public void transfer(AccountManager accountManager, Scanner scanner) {
//        accountManager.transferFunds(scanner);
        //todo only allow transfer from user's account
    }

    @Override
    public void withdraw(AccountManager accountManager, Scanner scanner) {
        subtract(accountManager, scanner);
    }

    @Override
    public String toString() {

        return getUsername() + " : " + getPassword();
    }
}