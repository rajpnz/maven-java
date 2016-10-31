package nz.co.rajees.back2work;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
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
		if(blockOfChars[0][1] == '_'){
			//could be 2,3,5,6,7,8,9
			if(blockOfChars[1][2] == '|'){
				//could be 2, 3, 7, 8, 9
				if(blockOfChars[1][0] == ' '){
					//could be 2, 3, 7
					if(blockOfChars[2][1] == ' '){
						return Integer.valueOf(7); //number 7
					} else{
						//could be 2, 3
						if(blockOfChars[2][0] == '|'){
							return Integer.valueOf(2); //number 2
						}else{
							return Integer.valueOf(3); //number 3
						}
					}
				}else{
					//could be 8,9
					if(blockOfChars[2][0] == ' '){
						return Integer.valueOf(9); //number 9
					} else{
						return Integer.valueOf(8); //number 8
					}
				}
			} else{
				//could be  5, 6
				if(blockOfChars[2][0] == ' '){
					return Integer.valueOf(5); //number 5
				} else{
					return Integer.valueOf(6); //number 6
				}
			}
		} else {
			// 1 or 4
			if(blockOfChars[1][0] == '|'){
				return Integer.valueOf(4); //number 4
			} else{
				return Integer.valueOf(1); //number 1
			}
		}
	}


	/**
	 * Build a 9 element array of number blocks. The number block arrays will represent all
	 * the characters that are used to make up 1 number 
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
			int frameColumn = 0;
			for (int j = 0; j < lineAsCharArray.length; j++) {
				char c = lineAsCharArray[j];
				frameNumber = Math.floorDiv(j,3);
				arrayOfNumberBlocks[frameNumber][frameRow][frameColumn] = c;
				if(frameColumn == 2){
					frameColumn = 0;
				} else{
					frameColumn++;
				}
				
			}
		}
		return arrayOfNumberBlocks;
	}	
	

}
