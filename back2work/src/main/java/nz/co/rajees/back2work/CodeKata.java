package nz.co.rajees.back2work;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeKata {

	private static final String DELIMITER_REGEX = "//\\W\n";
	private static final Pattern FIND_DELIM_PATTERN = Pattern.compile("//(\\W)\n");

	/**
	 * http://osherove.com/tdd-kata-1/
	 * @param numbers
	 * @return
	 */
	public int add(String numbers){
		if(numbers == null || numbers.length() == 0){
			return 0;
		}
		if(numbers.length() == 1){
			return Integer.parseInt(numbers);
		}
		if(isDelimiterLastCharacter(numbers)){
			throw new IllegalArgumentException("Delimiter cannot be last character.");
		}
		String numbersToAdd = numbers;
		String delimiters = ",\n";
		String definedDelimiter = determineDefinedDelimiter(numbers);
		if(definedDelimiter != null){
			delimiters += definedDelimiter;
			String[] delimiterAndNumbersToAdd = numbers.split(DELIMITER_REGEX);
			numbersToAdd = delimiterAndNumbersToAdd[1];
		}
		String[] numbersArray = buildArrayOfNumbers(numbersToAdd, "[" + delimiters +"]");

		int total = 0;
		for (int i = 0; i < numbersArray.length; i++) {
			total += Integer.parseInt(numbersArray[i]);		
		} 
		return total;
	}

	private String[] buildArrayOfNumbers(String numbers, String delimitersRegex) {
		String[] numbersArray = numbers.split(delimitersRegex);
		return numbersArray;
	}
	
	private String determineDefinedDelimiter(String numbers) {
		// TODO Auto-generated method stub
		String[] result = numbers.split(DELIMITER_REGEX);
		if(result.length ==2){
			//String delimiter = numbers.substring(2, 3);
			Matcher matcher = FIND_DELIM_PATTERN.matcher(numbers);
			String delimiter = null;
			if (matcher.find())
			{
				delimiter = matcher.group(1);
			}			
			return delimiter;
		} else {
			return null;
		}
		
	}

	boolean isDelimiterLastCharacter(String numbers){
		//find number of delimiters, count of numbers shoud be 1 more..
		//or last index of delimiter should not be last character.
		if(numbers.endsWith(",") || numbers.endsWith("\n")){
			return true;
		}
		return false;
	}
}
