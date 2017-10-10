package banking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sanitizer {
    private OutputMethods outputMethods = new OutputMethods();

    public Sanitizer() {
        //empty
    }

    public String mainLoop(String input) {
        return onlyLetters(input);
    }

    public long accountNumber(String input) {
        String returnString = onlyNumbers(input);
        try {
            return Long.parseLong(returnString);
        } catch (NumberFormatException nfe) {
            outputMethods.printInvalidAccountNumber();
            throw nfe;
        }
    }

    public int currencyType(String input) {
        String currencyType = onlyLetters(input);

        switch (currencyType) {
            case "DOLLAR":
                return 0;

            case "EURO":
                return 1;

            case "YEN":
                return 2;

            default:
                throw new IllegalArgumentException();
        }
    }

    public Double accountBalance(String input) {
        try {
            return new Double(input);
        }
        catch (NumberFormatException nfe) {
            outputMethods.printInvalidAccountBalance();
            throw nfe;
        }
    }

    private String onlyLetters(String input) {
        String letterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return sanitizeInput(input, letterSet);
    }

    private String onlyNumbers(String input) {
        //todo spaces in numbers?
        String numberSet = "0123456789";
        return sanitizeInput(input, numberSet);
    }

    private String sanitizeInput(String input, String letterSet) {
        String returnString = "";

        for (int i = 0; i < input.length(); i++) {
            if (letterSet.contains(input.subSequence(i, i + 1))) {
                returnString = returnString + input.subSequence(i, i + 1);
            }
        }

        System.out.println(returnString);
        return returnString;

    }
}
