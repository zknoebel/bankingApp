package banking;

import java.util.List;
import java.util.Scanner;

public class AnonymousUser implements User{
    OutputMethods outputMethods = new OutputMethods();

    @Override
    public String getUsername() {
        outputMethods.mustLogIn();
        return null;
    }

    @Override
    public void setUsername(String username) {
        outputMethods.mustLogIn();
    }

    @Override
    public String getPassword() {
        outputMethods.mustLogIn();
        return null;
    }

    @Override
    public void setPassword(String password) {
        outputMethods.mustLogIn();
    }

    @Override
    public int getCurrencyType() {
        outputMethods.mustLogIn();
        return -1;
    }

    @Override
    public void setCurrencyType(int currencyType) {
        outputMethods.mustLogIn();
    }

    @Override
    public boolean isAdmin() {
        return false;
    }

    @Override
    public void setAdmin(boolean admin) {
        outputMethods.mustLogIn();
    }

    @Override
    public int getSalt() {
        return -1;
    }

    @Override
    public void setSalt(int salt) {
        //empty
    }

    @Override
    public void add(AccountManager accountManager, Scanner scanner) {
        outputMethods.mustLogIn();
    }

    @Override
    public void adduser(AccountManager accountManager, Scanner scanner) throws IllegalAccessException {
        outputMethods.mustLogIn();
    }

    @Override
    public void account(AccountManager accountManager, Scanner scanner) {
        outputMethods.mustLogIn();
    }

    @Override
    public void conversions(CurrencyConverter currencyConverter) throws IllegalAccessException {
        outputMethods.mustLogIn();
    }

    @Override
    public void create(AccountManager accountManager, Scanner scanner) {
        outputMethods.mustLogIn();
    }

    @Override
    public void delete(AccountManager accountManager, Scanner scanner) {
        outputMethods.mustLogIn();
    }

    @Override
    public void deluser(AccountManager accountManager, Scanner scanner) throws IllegalAccessException {
        outputMethods.mustLogIn();
    }

    @Override
    public void help(OutputMethods outputMethods) {
        outputMethods.mustLogIn();
    }

    @Override
    public CurrencyConverter maint(CurrencyConverter currencyConverter, AccountManager accountManager, Scanner scanner) throws IllegalAccessException {
        outputMethods.mustLogIn();
        return null;
    }

    @Override
    public List<Object> list(AccountManager accountManager, boolean print) throws IllegalAccessException {
        outputMethods.mustLogIn();
        throw new IllegalAccessException("Not administrator");
    }

    @Override
    public void subtract(AccountManager accountManager, Scanner scanner) {
        outputMethods.mustLogIn();
    }

    @Override
    public void transfer(AccountManager accountManager, Scanner scanner) {
        outputMethods.mustLogIn();
    }

    @Override
    public void withdraw(AccountManager accountManager, Scanner scanner) {
        outputMethods.mustLogIn();
    }
}
