package org.jemco.contractorportal.invoice;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.DatatypeConverter;

public class XsdDateTimeConverter 
{

	public static Date parseDate(String s) {
	    return DatatypeConverter.parseDate(s).getTime();
	  }
	  public static String printDate(Date dt) {
	    Calendar cal = new GregorianCalendar();
	    cal.setTime(dt);
	    return DatatypeConverter.printDate(cal);
	  }
	  public static String printDateTime(Date dt) {
		    Calendar cal = new GregorianCalendar();
		    cal.setTime(dt);
		    return DatatypeConverter.printDateTime(cal);
		  }
	

	
}
