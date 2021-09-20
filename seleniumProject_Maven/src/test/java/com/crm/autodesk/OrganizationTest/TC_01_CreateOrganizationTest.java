package com.crm.autodesk.OrganizationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.BaseClass;
import com.crm.autodesk.elementRepository.CreateOrganizationPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.OrganizationsInfoPage;
import com.crm.autodesk.elementRepository.OrganizationsPage;

import junit.framework.Assert;

public class TC_01_CreateOrganizationTest extends BaseClass {

	@Test(groups = "SmokeSuite")
	public void createOrganizationTest() throws Throwable {
		// Get the organization name from external resources
		String ORGANIZATIONNAME = eLib.getExcelData("Sheet 1", 25, 2);

		// Create Organization
		HomePage hP = new HomePage(driver);
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		CreateOrganizationPage COP = new CreateOrganizationPage(driver);
		hP.clickOnOrganizations();
		orgPage.clickOncreateOrgImg();
		COP.createOrganization(ORGANIZATIONNAME + jLib.getRandomNum());

		// get created organization name

		WebElement editButton = driver.findElement(By.name("Edit"));
		wLib.waitForElementVisibility(driver, editButton);

		OrganizationsInfoPage orgInfo = new OrganizationsInfoPage(driver);

		String actualOrgInfo = orgInfo.getOrganizationsInfo();

		// Verify organization name
		Assert.assertTrue(actualOrgInfo.contains(ORGANIZATIONNAME));
	}

}
