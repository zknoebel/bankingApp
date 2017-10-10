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

    public double convertDollarToEuro(Double dollars) {
        return dollars/dollarWeight*euroWeight;
    }

    public double convertDollarToYen(Double dollars) {
        return dollars/dollarWeight*yenWeight;
    }

    public double convertEuroToDollar(Double euros) {
        return euros/euroWeight*dollarWeight;
    }

    public double convertEuroToYen(Double euros) {
        return euros/euroWeight*yenWeight;
    }

    public double convertYenToDollar(Double yen) {
        return yen/yenWeight*dollarWeight;
    }

    public double convertYenToEuro(Double yen) {
        return yen/yenWeight*euroWeight;
    }

    public void weightManger(Scanner scanner) {
        //todo

    }

}
