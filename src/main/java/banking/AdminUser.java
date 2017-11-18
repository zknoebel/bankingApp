package banking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Scanner;

@Entity
public class AdminUser implements User {

    @Id
    private String username;

    @Column
    private String password;

    @Column
    private boolean admin;

    @Column
    private int currencyType;

    protected AdminUser() {
        setAdmin(true);
    }

    AdminUser(String username, String password) {
        this.username = username;
        this.password = password;
        setAdmin(true);

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
        this.admin = admin;
    }

    @Override
    public void add(AccountManager accountManager, Scanner scanner) {
        accountManager.addFunds(scanner);
    }

    //todo
    @Override
    public void adduser(AccountManager accountManager, Scanner scanner) {
        accountManager.makeUser(scanner);
        //add user to database
        //set user's preferred currency to CurrencyType
        //set the user's password
        //save the password (hashed with salt)
        //ex [username, salt, hashed password]
    }


    @Override
    public void account(AccountManager accountManager, Scanner scanner) {
        accountManager.manageAccount(scanner);
    }

    @Override
    public void conversions(CurrencyConverter currencyConverter) {
        System.out.println(currencyConverter.toString());
    }

    @Override
    public void create(AccountManager accountManager, Scanner scanner) {
        accountManager.makeAccount(scanner);
    }

    @Override
    public void delete(AccountManager accountManager, Scanner scanner) {
        accountManager.deleteAccount(scanner);
    }

    @Override
    public void deluser(AccountManager accountManager, Scanner scanner) {
        accountManager.deleteUser(scanner);
    }

    @Override
    public void help(OutputMethods outputMethods) {
        outputMethods.helpScreen();

    }

    @Override
    public CurrencyConverter maint(CurrencyConverter currencyConverter, AccountManager accountManager, Scanner scanner) {
        System.out.println(currencyConverter.toString());
        return accountManager.updateCurrencyWeights(scanner);
    }

    @Override
    public void list(AccountManager accountManager) {
        accountManager.showAllUsers();
        accountManager.showAllAccounts();
    }


    @Override
    public void subtract(AccountManager accountManager, Scanner scanner) {
        accountManager.subtractFunds(scanner);
    }

    @Override
    public void transfer(AccountManager accountManager, Scanner scanner) {
        accountManager.transferFunds(scanner);
    }

    @Override
    public void withdraw(AccountManager accountManager, Scanner scanner) {
        subtract(accountManager, scanner);
    }

    @Override
    public String toString() {

        return "Administrator - " + getUsername() + " : " + getPassword();
    }
}
