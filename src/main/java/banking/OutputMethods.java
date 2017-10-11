package banking;

class OutputMethods {
    OutputMethods() {
        //empty
    }

    void startScreen() {
        titleArt();
        System.out.println("Enter an option to start: ");
    }

    void helpScreen() {
        optionsArt();
        options();
    }

    void accountScreen(Account account) {
        whatAttributePrompt();

        System.out.println(account);

        System.out.println("Enter attribute: ");
    }

    private void titleArt() {
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

    private void optionsArt() {
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

    private void options() {
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

    void noExistingAccount(Long accountNumber) {
        System.out.println("There is no existing account with the account number: " + accountNumber);
        System.out.println("Use the LIST command to print a list of existing accounts.");
    }

    void accountNumberInUse() {
        System.out.println("The account number you entered is already in use.");
        System.out.println("Please choose another and try again.");
    }

    //////////////////////////////////////////////////////////////
    // Prompts
    //////////////////////////////////////////////////////////////

    void accountNumberPrompt() {
        System.out.print("\nPlease enter an account number: ");
    }

    void accountBalancePrompt() {
        System.out.print("\nPlease enter the balance for this account: ");
    }

    void amountToAddPrompt() {
        System.out.println("\nPlease enter an amount to add: ");
    }

    void amountToWithdrawPrompt() {
        System.out.println("\nPlease enter an amount to withdraw: ");
    }

    void dollarWeightPrompt() {
        System.out.println("Enter the ratio value of how much a Dollar will be worth.");
        weightPrompt();
    }

    void euroWeightPrompt() {
        System.out.println("Enter the ratio value of how much a Euro will be worth.");
        weightPrompt();
    }

    void yenWeightPrompt() {
        System.out.println("Enter the ratio value of how much a Yen will be worth.");
        weightPrompt();
    }

    private void weightPrompt() {
        System.out.println("This value needs to be a number greater than zero.");
        System.out.println("Enter value here");
    }

    void currencyTypePrompt() {
        System.out.println("Supported currencies...");
        System.out.println("\tDOLLAR");
        System.out.println("\tEURO");
        System.out.println("\tYEN");
        System.out.print("\nPlease enter a currency type: ");
    }

    void accountToTransferFromPrompt() {
        System.out.println("Please enter the account number for the account you with to transfer money from.");
        System.out.println("Account number: ");
    }

    void accountToTransferToPrompt() {
        System.out.println("Please enter the account number for the account you with to transfer money to.");
        System.out.println("Account number: ");
    }

    void amountToTransferPrompt() {
        System.out.println("Please enter the amount of money you wish to transfer.");
        System.out.println("Amount: ");
    }

    void usernamePrompt() {
        System.out.println("Please enter the username for this account.");
        System.out.println("Username: ");
    }

    void whatAttributePrompt() {
        System.out.println("What attribute would you like to change?");
        System.out.println("Options are:");
        System.out.println("\tUSERNAME");
    }

    //////////////////////////////////////////////////////////////
    // Invalid input
    //////////////////////////////////////////////////////////////

    void invalidMenuInput() {
        System.out.println("Invalid input...");
        System.out.println("Enter one of the options and then press enter.");
        System.out.println("Input should be one word and only contain letters from the English alphabet.");
        System.out.println("For a list of options type HELP and press enter.");
    }

    void invalidAccountNumber() {
        System.out.println("Invalid account number...");
        System.out.println("Enter an account number and press enter.");
        System.out.println("Input should be one number and only contain digits from the Arabic numeral system.");
    }

    void invalidAccountBalance() {
        System.out.println("Invalid account balance...");
        System.out.println("Enter an account balance and press enter.");
        System.out.println("Input should be one number.");
        System.out.println("The balance should only contain digits from the Arabic numeral system and a period as a decimal separator");
    }

    void invalidCurrencyWeight() {
        System.out.println("Invalid Currency Weight...");
        System.out.println("Enter a Currency Weight and press enter.");
        System.out.println("Input should be one number and should be greater than zero");
        System.out.println("The Currency Weight should only contain digits from the Arabic numeral system and a period as a decimal separator");
    }

    void invalidUsername() {
        System.out.println("The username you entered is invalid.");
        System.out.println("Usernames may only contain letters from the English alphabet.");
        System.out.println("Usernames are not case sensitive.");
    }

}
