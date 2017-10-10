package banking;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean end = false;
        Scanner scanner = new Scanner(System.in);

        AccountManager accountManager = new AccountManager();
        CurrencyConverter currencyConverter = new CurrencyConverter();
        OutputMethods outputMethods = new OutputMethods();
        Sanitizer sanitizer = new Sanitizer();

        outputMethods.startScreen();

        while (!end) {
            System.out.print("\nEnter an option: ");

            String input = scanner.nextLine();
            String option = sanitizer.mainLoop(input.toUpperCase());

            switch (option) {
                case "ADD":
                    accountManager.addFunds(scanner);
                    break;

                case "ACCOUNT":
                    accountManager.manageAccount(scanner);
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
                    currencyConverter.weightManger(scanner);
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
                    outputMethods.printInvalidMenuInput();
            }

        }

    }
}
