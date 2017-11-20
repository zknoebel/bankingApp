package banking;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchAlgorithmException {
        boolean end = false;
        Scanner scanner = new Scanner(System.in);

        AccountManager accountManager = new AccountManager();
        OutputMethods outputMethods = new OutputMethods();
        Sanitizer sanitizer = new Sanitizer();

        User user = new AdminUser("temproot", "temproot", 0);
        user.setAdmin(true);

        if (!(accountManager.allUsers(false) == null)) {
            user = new AnonymousUser();
        }

        //If there is a currency converter in the database, use that one, otherwise make a new one.
        CurrencyConverter currencyConverter = accountManager.checkForCurrencyConverter();

        //print the banking app art
        outputMethods.startScreen();

        //loop until user types EXIT
        while (!end) {
            System.out.print("\nEnter an option: ");

            String input = scanner.nextLine();
            String option = sanitizer.lettersOnlyString(input);

            //when input comes in, it gets turned to all caps, so you can think of it as non-case-sensitive
            switch (option) {
                //add money to a bank account
                case "ADD":
                    user.add(accountManager, scanner);
                    break;

                    //add a new user
                case "ADDUSER":
                    try {
                        user.adduser(accountManager, scanner);
                    } catch (IllegalAccessException iae) {
                        outputMethods.userNotAdmin();
                    }
                    break;

                    //change account attributes ie. account number or preferred currency type
                case "ACCOUNT":
                    user.account(accountManager, scanner);
                    break;

                    //show conversion ratios
                case "CONVERSIONS":
                    try {
                        user.conversions(currencyConverter);
                    } catch (IllegalAccessException iae) {
                        outputMethods.userNotAdmin();
                    }
                    break;

                    //create bank account
                case "CREATE":
                    try {
                        user.create(accountManager, scanner);
                    } catch (IllegalAccessException iae) {
                        outputMethods.userNotAdmin();
                    }
                    break;

                    //delete bank account
                case "DELETE":
                    try {
                        user.delete(accountManager, scanner);
                    } catch (IllegalAccessException iae) {
                        outputMethods.userNotAdmin();
                    }
                    break;

                //delete user from database
                case "DELUSER":
                    try {
                        user.deluser(accountManager, scanner);
                    } catch (IllegalAccessException iae) {
                        outputMethods.userNotAdmin();
                    }
                    break;

                    //close program
                case "EXIT":
                    accountManager.closeEntityManger();
                    end = true;
                    break;

                    //show options
                case "HELP":
                    user.help(outputMethods);
                    break;

                //type username and password to login
                //if there are no users in the database, you will start logged in as an administrator
                case "LOGIN":
                    user = accountManager.login(scanner);
                    break;

                //logs the user out
                //they must exit or log back in to continue
                case "LOGOUT":
                    user = accountManager.logout();
                    break;

                //change the ratios in the currency converter
                case "MAINT":
                    try {
                        currencyConverter = user.maint(currencyConverter, accountManager, scanner);
                    } catch (IllegalAccessException iae) {
                        outputMethods.userNotAdmin();
                    }
                    break;

                //show all accounts and user if the user is an admin
                //show all of the user's accounts if the user is a normal user
                case "LIST":
                    try {
                        user.list(accountManager, true);
                    } catch (IllegalAccessException iae) {
                        outputMethods.userNotAdmin();
                    }
                    break;

                //take money out of account
                case "SUBTRACT":
                    user.subtract(accountManager, scanner);
                    break;

                //move money from one account to another
                case "TRANSFER":
                    user.transfer(accountManager, scanner);
                    break;

                //take money out of account
                case "WITHDRAW":
                    user.withdraw(accountManager, scanner);
                    break;

                //if the user enters anything but one of the above methods, tell them that they need to try again
                default:
                    outputMethods.invalidMenuInput();
            }

        }

    }
}
