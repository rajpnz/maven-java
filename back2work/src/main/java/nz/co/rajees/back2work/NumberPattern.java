package nz.co.rajees.back2work;

/**
 * Holds a 3 x 3 character array that is a pattern for a number
 *
 */
public enum NumberPattern {
	ONE(Integer.valueOf(1), new char[][]
		{{' ',' ', ' ' },
	     {' ',' ', '|'},
	     {' ',' ', '|'}}),
	TWO(Integer.valueOf(2), new char[][]
		{{' ','_', ' ' },
		 {' ','_', '|'},
		 {'|','_', ' '}}),
	THREE(Integer.valueOf(3), new char[][]
		{{' ','_', ' ' },
		 {' ','_', '|'},
	     {' ','_', '|'}}),
	FOUR(Integer.valueOf(4), new char[][]
		{{' ',' ', ' ' },
		 {'|','_', '|'},
		 {' ',' ', '|'}}),
	FIVE(Integer.valueOf(5), new char[][]
		{{' ','_', ' ' },
		 {'|','_', ' '},
		 {' ','_', '|'}}),
	SIX(Integer.valueOf(6), new char[][]
	    {{' ','_', ' ' },
		 {'|','_', ' '},
		 {'|','_', '|'}}),
	SEVEN(Integer.valueOf(7), new char[][]
		 {{' ','_', ' ' },
		  {' ',' ', '|'},
		  {' ',' ', '|'}}),	
	EIGHT(Integer.valueOf(8), new char[][]
		 {{' ','_', ' ' },
		  {'|','_', '|'},
		  {'|','_', '|'}}),
	NINE(Integer.valueOf(9), new char[][]
		 {{' ','_', ' ' },
		  {'|','_', '|'},
		  {' ','_', '|'}});	


	private Integer value;
	private char[][] characterPattern;
	
	private NumberPattern(Integer value, char[][] characterPattern) {
		this.value = value;
		this.characterPattern = characterPattern;
	}
	
	public Integer getValue() {
		return value;
	}

	public char[][] getCharacterPattern() {
		return characterPattern;
	}	
}
