package banking;

class OutputMethods {
    OutputMethods() {
        //empty
    }

    void startScreen() {
        printTitleArt();
        System.out.println("Enter an option to start: ");
    }

    void helpScreen() {
        printOptionsArt();
        printOptions();
    }

    private void printTitleArt() {

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

    private void printOptionsArt() {
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

    private void printOptions() {
        System.out.println("ADD - Add money to an account.");
        System.out.println("ACCOUNT - Modify account information.");
        System.out.println("CONVERSIONS - show current currency conversion ratios");
        System.out.println("CREATE - Create a new bank account.");
        System.out.println("DELETE - Remove account from database. (CANNOT BE UNDONE)");
        System.out.println("EXIT - Close program.");
        System.out.println("HELP - Display options.");
        System.out.println("MAINT - Allow currency conversion data to be entered (or read in).");
        System.out.println("LIST - Print a list of all current accounts.");
        System.out.println("TRANSFER - Move funds from one account to another.");
        System.out.println("WITHDRAW - Remove money from an account.");
    }

    void printInvalidMenuInput() {
        System.out.println("Invalid input...");
        System.out.println("Enter one of the options and then press enter.");
        System.out.println("Input should be one word and only contain letters from the English alphabet.");
        System.out.println("For a list of options type HELP and press enter.");
    }

    void printInvalidAccountNumber() {
        System.out.println("Invalid account number...");
        System.out.println("Enter an account number and press enter.");
        System.out.println("Input should be one number and only contain digits from the Arabic numeral system.");
    }

    void printInvalidAccountBalance() {
        System.out.println("Invalid account balance...");
        System.out.println("Enter an account balance and press enter.");
        System.out.println("Input should be one number.");
        System.out.println("The balance should only contain digits from the Arabic numeral system and a period as a decimal separator");
    }

    void printInvalidCurrencyWeight() {
        System.out.println("Invalid Currency Weight...");
        System.out.println("Enter a Currency Weight and press enter.");
        System.out.println("Input should be one number and should be greater than zero");
        System.out.println("The Currency Weight should only contain digits from the Arabic numeral system and a period as a decimal separator");
    }

    void printNoAccount(Long accountNumber) {
        System.out.println("There is no existing account with the account number: " + accountNumber);
        System.out.println("Use the LIST command to print a list of existing accounts.");
    }

    void printAccountNumberPrompt() {
        System.out.print("\nPlease enter an account number: ");
    }

    void printAccountBalancePrompt() {
        System.out.print("\nPlease enter the balance for this account: ");
    }

    void printAmountToAddPrompt() {
        System.out.println("\nPlease enter an amount to add: ");
    }

    void printAmountToSubtractPrompt() {
        System.out.println("\nPlease enter an amount to withdraw: ");
    }

    void printDollarWeightPrompt() {
        System.out.println("Enter the ratio value of how much a Dollar will be worth.");
        printWeightPrompt();
    }

    void printEuroWeightPrompt() {
        System.out.println("Enter the ratio value of how much a Euro will be worth.");
        printWeightPrompt();
    }

    void printYenWeightPrompt() {
        System.out.println("Enter the ratio value of how much a Yen will be worth.");
        printWeightPrompt();
    }

    void printAccountNumberInUse() {
        System.out.println("The account number you entered is already in use.");
        System.out.println("Please choose another and try again.");
    }

    private void printWeightPrompt() {
        System.out.println("This value needs to be a number greater than zero.");
        System.out.println("Enter value here");
    }

    void printCurrencyTypePrompt() {
        System.out.println("Supported currencies...");
        System.out.println("\tDOLLAR");
        System.out.println("\tEURO");
        System.out.println("\tYEN");
        System.out.print("\nPlease enter a currency type: ");
    }

}
