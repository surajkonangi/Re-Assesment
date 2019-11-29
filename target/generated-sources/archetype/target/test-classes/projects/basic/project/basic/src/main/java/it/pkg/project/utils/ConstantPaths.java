package it.pkg.project.utils;

import java.io.File;

public class ConstantPaths {

	public final static String USER_HOME = System.getProperty("user.dir") + File.separator;

	public final static String project = USER_HOME + File.separator + "resources" + File.separator + "locators"
			+ File.separator + "project.properties";

	public final static String CONFIG_FILE = USER_HOME + File.separator + "resources" + File.separator + "config"
			+ File.separator + "config.properties";

	public final static String TESTDATA_FILE = USER_HOME + File.separator + "resources" + File.separator + "testdata"
			+ File.separator + "project.xlsx";

	public final static String LOG4J_FILE = USER_HOME + File.separator + "resources" + File.separator + "log4j"
			+ File.separator + "log4j.properties";

	public final static String CHROME_FILE = USER_HOME + "lib" + File.separator + "chromedriver.exe";

	public final static String FIREFOX_FILE = USER_HOME + "lib" + File.separator + "geckodriver.exe";

	public final static String IE_FILE = USER_HOME + "lib" + File.separator + "IEDriverServer.exe";

	public static final String EXTENT_REPORTFILE = "extentreport.html";

}
