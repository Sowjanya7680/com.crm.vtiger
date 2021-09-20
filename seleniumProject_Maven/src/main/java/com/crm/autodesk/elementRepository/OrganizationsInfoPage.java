package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.protobuf.Value;

public class OrganizationsInfoPage {
	
	//Constructor
	
	public OrganizationsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Provide all WebElements
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationInfo;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industryInfo;
	
	@FindBy(id="dtlview_Type")
	private WebElement typeInfo;
	
	

	//Provide Getters
	public WebElement getOrganizationInfo() {
		return organizationInfo;
	}

	public WebElement getIndustryInfo() {
		return industryInfo;
	}
	
	public WebElement getTypeInfo() {
		return typeInfo;
	}
	
	//Provide Business Logic
	
	/**
	 * get organization information
	 * @return
	 */
	public String getOrganizationsInfo(){
		String value = organizationInfo.getText();
		return value;
	}
	
	/**
	 * get industry information
	 */
	public String getIndustriesInfo() {
		String value =industryInfo.getText();
		return value;
	}
	
	/**
	 * get type information
	 */
	public String getTypesInfo() {
		String value =typeInfo.getText();
		return value;
	}
	
	
}
