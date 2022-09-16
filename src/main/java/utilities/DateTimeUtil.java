package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeUtil {
	
	/**
	 * This method returns the current date in the format specified
	 * @param format- return date format
	 * @return
	 */
	public String getCurrentDateTime(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		return sdf.format(cal.getTime());
	}
	
	/**
	 * This method increments/decrements the date passed based on the value provided
	 * @param format - Format of the date being passed and return date format
	 * @param date - date to be incremented/decremented
	 * @param value - positive for increment and negative for decrement
	 * @return
	 * @throws ParseException
	 */
	public String incrementOrDecrementDate(String format, String date, int value) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(date));
		cal.add(Calendar.DAY_OF_MONTH, value);
		return sdf.format(cal.getTime());
	}
	
	/**
	 * This method finds the days between 2 dates
	 * @param format - Format of the dates being passed
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	public int daysBetweenTwoDates(String format, String date1, String date2) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(sdf.parse(date1));
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(sdf.parse(date2));
		int diff = (int) Math.abs((cal1.getTimeInMillis()-cal2.getTimeInMillis())/86400000);
		return diff;
	}
}
