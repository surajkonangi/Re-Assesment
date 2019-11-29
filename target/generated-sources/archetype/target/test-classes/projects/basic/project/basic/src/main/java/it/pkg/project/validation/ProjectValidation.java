package it.pkg.project.validation;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import it.pkg.project.helpers.ProjectValidate;
import it.pkg.project.utils.ConstantPaths;
import it.pkg.project.utils.LogReports;
import it.pkg.project.utils.PageAction;
import it.pkg.project.utils.Loadproperties;

public class ProjectValidation {

	WebDriver driver;
	LogReports log = new LogReports();
	PageAction page;
	Loadproperties read;
	ProjectValidate validate;

	public ProjectValidation(WebDriver driver) {
		this.driver = driver;
		page = new PageAction(driver);
		validate = new ProjectValidate();
		read = new Loadproperties();

	}

	public void Validate() throws Exception {
		log.info("validating username");
		String expectedUserName = page.getdata_fromExcel("sheet", "Inputs", "textname");
		validate.verifiText(driver, expectedUserName, "homepage.username.txt");

	}

	
}
