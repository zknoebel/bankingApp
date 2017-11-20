package banking;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class AnonymousUserTest {
    User anonymousUser = new AnonymousUser();
    OutputMethods outputMethods = new OutputMethods();
    AccountManager accountManager = new AccountManager();
    Scanner scanner = new Scanner(System.in);
    CurrencyConverter currencyConverter = new CurrencyConverter();

    String mustLogIn = outputMethods.mustLogIn();

    @Test
    public void constructor() {
        assertNotNull(anonymousUser);
    }


    @Test
    public void add() {
    }

    @Test(expected = IllegalAccessException.class)
    public void adduser() throws IllegalAccessException, NoSuchAlgorithmException {
        anonymousUser.adduser(accountManager, scanner);
    }

    @Test
    public void account() {
    }

    @Test(expected = IllegalAccessException.class)
    public void conversions() throws IllegalAccessException {
        anonymousUser.conversions(currencyConverter);
    }

    @Test(expected = IllegalAccessException.class)
    public void create() throws IllegalAccessException {
        anonymousUser.create(accountManager, scanner);
    }

    @Test(expected = IllegalAccessException.class)
    public void delete() throws IllegalAccessException {
        anonymousUser.delete(accountManager, scanner);
    }

    @Test(expected = IllegalAccessException.class)
    public void deluser() throws IllegalAccessException {
        anonymousUser.deluser(accountManager, scanner);
    }

    @Test
    public void help() {
    }

    @Test(expected = IllegalAccessException.class)
    public void currencyConverter() throws IllegalAccessException {
        anonymousUser.maint(new CurrencyConverter(), new AccountManager(), new Scanner(System.in));
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
