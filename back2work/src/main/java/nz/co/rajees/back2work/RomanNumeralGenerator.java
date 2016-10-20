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
		String romanNumeral = "";
		int balance = number;
		int numberOfNumerals = 0;
		//build numeral for 1000's
		if ((numberOfNumerals = Math.floorDiv(number, 1000)) > 0) {
			romanNumeral += buildNumeral("M", numberOfNumerals);
			balance = number % 1000;
		}
		//build numeral for 100's
		if ((numberOfNumerals = Math.floorDiv(balance, 100)) > 0) {
			if (balance >= 900 && balance <= 999) {
				romanNumeral += "CM";
			} else if (balance >= 400 && balance <= 499) {
				romanNumeral += "CD";
			} else {
				romanNumeral += buildNumeral("C", numberOfNumerals);
			}

			balance = balance % 100;
		}
		//build numeral for 50's
		if ((numberOfNumerals = Math.floorDiv(balance, 50)) > 0) {
			// if we got in here then the balance is between 50 and 99
			romanNumeral += "L";
			balance = balance % 50;
		}
		//build numeral for 40's
		if ((numberOfNumerals = Math.floorDiv(balance, 40)) > 0) {
			// if we got in here then the balance is between 40 and 49
			romanNumeral += "XL";
			balance = balance % 40;
		}
		//build numeral for 10's
		if ((numberOfNumerals = Math.floorDiv(balance, 10)) > 0) {
			// if we got in here then the balance is between 0 and 39
			romanNumeral += buildNumeral("X", numberOfNumerals);
			balance = balance % 10;
		}
		// when we get here balance should be less than 10
		if(balance < 10){
			romanNumeral += buildNumeralForNumberUnder10(balance);
		}
		return romanNumeral;
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
