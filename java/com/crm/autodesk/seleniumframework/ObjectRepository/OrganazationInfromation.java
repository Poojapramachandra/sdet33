package com.crm.autodesk.seleniumframework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganazationInfromation {

	//Initaization of web element
	public OrganazationInfromation(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	

	//declarartion of Web Element
	@FindBy(className="dvHeaderText")
	private WebElement Orginfromation;

	
	
	//getters
	public WebElement getOrginfromation() {
		return Orginfromation;
	}
	
	
	//Bussiness logic
	public String  Orginfo(){
		String Actualresult = Orginfromation.getText();
		return Actualresult;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
