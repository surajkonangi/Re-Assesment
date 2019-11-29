#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.scenario.testscripts;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ${package}.project.utils.ConstantPaths;
import ${package}.project.utils.LogReports;
import ${package}.project.utils.PageAction;
import ${package}.project.utils.Loadproperties;
import ${package}.project.utils.TestBase;

public class Scenario extends TestBase {

	PageAction page;
	LogReports log;
	String url;

	@BeforeClass
	public void beforeTest() throws IOException {
		read = new Loadproperties();
		url = read.readPropertiesFile("Url1", ConstantPaths.CONFIG_FILE);
		driver.get(url);
	}

	@Test
	public void invoiceVerification() throws Exception {
		page = new PageAction(driver);
		read = new Loadproperties();
		log = new LogReports();

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
