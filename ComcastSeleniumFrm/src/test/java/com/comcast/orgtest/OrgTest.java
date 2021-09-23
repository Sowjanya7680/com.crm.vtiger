package com.comcast.orgtest;

import org.testng.annotations.Test;

public class OrgTest {

	@Test(groups = "Regression Test")
	public void CreateOrganizationTest() {

		System.out.println("execute CreateOrganization test");
	}

	@Test(groups = "Smoke Test")
	public void createOrganizationWithIndustryTest() {
		System.out.println("execute createOrganizationWithIndustry test");

	}

	@Test(groups = "Regression Test")
	public void deleteOrganizationTest() {

		System.out.println("execute deleteOrganization test");
	}

	@Test(groups = "Regression Test")
	public void SearchOrganizationTest() {

		System.out.println("execute SearchOrganization test");
	}

	@Test(groups = "Regression Test")
	public void editOrg() {

		System.out.println("execute editOrg test");
	}
}
