package nz.co.rajees.back2work;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

	BankAccount testClass;
	
	@Before
	public void setUp(){
		testClass = new BankAccount();
	}
	
	@Test
	public void testGetAccountFromFile() throws IOException {
		
		//arrange
		String pathToFile = "src/test/resources/account_number1.txt";
		//act
		Integer accountNumber = testClass.createAccountNumberFromFile(pathToFile);
		//assert
		assertEquals(Integer.valueOf("123456789"), accountNumber);
			
	}

}
