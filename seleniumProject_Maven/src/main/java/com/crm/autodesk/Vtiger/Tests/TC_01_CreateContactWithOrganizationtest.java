package com.crm.autodesk.Vtiger.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.ExcelFileUtility;
import com.crm.autodesk.GenericUtilities.JSONFileUtility;
import com.crm.autodesk.GenericUtilities.JavaUtility;
import com.crm.autodesk.GenericUtilities.WebDriverUtility;

public class TC_01_CreateContactWithOrganizationtest {
	
	WebDriver driver = null;

	@Test
	public void createContactWithOrganizationTest() throws Throwable
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

		String contactname = eLib.getExcelData("Sheet 1", 1, 2);
		String orgname = eLib.getExcelData("Sheet 1", 1, 3);
		 

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
		
		//Click on Contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click on create contact
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Create Contact
		driver.findElement(By.name("lastname")).sendKeys(contactname);
		
		//Inspect organization name
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		//New window will open need to handle the window
		//Switch to child Window
		wLib.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		
		//Enter something in searchbox and inspect entered data
		driver.findElement(By.linkText("Infosys")).click();
		
		//Switch back to parent window
		wLib.switchToWindow(driver,"Contacts");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		// Logout
		WebElement editbutton= driver.findElement(By.name("Edit"));
		wLib.waitForElementVisibility(driver, editbutton);
		//WebElement signout = driver.findElement(By.xpath("//td[@class='small']/table/tbody/tr/td[2][@class='small']"));
		 	//	Actions act = new Actions(driver);
		 	//	act.moveToElement(signout).perform();
		 	//driver.findElement(By.linkText("Sign Out")).click();
		WebElement signout = driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td[1]/img"));
		 		Actions act = new Actions(driver);
		 		act.moveToElement(signout).perform();
		 	driver.findElement(By.linkText("Sign Out")).click();
		
		
		
		
		
	}

}
