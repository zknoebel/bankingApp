package banking;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean end = false;
        boolean anon = true;
        Scanner scanner = new Scanner(System.in);

        AccountManager accountManager = new AccountManager();
        OutputMethods outputMethods = new OutputMethods();
        Sanitizer sanitizer = new Sanitizer();

        //todo make users sign in
        User user = new User("root", "toor", 0);
        user.setAdmin(true);

        CurrencyConverter currencyConverter = accountManager.checkForCurrencyConverter();

        outputMethods.startScreen();

        //todo make user login
        while(anon) {



        }

        while (!end) {
            System.out.print("\nEnter an option: ");

            String input = scanner.nextLine();
            String option = sanitizer.lettersOnlyString(input);

            //when input comes in, it gets turned to all caps, so you can think of it as non-case-sensitive
            switch (option) {
                case "ADD":
                    user.add(accountManager, scanner);
                    break;

                    //todo
                case "ADDUSER":
                    if(user.isAdmin()) {
                        user.adduser();
                    }
                    break;

                case "ACCOUNT":
                    user.account(accountManager, scanner);
                    break;

                case "CONVERSIONS":
                    user.conversions(currencyConverter);
                    break;

                case "CREATE":
                        user.create(accountManager, scanner);
                    break;

                case "DELETE":
                        user.delete(accountManager, scanner);
                    break;

                    //todo
                case "DELUSER":
                    if(user.isAdmin()) {
                        //delete user from database
                        user.deluser();
                    }
                    break;

                case "EXIT":
                    accountManager.closeEntityManger();
                    end = true;
                    break;

                case "HELP":
                    user.help(outputMethods);
                    break;

                case "MAINT":
                    if(user.isAdmin()) {
                        currencyConverter = user.maint(currencyConverter, accountManager, scanner);
                    }
                    break;

                case "LIST":
                    if(user.isAdmin()) {
                        user.list(accountManager);
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
