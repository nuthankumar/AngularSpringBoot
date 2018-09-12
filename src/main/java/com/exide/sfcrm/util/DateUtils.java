package com.exide.sfcrm.util;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author saurabhp
 *
 */
public class DateUtils {
	public static final long MILLISECONDS_PER_DAY = 1000L * 60 * 60 * 24;;

	/**
	 * Compute the difference between two dates in days. The difference is
	 * computed as end - start
	 * 
	 * @param start
	 *            Start date
	 * @param end
	 *            End date
	 * @return The difference between the dates in number of days
	 */
	public static int dateDiff(Date start, Date end) {
		return (int) ((end.getTime() - start.getTime()) / MILLISECONDS_PER_DAY);
	}

	/**
	 * Returns today's date with the time part of the date set to 0
	 * 
	 * @return Today's date with time set to 00:00:00
	 */
	public static Date today() {
		Calendar cal = getCalendar();
		return cal.getTime();
	}

	public static Date yesterday() {
		Calendar cal = getCalendar();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	private static Calendar getCalendar() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}

	/**
	 * Returns the current date. Current implementation returns a new date.
	 * Useful to account for locale in the future
	 * 
	 * @return the current datetime
	 */
	public static Date now() {
		return new Date();
	}

	/**
	 * Returns the date part of the given date
	 * 
	 * @return Date with time set to 00:00:00
	 */
	public static Date date(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * Provides the current time (time part of the current date)
	 * 
	 * @return current time;
	 */
	public static Date time() {
		Calendar cal = Calendar.getInstance();
		cal.set(0, 0, 0);
		return cal.getTime();
	}

	/**
	 * Returns the time part of the day
	 * 
	 * @param date
	 *            The date for which the time part need to be extracted
	 * @return the time part of the day
	 */
	public static Date time(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(0, 0, 0);
		return cal.getTime();
	}

	/**
	 * Add minutes to the given date value
	 * 
	 * @param date
	 *            The date which minutes to be added
	 * @param minutes
	 *            The number of minutes to add
	 * @return A new date with the number of minutes added
	 */
	public static Date addMinutes(Date date, int minutes) {
		return new Date(date.getTime() + minutes * 1000 * 60);
	}

	/**
	 * Check if a date is after the other date. This method is a wrapper to
	 * {@link Date#after(Date)} with a null check
	 * 
	 * @param date1
	 *            The first date
	 * @param date2
	 *            The second date
	 * @return <code>true</code> if date1 is after date2. Otherwise returns
	 *         <code>false</code>. If either of the dates is <code>null</code>
	 *         returns <code>false</code>.
	 */
	public static boolean after(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return false;
		} else {
			return date1.after(date2);
		}
	}

	/**
	 * Check if a date is before the other date. This method is a wrapper to
	 * {@link Date#before(Date)} with a null check
	 * 
	 * @param date1
	 *            The first date
	 * @param date2
	 *            The second date
	 * @return <code>true</code> if date1 is before date2. Otherwise returns
	 *         <code>false</code> If either of the dates is <code>null</code>
	 *         returns <code>false</code>.
	 */
	public static boolean before(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return false;
		} else {
			return date1.before(date2);
		}
	}

	/**
	 * Check if a date is same as the other date. This method is a wrapper to
	 * {@link Date#equals(Date)} with a null check
	 * 
	 * @param date1
	 *            The first date
	 * @param date2
	 *            The second date
	 * @return <code>true</code> if both the dates are equal or both are
	 *         <code>null</code>. Otherwise returns <code>false</code>
	 */
	public static boolean equals(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return date1 == null && date2 == null;
		} else {
			return date1.equals(date2);
		}
	}

}
