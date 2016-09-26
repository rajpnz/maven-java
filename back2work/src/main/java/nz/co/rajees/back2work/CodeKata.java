package nz.co.rajees.back2work;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeKata {



	private static final String DELIMITER_REGEX = "//\\W+\n";
	private static final Pattern FIND_DELIM_PATTERN = Pattern.compile("//(\\W+)\n");

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
		NumbersToAddSpec spec = buildSpec(numbers);
		String[] numbersArray = buildArrayOfNumbers(spec.numbersToAdd, spec.delimiters);

		int total = 0;
		List<Integer> negativeNumbers = new ArrayList<Integer>(); 
		for (int i = 0; i < numbersArray.length; i++) {
			int intToAdd = Integer.parseInt(numbersArray[i]);
			if(intToAdd < 0){
				negativeNumbers.add(intToAdd);
			} else if(intToAdd > 1000){
				continue;
			}
			total += intToAdd;		
		} 
		if(negativeNumbers.size() > 0){
			throw new IllegalArgumentException(negativeNumbers.toString());
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
	
	
	private NumbersToAddSpec buildSpec(String numbers){
		String numbersToAdd = numbers;
		String delimiters = ",|\n"; //comma OR carriage return
		String definedDelimiter = determineDefinedDelimiter(numbers);
		if(definedDelimiter != null){
			delimiters += "|" + escapeMetaCharacters(definedDelimiter);
			//there will be a 2 element array. First element is an empty String, Second element is the numbers to add. 
			String[] delimiterAndNumbersToAdd = numbers.split(DELIMITER_REGEX);
			numbersToAdd = delimiterAndNumbersToAdd[1];
		}
		return new NumbersToAddSpec(delimiters, numbersToAdd);
	}
	
	/**
	 * We could have dangling metadata characters, so we need to escape them 
	 * @param definedDelimiter
	 * @return
	 */
	private String escapeMetaCharacters(String definedDelimiter) {
		StringBuilder stringBuilder = new StringBuilder();
		char[] charArray = definedDelimiter.toCharArray();
		for (char c: charArray) {
			if(c == '*'){
				stringBuilder.append("\\" + c);
			} else{
				stringBuilder.append(c);
			}
		}
		return stringBuilder.toString();
	}

	private class NumbersToAddSpec {
		String delimiters;
		String numbersToAdd;
		
		NumbersToAddSpec(String delimiters, String numbersToAdd) {
			super();
			this.delimiters = delimiters;
			this.numbersToAdd = numbersToAdd;
		}
		
	}	
}
