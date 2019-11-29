package it.pkg.project.validation;

import org.testng.Assert;

import it.pkg.project.utils.LogReports;
import it.pkg.project.utils.Loadproperties;
import it.pkg.project.utils.TestBase;


public class ValidateTestResult extends TestBase {
	static LogReports log = new LogReports();
	Loadproperties read = new Loadproperties();

	public static  boolean validateData(String actual,String expected) {
		try {
			Assert.assertEquals(actual, expected);
			
			return true;
		} catch (AssertionError assertionError) {
			
			return false;
		}
	}
}
