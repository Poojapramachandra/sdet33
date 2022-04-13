package com.crm.autodesk.seleniumframework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformation {
	
	//initialization of web element
	public ContactInformation(WebDriver driver){
	PageFactory.initElements(driver, this);
	}
	
	//declaration of web element
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactInformationLink;

	//getters method
	public WebElement getContactInformationLink() {
		return ContactInformationLink;
	}
	/**
	 * This method will click on get text from ContactInformation
	 * @return
	 */
	//Business logic
	public String ContactInformationLink(){
	String Actual=ContactInformationLink.getText();
        return Actual;
	}

}
