package nz.co.rajees.back2work;

import static org.junit.Assert.*;

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
	
	
}
