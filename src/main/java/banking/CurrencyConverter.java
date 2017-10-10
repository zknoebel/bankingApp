package banking;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Scanner;

//todo change to static class?
@Entity
class CurrencyConverter {
    @Id
    private long singleton = 1;
    private static Double dollarWeight;
    private static Double euroWeight;
    private static Double yenWeight;

    @Transient
    private OutputMethods outputMethods = new OutputMethods();

    @Transient
    private Sanitizer sanitizer = new Sanitizer();

    protected CurrencyConverter() {
    }

    void setDollarWeight(Double dollarWeight) {
        this.dollarWeight = dollarWeight;
    }

    void setEuroWeight(Double euroWeight) {
        this.euroWeight = euroWeight;
    }

    void setYenWeight(Double yenWeight) {
        this.yenWeight = yenWeight;
    }

    double convert(int from, int to, Double amount) {

        Double convertedAmount;

        switch (from) {
            case 0:
                switch (to) {
                    case 1:
                        convertedAmount = convertDollarToEuro(amount);
                        break;

                    case 2:
                        convertedAmount = convertDollarToYen(amount);
                        break;

                    default:
                        convertedAmount = amount;
                }
                break;

            case 1:
                switch (to) {
                    case 0:
                        convertedAmount = convertEuroToDollar(amount);
                        break;

                    case 2:
                        convertedAmount = convertEuroToYen(amount);
                        break;

                    default:
                        convertedAmount = amount;
                }
                break;

            case 2:
                switch (to) {
                    case 0:
                        convertedAmount = convertYenToDollar(amount);
                        break;

                    case 1:
                        convertedAmount = convertYenToEuro(amount);
                        break;

                    default:
                        convertedAmount = amount;
                }
                break;

            default:
                convertedAmount = amount;
                break;
        }

        return convertedAmount;
    }

    private double convertDollarToEuro(Double dollars) {
        return dollars / dollarWeight * euroWeight;
    }

    private double convertDollarToYen(Double dollars) {
        return dollars / dollarWeight * yenWeight;
    }

    private double convertEuroToDollar(Double euros) {
        return euros / euroWeight * dollarWeight;
    }

    private double convertEuroToYen(Double euros) {
        return euros / euroWeight * yenWeight;
    }

    private double convertYenToDollar(Double yen) {
        return yen / yenWeight * dollarWeight;
    }

    private double convertYenToEuro(Double yen) {
        return yen / yenWeight * euroWeight;
    }

    CurrencyConverter weightManger(Scanner scanner) {
        dollarWeight = -1d;
        euroWeight = -1d;
        yenWeight = -1d;

        while(dollarWeight < 0) {
            outputMethods.printDollarWeightPrompt();
            String input = scanner.nextLine();
            dollarWeight = sanitizer.currencyWeight(input);
            if(dollarWeight < 0) {
                outputMethods.printInvalidCurrencyWeight();
            }
        }

        while(euroWeight < 0) {
            outputMethods.printEuroWeightPrompt();
            String input = scanner.nextLine();
            euroWeight = sanitizer.currencyWeight(input);
            if(euroWeight < 0) {
                outputMethods.printInvalidCurrencyWeight();
            }
        }

        while(yenWeight < 0) {
            outputMethods.printYenWeightPrompt();
            String input = scanner.nextLine();
            yenWeight = sanitizer.currencyWeight(input);
            if(yenWeight < 0) {
                outputMethods.printInvalidCurrencyWeight();
            }
        }

        return this;
    }

    @Override
    public String toString() {
        return  "\n{"
                + "\n\tDollar weight: " + dollarWeight
                + "\n\tEuro weight: " + euroWeight
                + "\n\tYen weight: " + yenWeight
                +"\n}\n";
    }

}
