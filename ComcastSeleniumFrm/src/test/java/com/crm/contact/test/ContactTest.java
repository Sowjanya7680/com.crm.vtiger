package com.crm.contact.test;

import org.testng.annotations.Test;

public class ContactTest {
	@Test(groups = "Smoke Test")
	public void CreateContactTest() {

		System.out.println("execute createContact test");
	}

	@Test(groups = "Regression Test")
	public void createContactWithOrgTest() {
		System.out.println("execute createContactWithOrgTest test");

	}

	@Test(groups = "Smoke Test")
	public void deleteContactTest() {

		System.out.println("execute deleteContact test");
	}
}