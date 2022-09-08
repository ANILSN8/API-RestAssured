package GenericLibrary;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * to get the randomnum
	 * @return
	 */
public int getRandomNum() {
	Random random=new Random();
	int randomnum = random.nextInt(1000);
	return randomnum;
}
/**
 * to get system date and time
 * @return
 */
public String getSystemDate() {
	Date date=new Date();
	String dateTime = date.toString();
	return dateTime;
	
}
/**
 * to get system time and date in required format
 * @return
 */
public String SystemDateInFormat() {
	Date date=new Date();
	 String dateTime = date.toString();
	String[] dateArr = dateTime.split("  ");
	int month = date.getMonth()+1;
	String dat = dateArr[2];
	String year = dateArr[5];
	int day = date.getDay();
	String time = dateArr[3];
	String finalformat = month+"  "+dat+"  "+year+"  "+day+"  "+time;
	return finalformat;
}

}
