package nz.co.rajees.back2work;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CodeKataTest {
	
	private CodeKata testClass;
	
	@Before
	public void setUp() {
		testClass = new CodeKata();

	}
	@Test
	public void testAddWhenStringIsEmpty() {
		
		assertEquals(0, testClass.add(null));
		assertEquals(0, testClass.add(""));
	}
	
	@Test
	public void testAddWhenStringHasOneNumber() {
		
		assertEquals(2, testClass.add("2"));
	}

	@Test
	public void testAddWhenStringHasTwoNumbers() {
		
		assertEquals(5, testClass.add("2,3"));
	}
	
	@Test
	public void testAddWhenStringHasManyNumbers() {
		
		assertEquals(20, testClass.add("2,3,7,8"));
	}	
	
	@Test
	public void testAddWhenStringHasNewLineDelimiter() {
		
		assertEquals(6, testClass.add("2,3\n1"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddWhenStringHasConsecutiveDelimiters() {
		
		assertEquals(6, testClass.add("2,\n"));
	}	
	
	@Test
	public void testHandleOtherDelimiters() {
		
		assertEquals(3, testClass.add("//;\n1;2"));
	}	
	
	@Test
	public void testWhenAddingANegativeNumberAnExceptionIsThrown() {
		try{
			testClass.add("-1,2,-3");
			fail("Should throw exception");
		} catch(IllegalArgumentException ex){
			String message = ex.getMessage();
			assertNotNull(message);
			assertTrue(message.contains("-1"));
		}
		
	}	
	
}
