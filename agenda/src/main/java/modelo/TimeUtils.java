package modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtils {
	
	public static Date maxDay(Date date) {
		
		if (date == null) {
			return date;
		}
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		
		return calendar.getTime();
	}
	
	public static Date minDay(Date date) {
		
		if (date == null) {
			return date;
		}		
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		return calendar.getTime();
	}
	
	public static Date addDate(Date date, int days) {
		
		if (date == null) {
			return date;
		}		
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		
		return calendar.getTime();
	}

	public static Date addMinutes(Date date, int minutes) {
		
		if (date == null) {
			return date;
		}		
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minutes);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		return calendar.getTime();
	}

public static Date addSeconds(Date date, int seconds){
	
		if (date == null){
			return date;
		}
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, seconds);
		
		return calendar.getTime();
}
	
	public static int differenceDate(Date date, Date date2) {
		
		if (date == null || date2 == null ) {
			return 0;
		}		
		
		return (int) ((date2.getTime() - date.getTime()) / (1000 * 60 * 60 * 24));
		
		
	}

	public static Date yesterday(){
		return TimeUtils.addDate( new Date() , -1 );
	}
	
	public static Date tomorow(){
		return TimeUtils.addDate( new Date() , 1 );
	}
	
	public static Date fullDateModify(Date toDate){
		Date dateNow = new Date();
		if(toDate.getDay() < dateNow.getDay()){
			dateNow = maxDay(toDate);
		}
		return dateNow ;
	}
	
	public static String getCurrentFormatedDate(){
        return String.format(" %s - %s ", getTodayDateFormated() , getTodayTimeFormated() ); 
	}

	/**
	 * @param date
	 * @return
	 */
	public static String getTodayTimeFormated() {
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat formatterTime = new SimpleDateFormat("hhmmss");
        String todayTime = formatterTime.format(date);
		return todayTime;
	}
	
	/**
	 * @param date
	 * @return
	 */
	public static String getTodayDateFormated() {
		Date date = Calendar.getInstance().getTime();
		DateFormat formatterDate = new SimpleDateFormat("yyyyMMdd");
        String todayDate = formatterDate.format(date);
		return todayDate;
	}
	
	
	
	public static Date firstDay(Date date) {
		
		if (date == null){
			return date;
		}
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();

	}
	
	public static Boolean isTheLastDayOfMonth(Date date) {
		
		int lastDate = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
		
		return lastDate == date.getDay();
	}
	public static Date minusDay(Date date, int days){
		
		if (date == null) {
			return date;
		}		
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DAY_OF_MONTH, -days);
		
		return calendar.getTime();
	}
	
	public static Date minusMonth(Date date, int months) {
		
		if (date == null) {
			return date;
		}		
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -months);
		
		return calendar.getTime();
	}
	
	public static Integer getDay(Date date) {	
		
//		return date.getDay();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		
		return calendar.get(Calendar.DAY_OF_MONTH);
	}	
	
	public static Integer getMonth(Date date) {	
		
//		return date.getDay();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		
		return calendar.get(Calendar.MONTH);
	}

	public static Date getLastOfMonth(Date date) {
		
		int lastDate = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
		Date dateNow = date;
		
		if(lastDate == date.getDay()){
			dateNow = TimeUtils.firstDay(date);
			dateNow = TimeUtils.minDay(dateNow);
		}
		
		return dateNow;
		
	}
	
}
