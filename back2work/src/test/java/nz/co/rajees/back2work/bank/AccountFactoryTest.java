package nz.co.rajees.back2work.bank;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 */
public class AccountFactoryTest {

    private AccountFactory testClass;

    @Before
    public void setUp(){
        testClass = new AccountFactory();
    }

    @Test
    public void testCreateAccount(){
        //arrange
        String accountId = "CRED-23-773-054432-006";

        //act
        AccountId testClassAccountId = testClass.createAccountId(accountId);

        //assert
        assertEquals(accountId, testClassAccountId.getNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAccountWithSpacesThrowsIllegalArgumentException(){
        //arrange
        String accountId = "CRED-23-773-054432-006 ";

        //act
        AccountId testClassAccountId = testClass.createAccountId(accountId);

        //assert
        fail("Illegal Argument exception should be thrown");
    }
}