package com.atmecs.testscripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.helpers.DateGenerate;
import com.atmecs.utils.ConstantPaths;
import com.atmecs.utils.LoadProperties;
import com.atmecs.utils.LogReports;
import com.atmecs.utils.PageAction;
import com.atmecs.utils.TestBase;
import com.atmecs.validation.PhpTravelsValidation;

public class PhpTravels extends TestBase {

	PageAction page;
	LogReports log;
	String url;
	PhpTravelsValidation validate;

	@BeforeClass
	public void beforeTest() throws IOException {
		read = new LoadProperties();
		url = read.readPropertiesFile("PhpTravels", ConstantPaths.CONFIG_FILE);
		driver.get(url);
	}

	@Test
	public void hotelBookingVerification() throws Exception {
		page = new PageAction(driver);
		read = new LoadProperties();
		log = new LogReports();
		validate = new PhpTravelsValidation(driver);
		DateGenerate date = new DateGenerate();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		log.info("STEP#1: validate home page");
		validate.homePageValidate();
		log.info("STEP#2: switch to chat widget frame");
		driver.switchTo().frame("chat-widget");
		log.info("STEP#3: click on chatnow box");
		page.click(read.readPropertiesFile("homepage.chantnow.btn", ConstantPaths.phptravels));
		Thread.sleep(2000);
		log.info("STEP#4: clickon popup box");
		page.click(read.readPropertiesFile("homepage.popup.btn", ConstantPaths.phptravels));
		log.info("STEP#5: switch to parent frame");
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		log.info("STEP#6: mouse on to chat now box");
		page.mouseOn(read.readPropertiesFile("homepage.chatnow.img", ConstantPaths.phptravels));
		log.info("STEP#7: click on 'x' button");
		page.click(read.readPropertiesFile("homepage.smallpopup.cancelbtn", ConstantPaths.phptravels));
		log.info("STEP#8: fetch required destination city from excel");
		String destination = page.getdata_fromExcel("phptravels", "BookingInputs", "Destination");
		log.info("STEP#9: enter the destination");
		page.sendKeys(read.readPropertiesFile("homepage.entersedtination.box", ConstantPaths.phptravels), destination);
		page.click(read.readPropertiesFile("homepage.selectdestination.txt", ConstantPaths.phptravels));
		log.info("STEP#10: select checkin date");
		date.bookingDates();
		String checkInDate = page.getdata_fromExcel("date", "PolicyEfectedDates", "Checkindate");
		page.sendKeys(read.readPropertiesFile("homepage.checkin.box", ConstantPaths.phptravels), checkInDate);
		log.info("STEP#11: select checkout date");
		String checkOutDate = page.getdata_fromExcel("date", "PolicyEfectedDates", "Checkoutdate");
		page.sendKeys(read.readPropertiesFile("homepage.checkout.box", ConstantPaths.phptravels), checkOutDate);
		log.info("STEP#12: increasing no of adult passengers");
		page.click(read.readPropertiesFile("homepage.addadult.btn", ConstantPaths.phptravels));
		page.click(read.readPropertiesFile("homepage.addadult.btn", ConstantPaths.phptravels));
		log.info("STEP#13: increaseing no of child passesngers");
		page.click(read.readPropertiesFile("homepage.addchild.btn", ConstantPaths.phptravels));
		page.click(read.readPropertiesFile("homepage.addchild.btn", ConstantPaths.phptravels));
		log.info("STEP#14: click on search button");
		page.click(read.readPropertiesFile("homepage.search.btn", ConstantPaths.phptravels));
		log.info("STEP#15: validate searchpage header");
		validate.searchPageValidation();
		log.info("STEP#16: click on modify button");
		page.click(read.readPropertiesFile("searchpage.modify.btn", ConstantPaths.phptravels));
		log.info("STEP#17: validate checkin date");
		validate.checkinDateValidation();
		log.info("STEP#18: validate checkout date");
		validate.checkOutDateValidation();
		log.info("STEP#19: validate total no of  adults ");
		validate.totalNoOfAdultsValidation();
		log.info("STEP#20: validate total no of child");
		validate.totalNoOfChildValidation();
		log.info("STEP#21: select hotel with fourstar and low price");
		List<WebElement> hotels = driver.findElements(
				By.xpath(read.readPropertiesFile("searchpage.fourstarhotelprice.txt", ConstantPaths.phptravels)));
		int fourStarHotels = hotels.size();
		// System.out.println(hotels.size());
		List<String> alist = new ArrayList<String>();
		for (WebElement allList : hotels) {
			alist.add(allList.getText());
		}
		System.out.print(alist);
		List<String> sorts = new ArrayList<String>(alist);
		Collections.sort(sorts);
		for (int i = 0; i < fourStarHotels; i++) {
			// System.out.print(sorts.get(i));

		}
		String text = driver
				.findElement(By.xpath(read.readPropertiesFile("searchpage.hotelname.txt", ConstantPaths.phptravels)))
				.getText();
		System.out.println(text);
		if (text.equalsIgnoreCase(page.getdata_fromExcel("phptravels", "BookingInputs", "hotelname"))) {

		}
		log.info("STEP#22: click on the hotel");
		page.click(read.readPropertiesFile("searchpage.hoteldetails.btn", ConstantPaths.phptravels));
		log.info("STEP#23: validate hotel name");
		validate.hotelNameValidation();
		log.info("STEP#24: validate hotel address");
		validate.hotelAddressValdation();
		log.info("STEP#25: navigate to available rooms");
		page.click(read.readPropertiesFile("bookingpage.availablerooms.btn", ConstantPaths.phptravels));
		log.info("STEP#26: validate checkin date");
		validate.checkinDateValidation();
		log.info("STEP#27: validate checkout date");
		validate.checkOutDateValidation();
		log.info("STEP#28: validate no of adults");
		validate.totalNoOfAdultsValidation();
		log.info("STEP#29: validate nonof child");
		validate.totalNoOfChildValidation();

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
