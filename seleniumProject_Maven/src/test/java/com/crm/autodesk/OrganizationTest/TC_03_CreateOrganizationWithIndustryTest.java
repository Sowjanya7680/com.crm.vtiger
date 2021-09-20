package com.crm.autodesk.OrganizationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.BaseClass;
import com.crm.autodesk.GenericUtilities.WebDriverUtility;
import com.crm.autodesk.elementRepository.CreateOrganizationPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.OrganizationsInfoPage;
import com.crm.autodesk.elementRepository.OrganizationsPage;

@Listeners(com.crm.autodesk.GenericUtilities.Listners.class)
public class TC_03_CreateOrganizationWithIndustryTest extends BaseClass {

	WebDriverUtility wdu = new WebDriverUtility();

	@Test(groups = "RegressionSuite") // , retryAnalyzer = com.crm.autodesk.GenericUtilities.RetryAnalyzer.class)

	public void createOrganizationWithIndustryTest() throws Throwable {

		// Get the organization name from external resources
		String ORGANIZATIONNAME = eLib.getExcelData("Sheet 1", 13, 2);
		String INDUSTRY = eLib.getExcelData("Sheet 1", 13, 3);

		// Create Organization
		HomePage hP = new HomePage(driver);
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		CreateOrganizationPage createOrgp = new CreateOrganizationPage(driver);
		hP.clickOnOrganizations();
		orgPage.clickOncreateOrgImg();
		String orgName = ORGANIZATIONNAME + jLib.getRandomNum();
		createOrgp.createOrganizationWithIndustry(orgName, INDUSTRY);

		// get created organization name

		WebElement editButton = driver.findElement(By.name("Edit"));
		wdu.waitForElementVisibility(driver, editButton);

		OrganizationsInfoPage orgInfo = new OrganizationsInfoPage(driver);
		String actualOrgInfo = orgInfo.getOrganizationsInfo();
		String actualIndInfo = orgInfo.getIndustriesInfo();

		// Verify Organization name and Industry
		Assert.assertTrue(actualOrgInfo.contains(orgName));

		Assert.assertEquals(false, true);
		// Assert.assertEquals(true, true);

	}
}
