package banking;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AccountManagerTest {
    AccountManager accountManager = new AccountManager();

    @Test
    public void passwordHash() throws NoSuchAlgorithmException{
        String hashMe = "Hash Me!";
        String hashCheck = hashMe;

        String hashed_hashMe = accountManager.passwordHash(hashMe);
        String hashed_hashCheck = accountManager.passwordHash(hashCheck);

        //check to make sure that the password is different
        assertNotEquals(hashMe, hashed_hashMe);

        //check to make sure that the same value hashed twice is the same;
        assertEquals(hashed_hashMe, hashed_hashCheck);
    }

    @Test
    public void makeSalt() {
        //check to see that the salts are random
        int salt0 = accountManager.makeSalt();
        int salt1 = accountManager.makeSalt();

        assertNotEquals(salt0, salt1);
    }

}
