package nz.co.rajees.back2work;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://technologyconversations.com/2014/02/25/java-8-tutorial-through-katas-berlin-clock-easy/
 *
 */
public class BerlinClock {
	
	private static final Pattern PARSE_TIME_PATTERN = Pattern.compile("([0-2][0-9])::([0-5][0-9]):([0-5][0-9])");
	
	private String rawTime;
	private int hours = -1;
	private int minutes = -1;
	private int seconds = -1;
	
	public BerlinClock(String rawTime) throws IllegalArgumentException{
		this.rawTime = rawTime;
		try{
			parseTime();
		} catch(ParseException ex){
			throw new IllegalArgumentException(ex);
		}
	}
	
	private void parseTime() throws ParseException{
		//pattern [0-24]::[0-59]:[0-59]
		Matcher matcher = PARSE_TIME_PATTERN.matcher(rawTime);
		if (matcher.find())
		{
			String hourStr = matcher.group(1);
			hours = Integer.valueOf(hourStr);
			String minutesStr = matcher.group(2);
			minutes = Integer.valueOf(minutesStr);
			String secondsStr = matcher.group(3);
			seconds = Integer.valueOf(secondsStr); 
		} else {
			throw new ParseException("Could not extract time. Should be in format [hh::mm:ss]", 0);
		}
	}

	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public boolean isSecondsLampOn(){
		if(seconds%2 == 0){
			return true;
		}
		return false;
	}
	
	public String getHoursLampsConfigRow1(){
		int numberOfRedLamps = Math.floorDiv(hours, 5);
		String result = buildLampsOnString(numberOfRedLamps);
		return result;

	}

	private String buildLampsOnString(int numberOfLampsOn){
		String result = "";
		for (int i = 0; i < 4; i++) {
			if(numberOfLampsOn > i){
				result += "R";
			} else{
				result += "O";
			}
		}
		return result;		
	}
	
	public String getHoursLampsConfigRow2() {
		int numberOfOneHourLamps = 0;
		if(hours < 5){
			numberOfOneHourLamps= hours;
		} else {
			numberOfOneHourLamps = hours%5;
		}
		String result = buildLampsOnString(numberOfOneHourLamps);
		return result;
	}
}
