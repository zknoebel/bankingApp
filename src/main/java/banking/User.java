package banking;

import java.util.Scanner;

public interface User {

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    int getCurrencyType();

    void setCurrencyType(int currencyType);

    boolean isAdmin();

    void setAdmin(boolean admin);

    void add(AccountManager accountManager, Scanner scanner);

    void adduser (AccountManager accountManager, Scanner scanner) throws IllegalAccessException;

    void account(AccountManager accountManager, Scanner scanner);

    void conversions(CurrencyConverter currencyConverter)throws IllegalAccessException;

    void create(AccountManager accountManager, Scanner scanner);

    void delete(AccountManager accountManager, Scanner scanner);

    void deluser(AccountManager accountManager, Scanner scanner)throws IllegalAccessException;

    void help(OutputMethods outputMethods);

    CurrencyConverter maint(CurrencyConverter currencyConverter, AccountManager accountManager, Scanner scanner)throws IllegalAccessException;

    void list(AccountManager accountManager)throws IllegalAccessException;

    void subtract(AccountManager accountManager, Scanner scanner);

    void transfer(AccountManager accountManager, Scanner scanner);

    void withdraw(AccountManager accountManager, Scanner scanner);
}
