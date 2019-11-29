#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.project.validation;

import org.testng.Assert;

import ${package}.project.utils.LogReports;
import ${package}.project.utils.Loadproperties;
import ${package}.project.utils.TestBase;


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
