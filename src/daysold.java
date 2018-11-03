import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
/**
 * Assignment 1: Using standard libraries <br />
 * Calculate age in days
 */
public class daysold {

    /**
     * Calculate how many days between today and the date, and them out
     * @param birthday      {@code String} The start date
     * @throws ParseException 
     */
    public static void days(String birthday) throws ParseException {
        // TODO: Assignment 1 -- write your code here.
    	Calendar today = Calendar.getInstance(); // date for today
    	Calendar date = Calendar.getInstance(); // set as date of today for now
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // set format according to 'birthday' format
    	date.setTime(sdf.parse(birthday)); // put the 'birthday' in the date to be compared
    	Date time1 = date.getTime(); // get time of date in milliseconds
    	String full1 = new SimpleDateFormat("MMMM d yyyy").format(time1); // reformat date to match required format
    	Date time2 = today.getTime(); // get time of today in milliseconds
    	String full2 = new SimpleDateFormat("MMMM d yyyy").format(time2); // reformat date to match required format
    	System.out.printf("Birthday: " + full1 + "; today: " + full2 + " -- "); // output
    	if (today.before(date)){ // if date is after current date (incorrect birthday)
    		System.out.println("Wrong Birthday!"); // rest of output
    	} else { // Otherwise find how old you are
    		long daysBetween = ChronoUnit.DAYS.between(date.toInstant(), today.toInstant()); // find days between
        	System.out.println("You are " + daysBetween + " days old."); // rest of output
    	}   	   	
    } // public static void days(String birthday)

    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     * @throws ParseException 
     */
    public static void main(String[] args) throws ParseException {
        days("2000-1-1");
        days("3000-1-1");           // This is a wrong birthday
        // Extra Test Cases
//        days("2018-9-18");
//        days("2018-9-19");
//        days("2018-9-20");
//        days("1998-3-17");
//        days("2001-4-12");
    } // public static void main(String[] args)

}