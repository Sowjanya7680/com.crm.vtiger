package com.crm.autodesk.Vtiger.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.ExcelFileUtility;
import com.crm.autodesk.GenericUtilities.JSONFileUtility;
import com.crm.autodesk.GenericUtilities.JavaUtility;
import com.crm.autodesk.GenericUtilities.WebDriverUtility;
import com.google.protobuf.BytesValue;

public class TC_04_CreateProductAndVerifyWithPartNumbertest {
	
	WebDriver driver = null;

	@Test
	public void createProductAndVerifyWithPartNumberTest() throws Throwable
	{
		// read all the necessary data
		JSONFileUtility jsonLib= new JSONFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		JavaUtility jLib = new JavaUtility();

		String BROWSER = jsonLib.readDataFromJson("browser");
		String URL = jsonLib.readDataFromJson("url");
		String USERNAME= jsonLib.readDataFromJson("username");
		String PASSWORD = jsonLib.readDataFromJson("password");

		String Productname = eLib.getExcelData("Sheet 1", 9, 2)+jLib.getRandomNum();;
		String PartNo = eLib.getExcelData("Sheet 1", 9, 3);

		//Launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("Firefox")) {
			driver= new FirefoxDriver();
		}else {
			System.out.println("Invalid Browser");
		}

		wLib.waitForPageLoad(driver);
		wLib.maximizeWindow(driver);
		driver.get(URL);

		//Login to Application

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Click on Product
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(Productname);
		driver.findElement(By.name("productcode")).sendKeys(PartNo);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//Wait for the page to load
		WebElement editbutton= driver.findElement(By.name("Edit"));
		wLib.waitForElementVisibility(driver, editbutton);
		String pno =driver.findElement(By.xpath("//td[contains (text(),'PRO')]")).getText();
		System.out.println(pno);
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(pno);
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		String productno = driver.findElement(By.xpath("//td[contains(text(),'PRO')]/../../tr[3]/td[2]")).getText();
		System.out.println(productno);
		if(productno.equals(pno))
		{
			System.out.println("Product matched successfully");
		} else {
			System.out.println("Product not matching");
		}

}
}