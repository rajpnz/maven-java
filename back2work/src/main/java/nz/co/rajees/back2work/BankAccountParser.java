package nz.co.rajees.back2work;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class BankAccountParser {

	/**
	 * Create the 9 digit account number from a give file 
	 * @param pathToAccountFile Path to file 
	 * @return 9 Digit account number
	 * @throws IOException
	 * @see <a href=
	 *      "http://codingdojo.org/cgi-bin/index.pl?KataBankOCR">Bank OCR Kata</a>
	 */
	public Integer createAccountNumberFromFile(String pathToAccountFile) throws IOException{
		char[][][] accountAsCharArray = buildArrayOfNumberBlocks(pathToAccountFile);
		StringBuilder accountNumber = new StringBuilder();
		for (int i = 0; i < accountAsCharArray.length; i++) {
			Integer oneAccountNumber = convertBlockToNumber(accountAsCharArray[i]);
			accountNumber.append(oneAccountNumber.toString());
		}

		return new Integer(accountNumber.toString());

	}
	
	
	/**
	 * Convert the 2 dimensional array to a number. 
	 * @param blockOfChars a 3 x 3 array that represents a number
	 * @return
	 */
	private Integer convertBlockToNumber(char[][] blockOfChars) {
		for(NumberPattern pattern : NumberPattern.values()){
			if(Arrays.deepEquals(pattern.getCharacterPattern(), blockOfChars)){
				return pattern.getValue();
			}
		}
		//couldn't find a matching pattern 
		return Integer.valueOf(-1);
	}


	/**
	 * Build a 9 element array of number blocks. The number block arrays will represent all
	 * the characters that are used to make up 1 number. The number block will be a 3x3 array of characters
	 * @param pathToAccountFile
	 * @return
	 * @throws IOException
	 */
	private char[][][] buildArrayOfNumberBlocks(String pathToAccountFile) throws IOException{
		Path path = FileSystems.getDefault().getPath(pathToAccountFile);
		List<String> fileLines = Files.readAllLines(path, Charset.defaultCharset());
		char[][][] arrayOfNumberBlocks = new char[9][3][3];
		for (int i = 0; i < 3; i++) {
			String oneLine = fileLines.get(i);
			char[] lineAsCharArray = oneLine.toCharArray();
			int frameNumber = 0;
			int frameRow = i;
			for (int j = 0; j < lineAsCharArray.length; j++) {
				char c = lineAsCharArray[j];
				frameNumber = Math.floorDiv(j,3);
				/*not sure if working out the frameColumn is clearer this way. 
				Check Git history for previous attempt*/
				int frameColumn = (j < 3) ? j : j%3;
				arrayOfNumberBlocks[frameNumber][frameRow][frameColumn] = c;
			}
		}
		return arrayOfNumberBlocks;
	}	

}
