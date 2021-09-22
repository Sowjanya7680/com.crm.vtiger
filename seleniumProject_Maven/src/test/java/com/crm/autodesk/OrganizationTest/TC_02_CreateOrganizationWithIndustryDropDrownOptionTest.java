package com.crm.autodesk.OrganizationTest;

import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.BaseClass;
import com.crm.autodesk.elementRepository.CreateOrganizationPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.OrganizationsPage;

public class TC_02_CreateOrganizationWithIndustryDropDrownOptionTest extends BaseClass {

	@Test(groups = "SmokeSuites")

	public void createOrganizationTest() throws Throwable {

		// Get the organization name from external resources
		String ORGANIZATIONNAME = eLib.getExcelData("Sheet 1", 21, 2);

		// Create Organization
		HomePage hP = new HomePage(driver);
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		CreateOrganizationPage createOrgp = new CreateOrganizationPage(driver);
		hP.clickOnOrganizations();
		orgPage.clickOncreateOrgImg();
		String orgName = ORGANIZATIONNAME + jLib.getRandomNum();
		createOrgp.createOrganizationWithIndustryWithDropdown(orgName);

	}
}
