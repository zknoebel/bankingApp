package banking;

public class OutputMethods {
    public OutputMethods() {
        //empty
    }

    public void startScreen() {
        printTitleArt();
    }

    public void helpScreen() {
        printOptionsArt();
        printOptions();
    }

    public void printTitleArt() {

        System.out.print(
                " ______   _______  _        _       _________ _        _______        _______  _______  _______\n"
                        + "(  ___ \\ (  ___  )( (    /|| \\    /\\\\__   __/( (    /|(  ____ \\      (  ___  )(  ____ )(  ____ )\n"
                        + "| (   ) )| (   ) ||  \\  ( ||  \\  / /   ) (   |  \\  ( || (    \\/      | (   ) || (    )|| (    )|\n"
                        + "| (__/ / | (___) ||   \\ | ||  (_/ /    | |   |   \\ | || |            | (___) || (____)|| (____)|\n"
                        + "|  __ (  |  ___  || (\\ \\) ||   _ (     | |   | (\\ \\) || | ____       |  ___  ||  _____)|  _____)\n"
                        + "| (  \\ \\ | (   ) || | \\   ||  ( \\ \\    | |   | | \\   || | \\_  )      | (   ) || (      | (\n"
                        + "| )___) )| )   ( || )  \\  ||  /  \\ \\___) (___| )  \\  || (___) |      | )   ( || )      | )      \n"
                        + "(______/ |/     \\||/    )_)|_/    \\/\\_______/|/    )_)(_______)      |/     \\||/       |/       \n\n"
        );
    }

    public void printOptionsArt() {
        System.out.print(
                " _______  _______ __________________ _______  _        _______ \n" +
                        "(  ___  )(  ____ )\\__   __/\\__   __/(  ___  )( (    /|(  ____ \\\n" +
                        "| (   ) || (    )|   ) (      ) (   | (   ) ||  \\  ( || (    \\/\n" +
                        "| |   | || (____)|   | |      | |   | |   | ||   \\ | || (_____ \n" +
                        "| |   | ||  _____)   | |      | |   | |   | || (\\ \\) |(_____  )\n" +
                        "| |   | || (         | |      | |   | |   | || | \\   |      ) |\n" +
                        "| (___) || )         | |   ___) (___| (___) || )  \\  |/\\____) |\n" +
                        "(_______)|/          )_(   \\_______/(_______)|/    )_)\\_______)\n\n"
        );
    }

    public void printOptions() {
        System.out.println("ADD - Add money to an account.");
        System.out.println("ACCOUNT - Modify account information.");
        System.out.println("CREATE - Create a new bank account.");
        System.out.println("DELETE - Remove account from database. (CANNOT BE UNDONE)");
        System.out.println("EXIT - Close program.");
        System.out.println("HELP - Display options.");
        System.out.println("MAINT - Allow currency conversion data to be entered (or read in).");
        System.out.println("LIST - Print a list of all current accounts.");
        System.out.println("TRANSFER - Move funds from one account to another.");
        System.out.println("WITHDRAW - Remove money from an account.");
    }

    public void printInvalidMenuInput() {
        System.out.println("Invalid input...");
        System.out.println("Enter one of the options and then press enter.");
        System.out.println("Input should be one word and only contain letters from the English alphabet.");
        System.out.println("For a list of options type HELP and press enter.");
    }

    public void printInvalidAccountNumber() {
        System.out.println("Invalid account number...");
        System.out.println("Enter an account number and press enter.");
        System.out.println("Input should be one number and only contain digits from the Arabic numeral system.");
    }

    public void printInvalidAccountBalance() {
        System.out.println("Invalid account balance...");
        System.out.println("Enter an account balance and press enter.");
        System.out.println("Input should be one number.");
        System.out.println("The balance should only contain digits from the Arabic numeral system and a period as a decimal separator");
    }

    public void printNoAccount(Long accountNumber) {
        System.out.println("There is no existing account with the account number: " + accountNumber);
        System.out.println("Use the LIST command to print a list of existing accounts.");
    }

    public void printAccountNumberPrompt() {
        System.out.print("\nPlease enter an account number: ");
    }

    public void printAccountBalancePrompt() {
        System.out.print("\nPlease enter the balance for this account: ");
    }

    public void printCurrencyTypePrompt() {
        System.out.println("Supported currencies...");
        System.out.println("\tDOLLAR");
        System.out.println("\tEURO");
        System.out.println("\tYEN");
        System.out.print("\nPlease enter a currency type: ");
    }

}
