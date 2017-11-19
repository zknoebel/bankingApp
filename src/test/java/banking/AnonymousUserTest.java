package banking;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class AnonymousUserTest {
    User anonymousUser = new AnonymousUser();
    OutputMethods outputMethods = new OutputMethods();

    String mustLogIn = outputMethods.mustLogIn();

    @Test
    public void constructor() {
        assertNotNull(anonymousUser);
    }


    @Test
    public void add() {

    }

    @Test
    public void adduser() {

    }

    @Test
    public void account() {

    }

    @Test
    public void conversions() {

    }

    @Test
    public void create() {

    }

    @Test
    public void delete() {

    }

    @Test
    public void deluser() {

    }

    @Test
    public void help() {

    }

    @Test
    public void currencyConverter() throws IllegalAccessException{
        assertNull(anonymousUser.maint(new CurrencyConverter(), new AccountManager(), new Scanner(System.in)));
    }

    @Test
    public void list() {

    }

    @Test
    public void subtract() {

    }

    @Test
    public void transfer() {

    }

    @Test
    public void withdraw() {

    }

}
