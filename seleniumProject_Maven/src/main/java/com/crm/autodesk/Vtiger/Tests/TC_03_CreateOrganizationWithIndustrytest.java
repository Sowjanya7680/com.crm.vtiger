package com.crm.autodesk.Vtiger.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.ExcelFileUtility;
import com.crm.autodesk.GenericUtilities.JSONFileUtility;
import com.crm.autodesk.GenericUtilities.JavaUtility;
import com.crm.autodesk.GenericUtilities.WebDriverUtility;

public class TC_03_CreateOrganizationWithIndustrytest {
	
	WebDriver driver = null;

	@Test
	public void createOrganizationWithIndustryTest() throws Throwable
	{
		// read all the necessary data
		JSONFileUtility jsonLib= new JSONFileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();

		String BROWSER = jsonLib.readDataFromJson("browser");
		String URL = jsonLib.readDataFromJson("url");
		String USERNAME= jsonLib.readDataFromJson("username");
		String PASSWORD = jsonLib.readDataFromJson("password");

		String orgname = eLib.getExcelData("Sheet 1", 5, 2)+jLib.getRandomNum();

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

		//click on Organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		WebElement listofindutryElement = driver.findElement(By.name("industry"));
		
		//Create obj of select class
		Select s = new Select(listofindutryElement);
		s.selectByVisibleText("Education");
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
		//Logout
		WebElement editbutton= driver.findElement(By.name("Edit"));
		wLib.waitForElementVisibility(driver, editbutton);
		WebElement signout = driver.findElement(By.xpath("//td[@class='small']/table/tbody/tr/td[2][@class='small']"));
		 		Actions act = new Actions(driver);
		 		act.moveToElement(signout).perform();
		 	driver.findElement(By.linkText("Sign Out")).click();
		


}
}
