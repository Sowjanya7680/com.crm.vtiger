package com.crm.autodesk.OrganizationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.BaseClass;
import com.crm.autodesk.GenericUtilities.WebDriverUtility;
import com.crm.autodesk.elementRepository.CreateOrganizationPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.OrganizationsInfoPage;
import com.crm.autodesk.elementRepository.OrganizationsPage;

import junit.framework.Assert;

public class TC_05_CreateOrganizationWithTypeTest extends BaseClass {

	WebDriverUtility wdu = new WebDriverUtility();

	// @Test(groups="RegressionSuite")
	@Test(groups = "RegressionSuite")
	public void createOrganizationWithTypeTest() throws Throwable {
		// Get the organization name from external resources
		String ORGANIZATIONNAME = eLib.getExcelData("Sheet 1", 17, 2);
		String Type = eLib.getExcelData("Sheet 1", 17, 3);

		// Create Organization
		HomePage hP = new HomePage(driver);
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		CreateOrganizationPage createOrgp = new CreateOrganizationPage(driver);
		hP.clickOnOrganizations();
		orgPage.clickOncreateOrgImg();
		String orgName = ORGANIZATIONNAME + jLib.getRandomNum();
		createOrgp.createOrganizationWithType(orgName, Type);

		// get created organization name

		WebElement editButton = driver.findElement(By.name("Edit"));
		wdu.waitForElementVisibility(driver, editButton);

		OrganizationsInfoPage orgInfo = new OrganizationsInfoPage(driver);
		String actualOrgInfo = orgInfo.getOrganizationsInfo();
		String actualTypeInfo = orgInfo.getTypesInfo();
		Assert.assertTrue(actualOrgInfo.contains(orgName));
		Assert.assertTrue(actualTypeInfo.contains(Type));
	}

}
