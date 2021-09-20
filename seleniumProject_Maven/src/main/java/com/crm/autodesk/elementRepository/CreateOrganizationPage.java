package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtilities.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility{
	
	WebDriver driver;
	
	//Constructor
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Provide all web Elements
	
	@FindBy(name= "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropdown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;


	//Provide Getters
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}
	

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Logic
	/**
	 * This method will create organization with manadatory fields 
	 * @param orgName
	 */
	 public void createOrganization(String orgName)
	 {
		 orgNameEdt.sendKeys(orgName);
		 saveBtn.click();
	 }
	 /**
	  * This method will create organization by using Industry type
	  * @param orgName
	  * @param indType
	  */
	 public void createOrganizationWithIndustry(String orgName, String indType)
	 {
		 orgNameEdt.sendKeys(orgName);
		 select(industryDropdown, indType);
		 saveBtn.click();
	 }
	 
	 public boolean createOrganizationWithIndustryWithDropdown(String orgName)
	 {
		 orgNameEdt.sendKeys(orgName);
		 industryDropdown.click();
		 return industryDropdown.isEnabled();
	 }
	 
	  public void createOrganizationWithType(String orgName, String Type)
	 {
		 orgNameEdt.sendKeys(orgName);
		 select(typeDropdown, Type);
		 saveBtn.click();
	 }
	  
	  public boolean createOrganizationWithTypeWithDropdown(String orgName)
		 {
			 orgNameEdt.sendKeys(orgName);
			 typeDropdown.click();
			 return typeDropdown.isEnabled();
		 }


		 
		 
	 
	

}
