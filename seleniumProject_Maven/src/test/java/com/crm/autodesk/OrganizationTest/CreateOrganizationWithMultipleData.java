package com.crm.autodesk.OrganizationTest;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.BaseClass;
import com.crm.autodesk.elementRepository.CreateOrganizationPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.OrganizationsInfoPage;
import com.crm.autodesk.elementRepository.OrganizationsPage;

public class CreateOrganizationWithMultipleData extends BaseClass{
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		return eLib.getExcelDataObject("");
	}
	
	@Test(dataProvider = "getData")
	
	public void createOrgWithMultipleData(String orgName, String IndType) {
		
		//Navigate To Organizations
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizations();
		Reporter.log("org link has been clicked");
		
		//Navigate to create Organizations page
		OrganizationsPage orgp = new OrganizationsPage(driver);
		orgp.clickOncreateOrgImg();
		Reporter.log("Organization has been created");
		
		//Create Organization
		CreateOrganizationPage createOrgP = new CreateOrganizationPage(driver);
		createOrgP.createOrganizationWithIndustry(orgName, IndType);
		Reporter.log("Organization has been created");
		
		//Verfication
		OrganizationsInfoPage orgInfop = new OrganizationsInfoPage(driver);
		String actualOrgInfo = orgInfop.getOrganizationsInfo();
		Assert.assertTrue(actualOrgInfo.contains(orgName));
		System.out.println(orgName);
	
		String actIndustryData = orgInfop.getIndustriesInfo();
		Assert.assertTrue(actIndustryData.contains(IndType));
		System.out.println(IndType);
		
		
		
	}
}
