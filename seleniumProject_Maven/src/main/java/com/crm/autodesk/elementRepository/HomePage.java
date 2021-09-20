package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	
	@FindBy(xpath = "//td[@class='small']/table/tbody/tr/td[2][@class='small']")
	private WebElement administratorImg;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	
	//@FindBy(xpath = "//span[text()=' Administrator']/../following-sibling::td['Sign Out']")

	//@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(linkText = "Email")
	private WebElement emailLnk;
	
	@FindBy(linkText = "Oppurtunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLnk;
		
	
	//Provide Getters
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getEmailLnkElement() {
		return emailLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getLeadsLnk() {
		return leadsLnk;
	}

	//provide Business Logic
	
	public void clickOnOrganizations()
	{
		organizationLnk.click();
	}
	
	public void clickOnContacts()
	{
		contactsLnk.click();
	}
	
	public void signOut()
	{
		//(driver, administratorImg)
		signoutLnk.click();
	}
	
	public void clickOnLeads()
	{
		leadsLnk.click();

}
}