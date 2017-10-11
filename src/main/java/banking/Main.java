package banking;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean end = false;
        Scanner scanner = new Scanner(System.in);

        AccountManager accountManager = new AccountManager();
        OutputMethods outputMethods = new OutputMethods();
        Sanitizer sanitizer = new Sanitizer();

        CurrencyConverter currencyConverter = accountManager.checkForCurrencyConverter();

        outputMethods.startScreen();

        while (!end) {
            System.out.print("\nEnter an option: ");

            String input = scanner.nextLine();
            String option = sanitizer.lettersOnlyString(input.toUpperCase());

            switch (option) {
                case "ADD":
                    accountManager.addFunds(scanner);
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
                    //todo error when no accounts have been saved
                    accountManager.showAllAccounts();
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
