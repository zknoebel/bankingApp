package banking;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;

public interface User {
    // IllegalAccessExceptions are for when non-admin users try to use admin functions.

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    int getCurrencyType();

    void setCurrencyType(int currencyType);

    boolean isAdmin();

    int getSalt();

    void setSalt(int salt);

    void setAdmin(boolean admin);

    void add(AccountManager accountManager, Scanner scanner);

    // NoSuchAlgorithmException is for the hashing method of the password
    void adduser(AccountManager accountManager, Scanner scanner) throws IllegalAccessException, NoSuchAlgorithmException;

    void account(AccountManager accountManager, Scanner scanner);

    void conversions(CurrencyConverter currencyConverter) throws IllegalAccessException;

    void create(AccountManager accountManager, Scanner scanner) throws IllegalAccessException;

    void delete(AccountManager accountManager, Scanner scanner) throws IllegalAccessException;

    void deluser(AccountManager accountManager, Scanner scanner) throws IllegalAccessException;

    void help(OutputMethods outputMethods);

    CurrencyConverter maint(CurrencyConverter currencyConverter, AccountManager accountManager, Scanner scanner) throws IllegalAccessException;

    List<Object> list(AccountManager accountManager, boolean print) throws IllegalAccessException;

    void subtract(AccountManager accountManager, Scanner scanner);

    void transfer(AccountManager accountManager, Scanner scanner);

    void withdraw(AccountManager accountManager, Scanner scanner);
}
