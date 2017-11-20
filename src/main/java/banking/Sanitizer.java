package banking;

public class Sanitizer {
    private OutputMethods outputMethods = new OutputMethods();

    public Sanitizer() {
        //empty
    }

    //uppercase letters only
    public String lettersOnlyString(String input) {
        return uppercaseLettersOnly(input.toUpperCase());
    }

    //get amount of money. If they specify a type, take that too
    public Double[] typeAndAmountOfMoney(String input) {
        Double[] doubles = new Double[2];
        String returnString = "";

        if (input.matches("\\s*+[$Є¥]+\\s*+\\d*+[.+\\d]?")) {
            for(String i : input.split("\\s")) {
                returnString += i;
            }
            int currencyType = currencyType(returnString.substring(0, 1));
            doubles[1] = (double) currencyType;
            doubles[0] = new Double(returnString.substring(1, returnString.length()));
        }
        else {
            doubles[1] = (double) -1;
            doubles[0] = new Double(input);

        }

        return doubles;
    }

    //account numbers should be a long (only characters 0-9)
    public Long accountNumber(String input) {
        try {
            return new Long(input);
        } catch (NumberFormatException nfe) {
            outputMethods.invalidAccountNumber();
            throw nfe;
        }
    }

    //dollar = 0
    //euro = 1
    //yen = 2
    public int currencyType(String input) {
        String currencyType = currencyCharacters(input);
        if (currencyType.equals("")) {
            currencyType = lettersOnlyString(input);
        }

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

    //only accept doubles
    public Double accountBalance(String input) {
        try {
            return new Double(input);
        } catch (NumberFormatException nfe) {
            outputMethods.invalidAccountBalance();
            throw nfe;
        }
    }

    //weight for the currency converter ratios
    public Double currencyWeight(String input) {
        try {
            return new Double(input);
        } catch (NumberFormatException nfe) {
            return 0d;
        }
    }

    //only accept uppercase letters
    private String uppercaseLettersOnly(String input) {

        if (input.matches("[A-Z]*")) {
            return input;
        } else return "";
    }

    //only accept numbers
    private String numbersOnly(String input) {
        if (input.matches("[0-9]*")) {
            return input;
        } else return "";
    }

    //the symbols for the three type of currency
    private String currencyCharacters(String input) {
        if (input.matches("[$Є¥]")) {
            return input;
        } else return "";
    }
}
