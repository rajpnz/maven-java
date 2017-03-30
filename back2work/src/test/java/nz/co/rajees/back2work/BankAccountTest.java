package nz.co.rajees.back2work;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BankAccountTest {

    BankAccountParser testClass;

    @Before
    public void setUp() {
        testClass = new BankAccountParser();
    }

    @Test
    public void testGetAccountFromFile() throws IOException {

        //arrange
        String pathToFile = "src/test/resources/account_number1.txt";
        //act
        Integer accountNumber = testClass.createAccountNumberFromFile(pathToFile);
        //assert
        assertThat(accountNumber, is(equalTo(123456789)));
    }

}
