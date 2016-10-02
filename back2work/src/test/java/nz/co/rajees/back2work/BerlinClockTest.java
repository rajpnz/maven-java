package nz.co.rajees.back2work;

import static org.junit.Assert.*;

import org.junit.Test;

public class BerlinClockTest {

	@Test
	public void testTimeParsedCorrectly() {
		
		BerlinClock testClass = new BerlinClock("15::25:48");
		assertEquals(15, testClass.getHours());
		assertEquals(25, testClass.getMinutes());
		assertEquals(48, testClass.getSeconds());
	}

}
