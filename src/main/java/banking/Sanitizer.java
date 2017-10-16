package banking;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sanitizer {
    private OutputMethods outputMethods = new OutputMethods();

    public Sanitizer() {
        //empty
    }

    public String lettersOnlyString(String input) {
        return uppercaseLettersOnly(input.toUpperCase());
    }

//    public String typeAndAmountOfMoney(String input) {
//        Pattern pattern = Pattern.compile(input);
//
//        Matcher matcher = pattern.matcher("[\\$Є¥]+[ ]{0,}+[0-9]{1,}+[\\.+[0-9]{1,}]{0,1}");
//
//
//
//    }

    public Long accountNumber(String input) {
        try {
            return new Long(input);
        } catch (NumberFormatException nfe) {
            outputMethods.invalidAccountNumber();
            throw nfe;
        }
    }

    public int currencyType(String input) {
        String currencyType = lettersOnlyString(input);

        switch (currencyType) {
            case "DOLLAR":
                return 0;

            case "$":
                return 0;

            case "EURO":
                return 1;

            case "Є":
                return 1;

            case "YEN":
                return 2;

            case "¥":
                return 2;

            default:
                throw new IllegalArgumentException();
        }
    }

    public Double accountBalance(String input) {
        try {
            return new Double(input);
        } catch (NumberFormatException nfe) {
            outputMethods.invalidAccountBalance();
            throw nfe;
        }
    }

    public Double currencyWeight(String input) {
        try {
            return new Double(input);
        }
        catch (NumberFormatException nfe) {
            return 0d;
        }
    }

    private String uppercaseLettersOnly(String input) {

        if(input.matches("[A-Z]*")){
            return input;
        }
        else return "";
    }

    private String onlyNumbers(String input) {
        if(input.matches("[0-9]*")){
            return input;
        }
        else return "";
    }
}
