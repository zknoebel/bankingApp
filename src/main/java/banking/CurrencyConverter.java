package banking;

import java.util.Scanner;

public class CurrencyConverter {
    private static Double dollarWeight;
    private static Double euroWeight;
    private static Double yenWeight;

    public CurrencyConverter() {
        dollarWeight = new Double(1);
        euroWeight = new Double(1);
        yenWeight = new Double(1);
    }

    public CurrencyConverter(Double dollarWeight, Double euroWeight, Double yenWeight) {
        this.dollarWeight = dollarWeight;
        this.euroWeight = euroWeight;
        this.yenWeight = yenWeight;
    }

    public double convert(int from, int to, Double amount) {

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

    private void weightManger(Scanner scanner) {
        //todo

    }

}
