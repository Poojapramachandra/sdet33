package com.crm.autodesk.seleniumframework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	//initalization of constructor
	public CreateProductPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}


	//Declaration of web element
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement CreateProductIcon;

	//getters method
	public WebElement getCreateProductIcon() {
		return CreateProductIcon;
	}

	//business logic
	public void CreateProductIcon(){
	CreateProductIcon.click();
	}

}

