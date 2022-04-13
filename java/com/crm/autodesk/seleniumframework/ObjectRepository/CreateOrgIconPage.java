package com.crm.autodesk.seleniumframework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgIconPage {
	/*
	 * This class s used to  Create Organazation Object Repository
	 * @author POOJA P R
	 */
	
	//utilization of web element
	public CreateOrgIconPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	//decalartion of webelement
	@FindBy(xpath="//img[@title='Create Organization...']")
    private WebElement CreateIcon;


	//getters
	public WebElement getCreateIcon() {
		return CreateIcon;
	}
	
	//bussiness logic
	/*
	 * This method will click on Create Icon
	 * 
	 */
	
	public void CreateIcon(){
		CreateIcon.click();
	}
	
	
}
