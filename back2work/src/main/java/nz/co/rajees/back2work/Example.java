package nz.co.rajees.back2work;

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
}
