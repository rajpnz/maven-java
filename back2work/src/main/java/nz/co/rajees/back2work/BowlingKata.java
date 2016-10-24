package nz.co.rajees.back2work;

public class BowlingKata {

	/**
	 * Calculate the 10 pin bowling score for the given String. This is a code kata
	 * @param score The bowling score card that has been handed in. In the format "XXXXXXXXXXXX" or "9-9-9-9-9-9-9-9-9-9-"
	 * @return The score the player got while bowling. The maximum score is 300 
	 * @see <a href="http://codingdojo.org/cgi-bin/index.pl?KataBowling">Bowling Kata</a>
	 */
	public static int calculateBowlingScore(String score){
		int bowlingScore = 0;
		int nextScoreIndex = 0; // index of the next score we will process 
		int frameCount = 0; // count of frames that have been processed
		char[] charArrayOfScores = score.toCharArray();
		while(frameCount < 10 &&  nextScoreIndex < score.length()){
			int scoreForFrame = 0;
			if(charArrayOfScores[nextScoreIndex] == 'X'){
				//STRIKE - score for frame is 10 + next 2 scoring shots
				scoreForFrame = 10;
				//now calculate score for next 2 shots
				char nextShotScore = charArrayOfScores[nextScoreIndex + 1];
				char nextPlusOneShotScore = charArrayOfScores[nextScoreIndex + 2];
				if(nextPlusOneShotScore == '/'){
					scoreForFrame += 10;
				} else{
					scoreForFrame += scoreForSymbol(nextShotScore) + scoreForSymbol(nextPlusOneShotScore);
				}
				nextScoreIndex += 1;
			} else{
				char firstShotInFrame = charArrayOfScores[nextScoreIndex];
				char secondShotInFrame = charArrayOfScores[nextScoreIndex+1];
				if(secondShotInFrame == '/'){
					//SPARE score for frame is 10 + next scoring shot
					scoreForFrame = (10 + scoreForSymbol(charArrayOfScores[nextScoreIndex+2]));
				} else {
					//NORMAL 
					scoreForFrame = scoreForSymbol(firstShotInFrame) + scoreForSymbol(secondShotInFrame);
				}
				nextScoreIndex += 2; //
			}
			bowlingScore += scoreForFrame;
			frameCount++;
		}
		
		return bowlingScore;
	}

	private static int scoreForSymbol(char scoreSymbol) {
		if(scoreSymbol == 'X'){
			return 10;
		} else if(scoreSymbol == '-'){
			return 0;
		} else{
			return Integer.valueOf(Character.toString(scoreSymbol));
		}
	}
}
