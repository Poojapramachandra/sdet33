package com.crm.autodesk.seleniumframework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreatOrganationWith extends WebDriverUtility{
	
	//Utilization of web Elements
	
	public CreatOrganationWith(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//declaration of web elements
	@FindBy(name="accountname")
	private WebElement OrganizationTextfield;
	
	@FindBy(name="accounttype")
	private WebElement Type;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private String OrgFrame;
	
	//gettrers

	public WebElement getOrganizationTextfiled() {
		return OrganizationTextfield;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	public WebElement getType() {
		return Type;
	}
	

	public String getOrgFrame() {
		return OrgFrame;
	}

	//Bussiness logic
	/**
	 * This method will create org with industry
	 * @param orgName
	 * @param DropdownValue
	 */
	public void CreateOrgwithIndustry(String orgName, String  DropdownValue ){
		OrganizationTextfield.sendKeys(orgName);
		select(industryDropDown, DropdownValue);
		saveButton.click();
		
	}

	/**
	 * This method will create Org with type
	 * @param orgName
	 * @param element
	 * @param text
	 */
	public void CreateOrgWithType(String orgName, String  text){
		OrganizationTextfield.sendKeys(orgName);
		select(Type, text);
		saveButton.click();
	}
	public void CreateOrg(String orgName){
		OrganizationTextfield.sendKeys(orgName);
		saveButton.click();	
		
	}
	
	
	

	public void Savebutton(){
		saveButton.click();	
	}
	
	
	public void Orgframe(WebDriver driver ){
		switchToWindow(driver, OrgFrame);
	}


	
	
	
	
		
	
}
