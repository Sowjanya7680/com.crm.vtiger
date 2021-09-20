package com.crm.autodesk.OrganizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.BaseClass;
import com.crm.autodesk.GenericUtilities.ExcelFileUtility;
import com.crm.autodesk.GenericUtilities.JSONFileUtility;
import com.crm.autodesk.GenericUtilities.JavaUtility;
import com.crm.autodesk.GenericUtilities.WebDriverUtility;
import com.crm.autodesk.elementRepository.CreateOrganizationPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;
import com.crm.autodesk.elementRepository.OrganizationsInfoPage;
import com.crm.autodesk.elementRepository.OrganizationsPage;

import junit.framework.Assert;

public class TC_04_CreateOrganizationWithTypeDropDownTest extends BaseClass{
	
	@Test(groups="SmokeSuite")
	
	public void createOrganizationWithTypeDropDownTest() throws Throwable
	{
		//Get the organization name from external resources
		String ORGANIZATIONNAME = eLib.getExcelData("Sheet 1", 25, 2);
	
		//Create Organization
		HomePage hP = new HomePage(driver);
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		CreateOrganizationPage createOrgp = new CreateOrganizationPage(driver);
		hP.clickOnOrganizations();
		orgPage.clickOncreateOrgImg();
		String orgName = ORGANIZATIONNAME + jLib.getRandomNum();
		System.out.println(createOrgp.createOrganizationWithTypeWithDropdown(orgName));
				
	}

}
