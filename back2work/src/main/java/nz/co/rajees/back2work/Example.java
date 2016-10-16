package nz.co.rajees.back2work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public static int fibonacci(int index){
		boolean doRecurse = true;
		if(doRecurse){
			return fibonacciRecurse(index);
		}
		//0,1,1,2,3,5,8,13
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
		//0,1,1,2,3,5,8,13
		if( index == 0){
			return 0;
		} else if(index ==1){
			return 1;
		}
		return fibonacciRecurse(index -1) + fibonacciRecurse(index -2);
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
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < indexToStop; j++) {
				//5,9,4,7
				String comparej1 = result[j];
				String comparej2 = result[j + 1];
				if(comparej1.compareTo(comparej2) > 0){
					//need to swap
					result[j] = comparej2;
					result[j + 1] = comparej1;
				}
			}	
			indexToStop--;
		}
	}	
}
