import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarDate {

	int date;
	int month;
	int year;

	public CalendarDate(int day, int month, int year) {
		super();
		this.date = day;
		this.month = month;
		this.year = year;
	}

	public CalendarDate() {

	}

	public CalendarDate getDate(int date, int month, int year) {
		String months[] = { "Jan", "Feb", "Mar", "Apr", "Maj", "Jun", "Jul", "Avg", "Sep", "Okt", "Nov", "Dec" };
		GregorianCalendar gcalendar = new GregorianCalendar();
		gcalendar.set(year, month - 1, date);
		CalendarDate cd = new CalendarDate(gcalendar.get(gcalendar.DATE),gcalendar.get(gcalendar.MONTH),gcalendar.get(gcalendar.YEAR));
		return cd;
	}
	
	public void setDate(int date, int month, int year) {
		
	}


	public void printDate(CalendarDate date) {
		String months[] = { "Jan", "Feb", "Mar", "Apr", "Maj", "Jun", "Jul", "Avg", "Sep", "Okt", "Nov", "Dec" };
		GregorianCalendar gcalendar = new GregorianCalendar();
		gcalendar.set(date.getYear(), date.getMonth() - 1, date.getDate());
		System.out.println((gcalendar.get(gcalendar.DATE)) + " " + (months[gcalendar.get(gcalendar.MONTH)]) + " "
				+ (gcalendar.get(gcalendar.YEAR)));
	}

	public int maxDaysInMonth(CalendarDate cd) {
		GregorianCalendar gcalendar = new GregorianCalendar();
		gcalendar.set(cd.getYear(), cd.getMonth() - 1, cd.getDate());
		
		int m = cd.getMonth();
		switch (m) {
		case 1: return 31;
		case 2: {
			if (gcalendar.isLeapYear(cd.getYear())) {
				return 29;
			} else {
				return 28;
			}
		}
		case 3: return 31; 
		case 4: return 30;
		case 5: return 31;
		case 6: return 30;
		case 7: return 31;
		case 8: return 31;
		case 9: return 30;
		case 10: return 31;
		case 11: return 30;
		case 12: return 31; 
		}
		return -1;
	}
	
	public boolean isDateValid(CalendarDate cd) {
		GregorianCalendar gcalendar = new GregorianCalendar();
		gcalendar.set(cd.getYear(), cd.getMonth() - 1, cd.getDate());
		
		int d = cd.getDate();
		int m = cd.getMonth();
		int y = cd.getYear();
		
		if (d>cd.maxDaysInMonth(cd) || d<0 || m>12 || m<0) {
			return false;
		}
		else return true;
	}
	
	
	@Override
	public String toString() {
		String months[] = { "Jan", "Feb", "Mar", "Apr", "Maj", "Jun", "Jul", "Avg", "Sep", "Okt", "Nov", "Dec" };
		return date + "." + months[month-1] + "." + year +".";
	}
	
	
	
	public int getDate() {
		return date;
	}

	public void setDate(int day) {
		this.date = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	

}
