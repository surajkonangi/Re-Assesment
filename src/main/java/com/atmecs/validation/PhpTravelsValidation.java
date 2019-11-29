package com.atmecs.validation;

import org.openqa.selenium.WebDriver;

import com.atmecs.helpers.PhpTravelsValidateHelper;
import com.atmecs.utils.LoadProperties;
import com.atmecs.utils.LogReports;
import com.atmecs.utils.PageAction;

public class PhpTravelsValidation {

	WebDriver driver;
	LogReports log = new LogReports();
	PageAction page;
	LoadProperties read;
	PhpTravelsValidateHelper validate;

	public PhpTravelsValidation(WebDriver driver) {
		this.driver = driver;
		page = new PageAction(driver);
		validate = new PhpTravelsValidateHelper();
		read = new LoadProperties();

	}

	public void homePageValidate() throws Exception {
		log.info("validating homepage");
		String expectedHomePage = page.getdata_fromExcel("phpvalidate", "ContentToBeValidated", "homepage");
		validate.verifiText(driver, expectedHomePage, "homepage.home.txt");

	}

	public void searchPageValidation() throws Exception {
		log.info("validating search page");
		String expectedsearchpage = page.getdata_fromExcel("phpvalidate", "ContentToBeValidated", "searchpageheader");
		validate.verifiText(driver, expectedsearchpage, "searchpage.header.txt");

	}

	public void checkinDateValidation() throws Exception {
		log.info("validating checkindate");
		String expectedCheckinDate = page.getdata_fromExcel("phpvalidate", "ContentToBeValidated", "checkindate");
		validate.verifiText(driver, expectedCheckinDate, "searchpage.checkin.box");
	}

	public void checkOutDateValidation() throws Exception {

		log.info("validating checkoutdate");
		String expectedCheckoutDate = page.getdata_fromExcel("phpvalidate", "ContentToBeValidated", "checkoutdate");
		validate.verifiText(driver, expectedCheckoutDate, "searchpage.checkout.box");
	}

	public void totalNoOfAdultsValidation() throws Exception {
		log.info("validating total no of adults");
		String expectedTotalNoOFAdults = page.getdata_fromExcel("phpvalidate", "ContentToBeValidated",
				"totalnoofadults");
		validate.verifiText(driver, expectedTotalNoOFAdults, "searchpage.adults.txt");
	}

	public void totalNoOfChildValidation() throws Exception {

		log.info("validating total no of children");
		String expectedTotalNoOfChild = page.getdata_fromExcel("phpvalidate", "ContentToBeValidated", "totalnoofchild");
		validate.verifiText(driver, expectedTotalNoOfChild, "searchpage.child.txt");
	}

	public void hotelNameValidation() throws Exception {
		log.info("validateing hotel name");
		String expectedHotelName = page.getdata_fromExcel("phpvalidate", "ContentToBeValidated", "bookinghotelname");
		validate.verifiText(driver, expectedHotelName, "bookingpage.hotelname.txt");
	}

	public void hotelAddressValdation() throws Exception {
		log.info("validating hotel address");
		String expectedHotelAddress=page.getdata_fromExcel("phpvalidate", "ContentToBeValidated", "");
		validate.verifiText(driver, expectedHotelAddress, "bookingpage.hoteladdress.txt");

	}
}
