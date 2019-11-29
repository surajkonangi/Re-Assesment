package it.pkg.project.utils;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import it.pkg.project.dataproviders.ExcelReader;


public class PageAction {
	Loadproperties read = new Loadproperties();
	//RandomNumbers random = new RandomNumbers();
	public WebDriver driver;
	ExcelReader reader = getsheet(ConstantPaths.TESTDATA_FILE);

	public ExcelReader getsheet(String sheetname) {
		ExcelReader read = new ExcelReader();
		try {
			read.setPath(sheetname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return read;
	}

	public String getdata_fromExcel(String sheetname, String columnname, String rowname) {

		String datavalue = reader.getCellDataByColumnName(sheetname, columnname, rowname);
		return datavalue;
	}

//	public String randomnumber(String locator, String path) throws Exception {
//		int rand = random.getRandomNo();
//		System.out.println(rand);
//		String no = Integer.toString(rand);
//		System.out.println(no);
//		String number = read.readPropertiesFile(locator, path);
//		System.out.println(number + ".....xpath");
//		String invoiceLocator = number.replace("*", no);
//		System.out.println(invoiceLocator + ".....locator");
//		return invoiceLocator;
//	}
//
//	public int generateRandomIntIntRange(int min, int max) {
//		Random r = new Random();
//		return r.nextInt((max - min) + 1) + min;
//	}

	public PageAction(WebDriver driver) {
		this.driver = driver;
	}

	LogReports log = new LogReports();
	WebElement webElement;

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public WebElement selectLocators(String locatorType) {

		String[] locator = locatorType.split(":", 2);

		switch (locator[0]) {
		case "id":
			webElement = driver.findElement(By.id(locator[1]));
			break;
		case "name":
			webElement = driver.findElement(By.name(locator[1]));
			break;
		case "className":
			webElement = driver.findElement(By.className(locator[1]));
			break;
		case "linkText":
			webElement = driver.findElement(By.linkText(locator[1]));
			break;
		case "partialLinkText":
			webElement = driver.findElement(By.partialLinkText(locator[1]));
			break;
		case "tagName":
			webElement = driver.findElement(By.tagName(locator[1]));
			break;
		case "css":
			// System.out.println(locator[1]);
			webElement = driver.findElement(By.cssSelector(locator[1]));
			break;
		case "xpath":
			webElement = driver.findElement(By.xpath(locator[1]));
			break;

		}
		return webElement;
	}

	public void click(String element) {
		try {
			webElement = selectLocators(element);
			webElement.click();
		} catch (Exception e) {
			log.info("Element not clicked");
			e.printStackTrace();
		}
	}

	public void selectVisibleText(String element, String visibleText) {
		webElement = selectLocators(element);
		Select select = new Select(webElement);
		select.selectByVisibleText(visibleText);
	}

	public void selectValue(String element, String value) {
		webElement = selectLocators(element);
		Select select = new Select(webElement);
		select.selectByValue(value);
	}

	public void selectIndex(String element, int index) {
		webElement = selectLocators(element);
		Select select = new Select(webElement);
		select.selectByIndex(index);
	}

	public void sendKeys(String element, String value) {
		webElement = selectLocators(element);
		webElement.sendKeys(value);
	}

	public void clickEnter(String element) {
		webElement = selectLocators(element);
		webElement.sendKeys(Keys.ENTER);

	}

	public void clickTab(String element) {
		webElement = selectLocators(element);
		webElement.sendKeys(Keys.TAB);

	}

	public String getText(String element) {
		webElement = selectLocators(element);
		return webElement.getText();

	}

	public void scroll(String element) {
		webElement = selectLocators(element);
		js.executeScript("window.scrollBy(0,500)");
	}

	public void mouseOn(String element) {
		webElement = selectLocators(element);
		Actions action = new Actions(driver);
		action.moveToElement(webElement).perform();

	}

	public void tab(String element) {
		webElement = selectLocators(element);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
	}

	public void clear(String element) {
		webElement = selectLocators(element);
		webElement.clear();
	}

}