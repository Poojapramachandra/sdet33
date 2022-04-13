package com.crm.autodesk.seleniumframework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContact {
	//initialization of web element
    public CreateNewContact(WebDriver driver){
	PageFactory.initElements(driver, this);
    }
    
	//declaration of web element
	@FindBy(name="lastname")
	private WebElement lastnameTextField;
	
	@FindBy(xpath="//input[@name='account_name']")
	private WebElement OrganaziationName;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif'][1]")
	private WebElement CreateOrganazationIcon;
	
	
  // getters method
	public WebElement getLastnameTextField() {
		return lastnameTextField;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getOrganaziationName() {
		return OrganaziationName;
	}
	public WebElement getCreateOrganazationIcon() {
		return CreateOrganazationIcon;
	}
	
	//business logic
	/**
	 * this method will create contact with lastname 
	 * @param contactname
	 */
	public void lastnameTextField(String lastname ){
		lastnameTextField.sendKeys(lastname);
		saveButton.click();
	}
	
	public void lastnameTextField(){
	CreateOrganazationIcon.click();
	}

}
