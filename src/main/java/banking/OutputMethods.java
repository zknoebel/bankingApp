package banking;

class OutputMethods {
    OutputMethods() {
        //empty
    }

    void startScreen() {
        titleArt();
        System.out.println("Enter HELP for a list of adminOptions.");
    }

    void adminHelpScreen() {
        optionsArt();
        adminOptions();
    }

    void normalHelpScreen() {
        optionsArt();
        normalOptions();
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

    private void adminOptions() {
        System.out.println("ADD         - Add money to an account.");
        System.out.println("ADDUSER     - Add a new user account.");
        System.out.println("ACCOUNT     - Modify account information.");
        System.out.println("CONVERSIONS - show current currency conversion ratios");
        System.out.println("CREATE      - Create a new bank account.");
        System.out.println("DELETE      - Remove a bank account from database. (CANNOT BE UNDONE)");
        System.out.println("DELUSER     - Remove a user account from the database. (CANNOT BE UNDONE");
        System.out.println("EXIT        - Close program.");
        System.out.println("HELP        - Display adminOptions.");
        System.out.println("MAINT       - Allow currency conversion data to be entered (or read in).");
        System.out.println("LIST        - Print a list of all current accounts.");
        System.out.println("SUBTRACT    - Remove money from an account.");
        System.out.println("TRANSFER    - Move funds from one account to another.");
        System.out.println("WITHDRAW    - Same function as SUBTRACT");
    }

    private void normalOptions() {
        System.out.println("ADD      - Add money to an account.");
        System.out.println("EXIT     - Close program.");
        System.out.println("HELP     - Display options.");
        System.out.println("LIST     - Print a list of all current accounts.");
        System.out.println("SUBTRACT - Remove money from an account.");
        System.out.println("TRANSFER - Move funds from one account to another.");
        System.out.println("WITHDRAW - Remove money from an account.(Same function as SUBTRACT)");
    }

    void noExistingAccount(Long accountNumber) {
        System.out.println("\nThere is no existing account with the account number: " + accountNumber);
        System.out.println("Use the LIST command to print a list of existing accounts.");
    }

    void noExistingUser(String username) {
        System.out.println("\nThere is no existing user with the username: " + username);
        System.out.println("Use the LIST command to print a list of existing users and bank accounts.");
    }

    void accountNumberInUse() {
        System.out.println("\nThe account number you entered is already in use.");
        System.out.println("Please choose another and try again.");
    }

    void usernameInUse() {
        System.out.println("\nThe user name you entered is already in use.");
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
        System.out.println("\nEnter the ratio value of how much a Dollar will be worth.");
        weightPrompt();
    }

    void euroWeightPrompt() {
        System.out.println("\nEnter the ratio value of how much a Euro will be worth.");
        weightPrompt();
    }

    void yenWeightPrompt() {
        System.out.println("\nEnter the ratio value of how much a Yen will be worth.");
        weightPrompt();
    }

    private void weightPrompt() {
        System.out.println("\nThis value needs to be a number greater than zero.");
        System.out.print("Enter value here: ");
    }

    void currencyTypePrompt() {
        System.out.println("\nSupported currencies...");
        System.out.println("\tDOLLAR or $");
        System.out.println("\tEURO or Є");
        System.out.println("\tYEN ¥");
        System.out.print("\nPlease enter a currency type: ");
    }

    void accountToTransferFromPrompt() {
        System.out.println("\nPlease enter the account number for the account you wish to transfer money from.");
    }

    void accountToTransferToPrompt() {
        System.out.println("\nPlease enter the account number for the account you wish to transfer money to.");
    }

    void amountToTransferPrompt() {
        System.out.println("\nPlease enter the amount of money you wish to transfer.");
        System.out.println("Amount: ");
    }

    void usernamePrompt() {
        System.out.println("\nPlease enter the username for this account.");
        System.out.println("Username: ");
    }

    void passwordPrompt() {
        System.out.println("\nPlease enter the password for this account.");
        System.out.println("Password : ");
    }

    void confirmPassword() {
        System.out.println("\nPlease confirm the password for this account.");
        System.out.println("Password : ");
    }

    private void whatAttributePrompt() {
        System.out.println("\nWhat attribute would you like to change?");
        System.out.println("Options are:");
        System.out.println("\tUSERNAME");
    }

    //////////////////////////////////////////////////////////////
    // Invalid input
    //////////////////////////////////////////////////////////////

    void invalidMenuInput() {
        System.out.println("\nInvalid input...");
        System.out.println("Enter one of the adminOptions and then press enter.");
        System.out.println("Input should be one word and only contain letters from the English alphabet.");
        System.out.println("For a list of adminOptions type HELP and press enter.");
    }

    void invalidAccountNumber() {
        System.out.println("\nInvalid account number...");
        System.out.println("Enter an account number and press enter.");
        System.out.println("Input should be one number and only contain digits from the Arabic numeral system.");
    }

    void invalidAccountBalance() {
        System.out.println("\nInvalid account balance...");
        System.out.println("Enter an account balance and press enter.");
        System.out.println("Input should be one number.");
        System.out.println("The balance should only contain digits from the Arabic numeral system and a period as a decimal separator");
    }

    void invalidBoolean() {
        System.out.println("\nInvalid truth value...");
        System.out.println("\nEnter either TRUE or FALSE and press enter.");
    }

    void invalidCurrencyWeight() {
        System.out.println("\nInvalid Currency Weight...");
        System.out.println("Enter a Currency Weight and press enter.");
        System.out.println("Input should be one number and should be greater than zero");
        System.out.println("The Currency Weight should only contain digits from the Arabic numeral system and a period as a decimal separator");
    }

    void invalidPassword() {
        System.out.println("\nInvalid password...");
        System.out.println("Enter a password and press enter.");
        System.out.println("Input should be one word and only contain letters from the English alphabet.");
    }

    void invalidUsername() {
        System.out.println("\nThe username you entered is invalid.");
        System.out.println("Usernames may only contain letters from the English alphabet.");
        System.out.println("Usernames are not case sensitive.");
    }

    void isAdminPrompt() {
        System.out.println("\nWill this user be an administrator?");
        System.out.println("\nEnter either TRUE or FALSE.");
    }

    void nonMatchingPassword() {
        System.out.println("\nPasswords do not match...");
        System.out.println("Input should be one word and only contain letters from the English alphabet.");
    }

    void userNotAdmin() {
        System.out.println("\nYou are not an administrator.");
    }

    String mustLogIn() {
        String outputString = ("\nYou must log in to use this function!" +
                "\nTo log in, type LOGIN and press enter." +
                "\nOnce logged in, you can type HELP and press enter to display a list of commands.");

        System.out.println(outputString);

        return outputString;
    }

    void incorrectUsernameOrPassword() {
        System.out.println("\nIncorrect username or password.");
        System.out.println("Please try again.");
    }

    void loggedOut() {
        System.out.println("\nYou have been logged out.");
        System.out.println("\nType EXIT to close the program or sign in to continue.\n");
    }
}
