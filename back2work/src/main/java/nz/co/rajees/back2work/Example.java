package nz.co.rajees.back2work;

import com.google.common.collect.ImmutableMap;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Example {

	public static void main(String[] args) {
		Predicate<String> i  = s-> s.equals("Raj");
		//expect TRUE 2
		System.out.println(i.test("Raj"));
		invokeImmutableMap();
	}

	
	public static int fibonacci(int index){
		boolean doRecurse = true;
		if(doRecurse){
			return fibonacciRecurse(index);
		}
		//0,1,1,2,3,5,8,13,21
		if( index == 0){
			return 0;
		} else if(index ==1){
			return 1;
		}
		//got here so index is equal to 2
		int resultAtIndex = 1;
		int resultIndexLessOne = 1;
		int resultIndexLessTwo = 0;
		for (int i = 1; i < index; i++) {
			resultAtIndex = resultIndexLessOne + resultIndexLessTwo;
			resultIndexLessTwo = resultIndexLessOne;
			resultIndexLessOne = resultAtIndex;
		}
		return resultAtIndex;
	}
	
	public static int fibonacciRecurse(int index){
		//0,1,1,2,3,5,8,13,21
		if( index == 0){
			return 0;
		} else if(index ==1){
			return 1;
		}
		//Merge this 12
		return fibonacciRecurse(index -1) + fibonacciRecurse(index -2);
	}	
	
	public static void invokeImmutableMap(){
		ImmutableMap<Integer, String> idAndCustomer = ImmutableMap.of(1, "Cheese", 2, "Sus", 3, "Keeran");
		String rajName = idAndCustomer.get(1);
		System.out.println(rajName);
	}

	/**
	 * Calculate the factorial for the number
	 * Factorial for 4 is 4*3*2*1
	 * @param number
	 * @return
	 */
	public static int factorial(int number){
		if(number == 0 || number == 1){
			return 1;
		}
		int result = number * factorial(number -1);
		return result;
	}
	
	public static List<String> toUpperCase(Collection<String> collOfStrings){
		return collOfStrings.stream()
				.map(String::toUpperCase)
				.collect(Collectors.toList());
		

	}	
	
	/**
	* Sort two given arrays in alphabetical order.
	* @param arr1 Array 1 - unsorted
	* @param arr2 Array 2 - unsorted
	* @return An array contains both arr1 and
	 *         arr2 contents in alphabetical order.
	*/  
	public static String[] sortTwoArrays(
	                  String[] arr1, String[] arr2) {
		String[] result = new String[arr1.length + arr2.length];
		System.arraycopy(arr1, 0, result, 0, arr1.length);
		System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
		bubbleSort(result);
		//Arrays.sort(result);
		return result;
	}


	/**
	 * Use bubble sort to sort array alphabetically, without using Arrays.sort
	 * @param result
	 */
	private static void bubbleSort(String[] result) {
		int indexToStop = result.length -1;
		while(indexToStop > 0){
			for (int j = 0; j < indexToStop; j++) {
				//5,9,4,7
				String compareJ = result[j];
				String compareJ2 = result[j + 1];
				if(compareJ.compareTo(compareJ2) > 0){
					//need to swap
					result[j] = compareJ2;
					result[j + 1] = compareJ;
				}
			}	
			indexToStop--;			
		}
	}	
	
	/**
	 * Determine the first non repeating character in a String. 
	 * 
	 * 
	 * @param stringToCheck
	 * @return The first non-repeating Character in the String or null if all characters repeat
	 * @see @see <a href="http://javahungry.blogspot.com/2013/12/first-non-repeated-character-in-string-java-program-code-example.html">Non Repeating Character</a>
	 */
	public static Character determineFirstNonRepeatingCharacter(String stringToCheck){
		Character nonRepeatingChar = null;
		char[] charArray = stringToCheck.toCharArray();
		int indexToCheck = 0;
		outer:
		while(nonRepeatingChar == null && indexToCheck < charArray.length){
			char charToCheck = charArray[indexToCheck];
			inner:
			for (int i = 0; i < charArray.length; i++) {
				if(indexToCheck == i){
					continue inner; //don't check char against itself 
				}
				//now check chars
				if(charArray[i] == charToCheck){
					//found duplicate so we can stop this loop and check the next character
					indexToCheck++;
					continue outer;
				}
			}
			//got this far so char doesn't repeat
			nonRepeatingChar = Character.valueOf(charToCheck);
		}
		return nonRepeatingChar;
	}
}
