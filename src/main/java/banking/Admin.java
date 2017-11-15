package banking;

import java.util.Scanner;

public class Admin extends User {
    Admin(String username, String password, int currencyType) {
        super(username, password, currencyType);
        super.setAdmin(true);
    }


    //todo
    void adduser() {
        //add user to database
        //set user's preferred currency to CurrencyType
        //set the user's password
        //save the password (hashed with salt)
        //ex [username, salt, hashed password]
    }

    @Override
    void account(AccountManager accountManager, Scanner scanner) {
        accountManager.manageAccount(scanner);
    }

    @Override
    void conversions(CurrencyConverter currencyConverter) {
        System.out.println(currencyConverter.toString());
    }

    @Override
    void create(AccountManager accountManager, Scanner scanner) {
        accountManager.makeAccount(scanner);
    }

    @Override
    void delete(AccountManager accountManager, Scanner scanner) {
        accountManager.deleteAccount(scanner);
    }

    //todo
    @Override
    void deluser() {
        //delete user from database
    }

    @Override
    CurrencyConverter maint(CurrencyConverter currencyConverter, AccountManager accountManager, Scanner scanner) {
        System.out.println(currencyConverter.toString());
        return accountManager.updateCurrencyWeights(scanner);
    }

    @Override
    void list(AccountManager accountManager) {
        accountManager.showAllAccounts();
    }

    @Override
    void subtract(AccountManager accountManager, Scanner scanner) {
        accountManager.subtractFunds(scanner);
    }

    @Override
    void transfer(AccountManager accountManager, Scanner scanner) {
        accountManager.transferFunds(scanner);
    }

}
