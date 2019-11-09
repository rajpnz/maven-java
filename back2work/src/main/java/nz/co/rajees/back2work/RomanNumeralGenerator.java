package nz.co.rajees.back2work;

public class RomanNumeralGenerator {

	/**
	 * Build the roman numeral representation of the given int
	 * 
	 * @param number
	 *            Build the roman numeral representation for this int
	 * @return a String that is a roman numeral
	 * @see <a href=
	 *      "http://codingdojo.org/cgi-bin/index.pl?KataRomanNumerals">Roman
	 *      Numeral Kata</a>
	 */
	public static String generateRomanNumeral(int number) {
		//add the roman numerals to the StringBuilder
		StringBuilder romanNumeral = new StringBuilder();
		int remainingToConvertToRoman = number;
		int numberOfNumerals = 0;
		//build numeral for 1000's
		remainingToConvertToRoman = appendRomanNumeral(number, 1000, "M", romanNumeral);
		//build numeral for 100's
		if ((numberOfNumerals = Math.floorDiv(remainingToConvertToRoman, 100)) > 0) {
			if (remainingToConvertToRoman >= 900 && remainingToConvertToRoman <= 999) {
				romanNumeral.append("CM");
			} else if (remainingToConvertToRoman >= 400 && remainingToConvertToRoman <= 499) {
				romanNumeral.append("CD");
			} else {
				romanNumeral.append(buildNumeral("C", numberOfNumerals));
			}

			remainingToConvertToRoman = remainingToConvertToRoman % 100;
		}
		//build numeral for 50's
		remainingToConvertToRoman = appendRomanNumeral(remainingToConvertToRoman, 50, "L", romanNumeral);
		//build numeral for 40's
		remainingToConvertToRoman = appendRomanNumeral(remainingToConvertToRoman, 40, "XL", romanNumeral);
		//build numeral for 10's
		remainingToConvertToRoman = appendRomanNumeral(remainingToConvertToRoman, 10, "X", romanNumeral);
		// when we get here balance should be less than 10
		if(remainingToConvertToRoman < 10){
			romanNumeral.append(buildNumeralForNumberUnder10(remainingToConvertToRoman));
		}
		return romanNumeral.toString();
	}

	/**
	 * Append the roman numeral to the StringBuilder
	 * @param numberToConvertToRoman The number we are going to convert to roman numeral
	 * @param unitValue The unit we will calculate the roman numeral for i.e 10's, 100's 
	 * @param symbolForUnit The roman numeral symbol for the Unit i.e X,I,V
	 * @param romanNumeralBuilder Add the roman numeral to this String Builder
	 * @return
	 */
	private static int appendRomanNumeral(int numberToConvertToRoman, int unitValue, String symbolForUnit, StringBuilder romanNumeralBuilder){
		int numberOfNumerals = 0;
		int balance = 0; 
		if ((numberOfNumerals = Math.floorDiv(numberToConvertToRoman, unitValue)) > 0) {
			romanNumeralBuilder.append(buildNumeral(symbolForUnit, numberOfNumerals));
			balance = numberToConvertToRoman % unitValue;
		} else{
			balance = numberToConvertToRoman;
		}
		return balance;
	}
	
	private static String buildNumeralForNumberUnder10(int numberUnder10) {

		String romanNumeral = "";
		switch (numberUnder10) {
		case 0:
			break;
		case 1:
			romanNumeral = "I";
			break;
		case 2:
			romanNumeral = "II";
			break;
		case 3:
			romanNumeral = "III";
			break;
		case 4:
			romanNumeral = "IV";
			break;
		case 5:
			romanNumeral = "V";
			break;
		case 6:
			romanNumeral = "VI";
			break;
		case 7:
			romanNumeral = "VII";
			break;
		case 8:
			romanNumeral = "VIII";
			break;
		case 9:
			romanNumeral = "IX";
			break;

		}
		return romanNumeral;
	}

	private static String buildNumeral(String numeralValue, int numberOfNumerals) {
		String numeral = "";
		for (int i = 0; i < numberOfNumerals; i++) {
			numeral += numeralValue;

		}
		return numeral;
	}
}
