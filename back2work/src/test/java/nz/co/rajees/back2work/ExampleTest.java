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

}
