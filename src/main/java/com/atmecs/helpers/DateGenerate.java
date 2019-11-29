package com.atmecs.helpers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.atmecs.dataproviders.ExcelWriteData;
import com.atmecs.utils.ConstantPaths;
import com.atmecs.utils.PageAction;

public class DateGenerate {
	String checkindate;
	String checkoutdate;
	public WebDriver driver;
	PageAction page = new PageAction(driver);

	@Test
	public void bookingDates() throws Exception {
		ExcelWriteData write = new ExcelWriteData(ConstantPaths.TESTDATA_FILE);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String systemDate = (dtf.format(now));
		// System.out.println(systemDate);

		Calendar bookingdate = Calendar.getInstance();
		bookingdate.setTime(dateformat.parse(systemDate));
		checkindate = page.getdata_fromExcel("date", "NoOfDays", "Checkindate");
		int aftertendays = Integer.parseInt(checkindate);
		bookingdate.add(bookingdate.DATE, aftertendays);
		String afteronemonth = dateformat.format(bookingdate.getTime());
		// System.out.println("date after one month" + checkindate);
		write.setCellData("date", "PolicyEfectedDates", 2, afteronemonth);

		Calendar bookingdays = Calendar.getInstance();
		bookingdays.setTime(dateformat.parse(systemDate));
		checkoutdate = page.getdata_fromExcel("date", "NoOfDays", "Checkoutdate");
		int afterdays = Integer.parseInt(checkoutdate);
		bookingdays.add(bookingdays.DATE, afterdays);
		String aftertwodays = dateformat.format(bookingdays.getTime());
		// System.out.println("date after 10 days" + checkoutdate);
		write.setCellData("date", "PolicyEfectedDates", 3, aftertwodays);

	}
}
