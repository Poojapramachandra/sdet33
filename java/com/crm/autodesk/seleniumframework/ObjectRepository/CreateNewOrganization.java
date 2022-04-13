package com.crm.autodesk.seleniumframework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganization {
	
	//initialization of web element
	  public CreateNewOrganization(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	//declaration web element
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement AddIcon;

	//getters method

	public WebElement getAddIcon() {
		return AddIcon;
	}

	//Business logic
	public void Addicon(){
		AddIcon.click();
	}

}
