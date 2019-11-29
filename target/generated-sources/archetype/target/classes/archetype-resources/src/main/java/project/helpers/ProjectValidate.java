#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.project.helpers;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import ${package}.project.utils.ConstantPaths;
import ${package}.project.utils.LogReports;
import ${package}.project.utils.PageAction;
import ${package}.project.utils.Loadproperties;



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