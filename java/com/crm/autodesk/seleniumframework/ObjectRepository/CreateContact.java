package com.crm.autodesk.seleniumframework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContact {

	//initialization
	public CreateContact(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement Addicon;
	//geters
	public WebElement getAddicon() {
		return Addicon;
	}
	//business logic
	public void AddIcon(){
		Addicon.click();
	}
	
	
	
}
