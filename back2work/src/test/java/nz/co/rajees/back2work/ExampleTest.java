package nz.co.rajees.back2work;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ExampleTest {

	@Test
	public void testFibonacci() {
		//0,1,1,2,3,5,8,13
		
		assertEquals(0, Example.fibonacci(0));
		assertEquals(1, Example.fibonacci(1));
		assertEquals(1, Example.fibonacci(2));
		assertEquals(2, Example.fibonacci(3));
		assertEquals(3, Example.fibonacci(4));
		assertEquals(5, Example.fibonacci(5));
		assertEquals(13, Example.fibonacci(7));
		
	}

	@Test
	public void testFactorial() {
		//0,1,1,2,3,5,8,13
		
		assertEquals(1, Example.factorial(0));
		assertEquals(1, Example.factorial(1));
		assertEquals(2, Example.factorial(2));
		assertEquals(6, Example.factorial(3));
		assertEquals(24, Example.factorial(4));
		assertEquals(120, Example.factorial(5));
		assertEquals(720, Example.factorial(6));
		
	}
	
	@Test
	public void testToUpperCase(){
		List<String> testData = Arrays.asList("raj", "pAtel");
		List<String> actualUpperCase = Example.toUpperCase(testData);
		assertEquals("RAJ", actualUpperCase.get(0));
		assertEquals("PATEL", actualUpperCase.get(1));
	}
	
	@Test
	public void testSortTwoArrays(){
		//arrange
		String[] arrayOne = {"raj", "patel"};
		String[] arrayTwo = {"is", "cool"};
		//act
		String[] sortedArrays = Example.sortTwoArrays(arrayOne, arrayTwo);
		//assert
		assertThat(sortedArrays.length, is(equalTo(4)));
		//tests order
		assertThat(sortedArrays, is(arrayContaining("cool", "is", "patel", "raj")));
	}
	
	@Test
	public void testFirstNonRepeatingCharacter(){
		assertEquals(Character.valueOf('t'), Example.determineFirstNonRepeatingCharacter("stress"));
		assertEquals(Character.valueOf('r'), Example.determineFirstNonRepeatingCharacter("teeter"));
		assertEquals(null, Example.determineFirstNonRepeatingCharacter("teet"));
	}
}
