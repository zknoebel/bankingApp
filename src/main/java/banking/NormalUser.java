package banking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
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

    @Column
    private int salt;

    public NormalUser() {
        username = "not set";
        password = "password";
        currencyType = 0;
    }

    NormalUser(String username, String password, int currencyType, int salt) {
        this.username = username;
        this.password = password;
        this.currencyType = currencyType;
        this.salt = salt;

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
    public int getSalt() {
        return salt;
    }

    @Override
    public void setSalt(int salt) {
        this.salt = salt;
    }

    @Override
    //adds money to a bank account owned by the user
    public void add(AccountManager accountManager, Scanner scanner) {
        accountManager.addFunds(scanner, this);
    }

    @Override
    //admins only
    public void adduser(AccountManager accountManager, Scanner scanner) throws IllegalAccessException {
        throw new IllegalAccessException("Not AdminUser");
    }

    @Override
    //changes attributes of a bank account belonging to the user
    public void account(AccountManager accountManager, Scanner scanner) {
        //todo change currency type not username
        accountManager.manageAccount(scanner, this);
    }

    @Override
    //admins only
    public void conversions(CurrencyConverter currencyConverter) throws IllegalAccessException {
        throw new IllegalAccessException("Not AdminUser");
    }

    @Override
    //admins only
    public void create(AccountManager accountManager, Scanner scanner) throws IllegalAccessException {
        throw new IllegalAccessException("Not AdminUser");
    }

    @Override
    //admins only
    public void delete(AccountManager accountManager, Scanner scanner) throws IllegalAccessException {
        throw new IllegalAccessException("Not AdminUser");
    }

    @Override
    //admins only
    public void deluser(AccountManager accountManager, Scanner scanner) throws IllegalAccessException {
        throw new IllegalAccessException("Not AdminUser");
    }

    @Override
    //prints options
    public void help(OutputMethods outputMethods) {
        outputMethods.normalHelpScreen();
    }

    @Override
    //admins only
    public CurrencyConverter maint(CurrencyConverter currencyConverter, AccountManager accountManager, Scanner scanner) throws IllegalAccessException {
        throw new IllegalAccessException("Not AdminUser");
    }

    @Override
    //lists all bank accounts belonging to the user
    public List<Object> list(AccountManager accountManager, boolean print) throws IllegalAccessException {
        List<Object> lists = new ArrayList<>();
        List<Account> accounts = accountManager.allAccounts(false);
        List<Account> myAccounts = new ArrayList<>();

        lists.add(new ArrayList<>());

        for (Account account : accounts) {
            if (account.getUsername().equals(this.username)) {
                System.out.print(account);
                myAccounts.add(account);
            }
        }

        lists.add(myAccounts);

        return lists;
    }

    @Override
    //take money out of a bank account belonging to the user
    public void subtract(AccountManager accountManager, Scanner scanner) {
        accountManager.subtractFunds(scanner, this);
    }

    @Override
    //move money from one bank account, beloinging to the user, to an other bank account
    public void transfer(AccountManager accountManager, Scanner scanner) {
        accountManager.transferFunds(scanner, this);
    }

    @Override
    //same as subtract
    public void withdraw(AccountManager accountManager, Scanner scanner) {
        subtract(accountManager, scanner);
    }

    @Override
    public String toString() {

        return "Normal User   - " + getUsername() + ":" + getSalt() + ":" + getPassword();
    }
}
