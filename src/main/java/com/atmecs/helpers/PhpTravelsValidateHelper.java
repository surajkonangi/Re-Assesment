package com.atmecs.helpers;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.utils.ConstantPaths;
import com.atmecs.utils.LoadProperties;
import com.atmecs.utils.LogReports;
import com.atmecs.utils.PageAction;



public class PhpTravelsValidateHelper {

	PageAction page;
	LogReports log;
	LoadProperties read;
	public WebDriver driver;
	
	public void phpTravelsHelper(WebDriver driver) {
		this.driver = driver;
	}
		public void verifiText(WebDriver driver, String expectedData, String validationMessage) throws Exception {
			page = new PageAction(driver);
			log = new LogReports();
			read = new LoadProperties();
			String actualproduct;
			actualproduct = page.getText(read.readPropertiesFile(validationMessage, ConstantPaths.phptravels));
			Assert.assertEquals(actualproduct, expectedData);
			log.info("Successfully validated " + expectedData);
}
}