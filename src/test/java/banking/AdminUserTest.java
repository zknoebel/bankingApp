package banking;

import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class AdminUserTest {
    User adminUser = new AdminUser("administrator", "adminpass");
    AccountManager accountManager = new AccountManager();
    CurrencyConverter currencyConverter = new CurrencyConverter();
    Scanner scanner = new Scanner(System.in);

    @Before
    public void setup() {

    }

    @Test
    public void constructor() {
        assertNotNull(adminUser);
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
    public void currencyConverter() throws IllegalAccessException {
        assertNull(adminUser.maint(currencyConverter, accountManager, scanner));
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
