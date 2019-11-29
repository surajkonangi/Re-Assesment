package it.pkg.project.helpers;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import it.pkg.project.utils.ConstantPaths;
import it.pkg.project.utils.LogReports;
import it.pkg.project.utils.PageAction;
import it.pkg.project.utils.Loadproperties;



public class ProjectValidate {

	PageAction page;
	LogReports log;
	Loadproperties read;
	public WebDriver driver;
	
	public void projectHelper(WebDriver driver) {
		this.driver = driver;
	}
		public void verifiText(WebDriver driver, String expectedData, String validationMessage) throws Exception {
			page = new PageAction(driver);
			log = new LogReports();
			read = new Loadproperties();
			String actualproduct;
			actualproduct = page.getText(read.readPropertiesFile(validationMessage, ConstantPaths.project));
			Assert.assertEquals(actualproduct, expectedData);
			log.info("Successfully validated " + expectedData);
}
}