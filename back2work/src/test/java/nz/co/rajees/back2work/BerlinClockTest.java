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

	@Test
	public void testIsSecondsLampOn() {
		
		BerlinClock testClass = new BerlinClock("15::25:48");
		assertTrue(testClass.isSecondsLampOn());
		BerlinClock testClass2 = new BerlinClock("15::25:03");
		assertFalse(testClass2.isSecondsLampOn());
		
		BerlinClock testClass3 = new BerlinClock("15::25:02");
		assertTrue(testClass3.isSecondsLampOn());
	}	
	
	@Test
	public void testGetHoursLampsConfigRow1(){
		
		BerlinClock testClass = new BerlinClock("18::25:48");
		assertEquals("RRRO", testClass.getHoursLampsConfigRow1());
		
		BerlinClock testClass2 = new BerlinClock("04::25:48");
		assertEquals("OOOO", testClass2.getHoursLampsConfigRow1());	
		
		BerlinClock testClass3 = new BerlinClock("22::25:48");
		assertEquals("RRRR", testClass3.getHoursLampsConfigRow1());		
	}
	
	@Test
	public void testGetHoursLampsConfigRow2(){
		
		BerlinClock testClass = new BerlinClock("02::25:48");
		assertEquals("RROO", testClass.getHoursLampsConfigRow2());
		
		BerlinClock testClass2 = new BerlinClock("15::25:48");
		assertEquals("OOOO", testClass2.getHoursLampsConfigRow2());	
		
		BerlinClock testClass3 = new BerlinClock("04::25:48");
		assertEquals("RRRR", testClass3.getHoursLampsConfigRow2());	
		
		BerlinClock testClass4 = new BerlinClock("18::25:48");
		assertEquals("RRRO", testClass4.getHoursLampsConfigRow2());			
	}
	
	@Test
	public void testGetMinutesLampsConfigRow_1(){
		
		BerlinClock testClass = new BerlinClock("18::04:48");
		assertEquals("OOOOOOOOOOO", testClass.getMinutesLampConfigRow_1());
		
		BerlinClock testClass2 = new BerlinClock("04::19:48");
		assertEquals("YYROOOOOOOO", testClass2.getMinutesLampConfigRow_1());	
		
		BerlinClock testClass3 = new BerlinClock("22::57:48");
		assertEquals("YYRYYRYYRYY", testClass3.getMinutesLampConfigRow_1());	
	}	
}
