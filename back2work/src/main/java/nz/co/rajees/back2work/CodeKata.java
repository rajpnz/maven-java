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
		//find number of delimiters, count of numbers should be 1 more..
		//or last index of delimiter should not be last character.
		if(numbers.endsWith(",") || numbers.endsWith("\n")){
			return true;
		}
		return false;
	}
	
	
	private NumbersToAddSpec buildSpec(String numbers){
		String numbersToAdd = numbers;
		String delimiters = ",|\n"; //comma OR carriage return
		List<String> definedDelimiters = extractDefinedDelimiters(numbers);
		for(String oneDelim: definedDelimiters){
			if(oneDelim.length() > 1 && !containsSameCharacters(oneDelim)){
				//Allow multiple delimiters like this:  “//[delim1][delim2]\n” for example “//[*][%]\n1*2%3” should return 6
				char[] charArray = oneDelim.toCharArray();
				for(char c: charArray){
					delimiters += "|" + escapeMetaCharacters(Character.toString(c));
				}
			}
			delimiters += "|" + escapeMetaCharacters(oneDelim);
			//there will be a 2 element array. First element is an empty String, Second element is the numbers to add. 
			String[] delimiterAndNumbersToAdd = numbers.split(DELIMITER_REGEX);
			numbersToAdd = delimiterAndNumbersToAdd[1];		
		}

		return new NumbersToAddSpec(delimiters, numbersToAdd);
	}
	
	/**
	 * Extract a list of delimiters that can be used to delimit the numbers
	 * @param numbers
	 * @return
	 */
	private List<String> extractDefinedDelimiters(String numbers){
		List<String> definedDelimiters = new ArrayList<String>();
		String[] result = numbers.split(DELIMITER_REGEX);
		if(result.length ==2){
			//String delimiter = numbers.substring(2, 3);
			Matcher matcher = FIND_DELIM_PATTERN.matcher(numbers);
			String delimiter = null;
			if (matcher.find())
			{
				delimiter = matcher.group(1);
			}	
			if(delimiter.length() == 1){
				//1 character delimiter
				definedDelimiters.add(delimiter);
			} else{
				char[] charArray = delimiter.toCharArray();
				char previousChar =  delimiter.charAt(0);
				StringBuilder oneDelimiterBuilder = new StringBuilder();
				for(char c: charArray){
					if(c == previousChar || oneDelimiterBuilder.length() == 1){
						previousChar = c;
					} else{
						// c is different than previous character so we have had a change in delimiter
						definedDelimiters.add(oneDelimiterBuilder.toString());
						oneDelimiterBuilder.setLength(0); //clears StringBuilder
					}
					oneDelimiterBuilder.append(c);
				}
				if(oneDelimiterBuilder.length() > 0){
					definedDelimiters.add(oneDelimiterBuilder.toString());
				}
			}
		} 
		return definedDelimiters;
	}
	
	/**
	 * Are all the characters in definedDelimiter the same. 
	 * @param definedDelimiter
	 * @return
	 */
	private boolean containsSameCharacters(String definedDelimiter) {
		boolean containsSameChar = true;
		char[] charArray = definedDelimiter.toCharArray();
		char previousChar = definedDelimiter.charAt(0);
		for(char c: charArray){
			if(c == previousChar){
				previousChar = c;
				continue;
			} else{
				containsSameChar = false;
				break;
			}
			
		}
		return containsSameChar;
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
