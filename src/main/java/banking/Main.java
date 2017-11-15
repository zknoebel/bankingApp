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
                    accountManager.addFunds(scanner);
                    break;

                    //todo
                case "ADDUSER":
                    //add user to database
                    //set user's preferred currency to CurrencyType
                    //set the user's password
                    //save the password (hashed with salt)
                    //ex [username, salt, hashed password]
                    break;

                case "ACCOUNT":
                    accountManager.manageAccount(scanner);
                    break;

                case "CONVERSIONS":
                    System.out.println(currencyConverter.toString());
                    break;

                case "CREATE":
                    accountManager.makeAccount(scanner);
                    break;

                case "DELETE":
                    accountManager.deleteAccount(scanner);
                    break;

                    //todo
                case "DELUSER":
                    //delete user from database
                    break;

                case "EXIT":
                    accountManager.closeEntityManger();
                    end = true;
                    break;

                case "HELP":
                    outputMethods.helpScreen();
                    break;

                case "MAINT":
                    System.out.println(currencyConverter.toString());
                    currencyConverter = accountManager.updateCurrencyWeights(scanner);
                    break;

                case "LIST":
                    accountManager.showAllAccounts();
                    break;

                    //todo add to help menu
                case "SUBTRACT":
                    accountManager.subtractFunds(scanner);
                    break;

                case "TRANSFER":
                    accountManager.transferFunds(scanner);
                    break;

                case "WITHDRAW":
                    accountManager.subtractFunds(scanner);
                    break;

                default:
                    outputMethods.invalidMenuInput();
            }

        }

    }
}
