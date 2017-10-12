package banking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CurrencyConverterTest {
    private CurrencyConverter currencyConverter = new CurrencyConverter(1d, 2d, 4d);

    @Test
    public void convert() {
        Double dollars = 4.0;
        Double euros = 2.0;
        Double yen = 1.0;

        //from dollars
        assertEquals(euros, currencyConverter.convert(0, 1,dollars));
        assertEquals(yen, currencyConverter.convert(0, 2, dollars));

        //from euros
        assertEquals(dollars, currencyConverter.convert(1, 0, euros));
        assertEquals(yen, currencyConverter.convert(1, 2, euros));

        //from yen
        assertEquals(dollars, currencyConverter.convert(2, 0, yen));
        assertEquals(euros, currencyConverter.convert(2, 1, yen));

        //if nonexistent currency, leave the same
        assertEquals(yen, currencyConverter.convert(-1, 1, yen));
        assertEquals(yen, currencyConverter.convert(1, -1, yen));
    }

}
