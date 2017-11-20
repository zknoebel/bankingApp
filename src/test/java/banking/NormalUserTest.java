package banking;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class NormalUserTest {
    User normalUser = new NormalUser("dave", "password", 0, 0);

    @Test
    public void constructor() {
        assertNotNull(normalUser);
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
        assertNull(normalUser.maint(new CurrencyConverter(), new AccountManager(), new Scanner(System.in)));
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
