package com.crm.autodesk.seleniumframework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.cj.xdevapi.AddResult;

public class ProductInfromation {

	//initialization of web element
		public ProductInfromation(WebDriver driver){
			PageFactory.initElements(driver, this);
		}

		//declaration of web element
		@FindBy(className ="lvtHeaderText")
		private WebElement productInformationLink;

		//getters method
		public WebElement getProductInformationLink() {
			return productInformationLink;
		}
		
		//business logic 
		public String productInformationLink(){
		String	Actualresult= productInformationLink.getText();
			return Actualresult;
		}
}
