package com.crm.autodesk.OrganizationTest;

import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.BaseClass;
import com.crm.autodesk.elementRepository.CreateOrganizationPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.OrganizationsPage;

public class TC_04_CreateOrganizationWithTypeDropDownTest extends BaseClass {

	@Test(groups = "SmokeSuites")

	public void createOrganizationWithTypeDropDownTest() throws Throwable {
		// Get the organization name from external resources
		String ORGANIZATIONNAME = eLib.getExcelData("Sheet 1", 25, 2);

		// Create Organization
		HomePage hP = new HomePage(driver);
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		CreateOrganizationPage createOrgp = new CreateOrganizationPage(driver);
		hP.clickOnOrganizations();
		orgPage.clickOncreateOrgImg();
		String orgName = ORGANIZATIONNAME + jLib.getRandomNum();
		System.out.println(createOrgp.createOrganizationWithTypeWithDropdown(orgName));

	}

}
