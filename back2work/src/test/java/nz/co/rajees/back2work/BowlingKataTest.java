package nz.co.rajees.back2work;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingKataTest {

	@Test
	public void testCalculateBowlingScore() {
		//"XXXXXXXXXXXX"
		assertEquals(300, BowlingKata.calculateBowlingScore("XXXXXXXXXXXX"));
		assertEquals(90, BowlingKata.calculateBowlingScore("9-9-9-9-9-9-9-9-9-9-"));
		assertEquals(150, BowlingKata.calculateBowlingScore("5/5/5/5/5/5/5/5/5/5/5"));
		
		assertEquals(136, BowlingKata.calculateBowlingScore("525/5/545/5/5/5/5/5/5"));
	}

}
