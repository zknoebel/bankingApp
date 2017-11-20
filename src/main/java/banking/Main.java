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

        User user = new AdminUser("root", "toor", 0);
        user.setAdmin(true);

        if (!(accountManager.allUsers(false) == null)) {
            user = new AnonymousUser();
        }

        CurrencyConverter currencyConverter = accountManager.checkForCurrencyConverter();

        outputMethods.startScreen();

        while (!end) {
            System.out.print("\nEnter an option: ");

            String input = scanner.nextLine();
            String option = sanitizer.lettersOnlyString(input);

            //when input comes in, it gets turned to all caps, so you can think of it as non-case-sensitive
            switch (option) {
                case "ADD":
                    user.add(accountManager, scanner);
                    break;

                case "ADDUSER":
                    try {
                        user.adduser(accountManager, scanner);
                    } catch (IllegalAccessException iae) {
                        outputMethods.userNotAdmin();
                    }
                    break;

                case "ACCOUNT":
                    user.account(accountManager, scanner);
                    break;

                case "CONVERSIONS":
                    try {
                        user.conversions(currencyConverter);
                    } catch (IllegalAccessException iae) {
                        outputMethods.userNotAdmin();
                    }
                    break;

                case "CREATE":
                    try {
                        user.create(accountManager, scanner);
                    } catch (IllegalAccessException iae) {
                        outputMethods.userNotAdmin();
                    }
                    break;

                case "DELETE":
                    try {
                        user.delete(accountManager, scanner);
                    } catch (IllegalAccessException iae) {
                        outputMethods.userNotAdmin();
                    }
                    break;

                case "DELUSER":
                    try {
                        //delete user from database
                        user.deluser(accountManager, scanner);
                    } catch (IllegalAccessException iae) {
                        outputMethods.userNotAdmin();
                    }
                    break;

                case "EXIT":
                    accountManager.closeEntityManger();
                    end = true;
                    break;

                case "HELP":
                    user.help(outputMethods);
                    break;

                case "LOGIN":
                    user = accountManager.login(scanner);
                    break;

                case "LOGOUT":
                    user = accountManager.logout();
                    break;

                case "MAINT":
                    try {
                        currencyConverter = user.maint(currencyConverter, accountManager, scanner);
                    } catch (IllegalAccessException iae) {
                        outputMethods.userNotAdmin();
                    }
                    break;

                case "LIST":
                    try {
                        user.list(accountManager, true);
                    } catch (IllegalAccessException iae) {
                        outputMethods.userNotAdmin();
                    }
                    break;

                case "SUBTRACT":
                    user.subtract(accountManager, scanner);
                    break;

                case "TRANSFER":
                    user.transfer(accountManager, scanner);
                    break;

                case "WITHDRAW":
                    user.withdraw(accountManager, scanner);
                    break;

                default:
                    outputMethods.invalidMenuInput();
            }

        }

    }
}
