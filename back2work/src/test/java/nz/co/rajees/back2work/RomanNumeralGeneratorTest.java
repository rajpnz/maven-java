package nz.co.rajees.back2work;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanNumeralGeneratorTest {

	@Test
	public void testGenerateRomanNumeral() {
		assertEquals("XIV", RomanNumeralGenerator.generateRomanNumeral(14));
		assertEquals("LXXXIII", RomanNumeralGenerator.generateRomanNumeral(83));
		assertEquals("CLXXIX", RomanNumeralGenerator.generateRomanNumeral(179));
		assertEquals("MMCDXI", RomanNumeralGenerator.generateRomanNumeral(2411));
	}

}
