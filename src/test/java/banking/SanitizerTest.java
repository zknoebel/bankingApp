package banking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SanitizerTest {


    private Sanitizer sanitizer = new Sanitizer();

    @Test
    public void lettersOnlyString() {
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String mixedLetters = lowercase + uppercase;
        String numbers = "0123456789";
        String specialChars = "`~!@#$%^&*()_+[]{}\\|;:'\",./<>?";
        String mixed = uppercase + numbers + lowercase + specialChars;
        String empty = "";

        assertEquals(uppercase, sanitizer.lettersOnlyString(uppercase));
        assertEquals(uppercase, sanitizer.lettersOnlyString(lowercase));
        assertEquals(uppercase + uppercase, sanitizer.lettersOnlyString(mixedLetters));
        assertEquals(empty, sanitizer.lettersOnlyString(numbers));
        assertEquals(empty, sanitizer.lettersOnlyString(specialChars));
        assertEquals(empty, sanitizer.lettersOnlyString(mixed));
        assertEquals(empty, sanitizer.lettersOnlyString(empty));
    }

    @Test
    public void accountNumber() {
        Long six = Long.parseLong("012345");

        assertEquals(six, sanitizer.accountNumber("012345"));
    }

    @Test(expected = NumberFormatException.class)
    public void accountNumberException() {
        sanitizer.accountNumber("z0a1B2C3d4e5F");
    }

    @Test
    public void currencyType() {
        assertEquals(0, sanitizer.currencyType("dollar"));
        assertEquals(1, sanitizer.currencyType("euro"));
        assertEquals(2, sanitizer.currencyType("yen"));
        assertEquals(0, sanitizer.currencyType("DOLLAR"));
        assertEquals(1, sanitizer.currencyType("eUrO"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void currencyTypeException() {
        sanitizer.currencyType("unexpected word");
    }

    @Test
    public void accountBalance() {
        Double six = 012345.0;

        assertEquals(six, sanitizer.accountBalance("012345"));
        assertEquals(six, sanitizer.accountBalance("012345.0000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void accountBalanceException() {
        sanitizer.accountBalance("1234.1234.1234");
    }

    @Test
    public void currencyWeight() {
        Double six = 012345.0;

        assertEquals(six, sanitizer.currencyWeight("012345"));
        assertEquals(six, sanitizer.currencyWeight("012345.0000000"));
    }

    @Test
    public void currencyWeightException() {
      assertEquals(new Double(0), sanitizer.currencyWeight("1234.1234.1234"));
    }
}