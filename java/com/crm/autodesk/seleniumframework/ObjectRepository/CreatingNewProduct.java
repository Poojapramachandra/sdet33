package com.crm.autodesk.seleniumframework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProduct {
	//initialization of web element
		public CreatingNewProduct(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
		
		
		//declaration of web element
		@FindBy(name="productname")
		private WebElement ProductNameTextField;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveButton;
		
		//getters method
		public WebElement getProductNameTextField() {
			return ProductNameTextField;
		}
		public WebElement getSaveButton() {
			return saveButton;
		}
		
		//business logic
		public void ProductNameTextField(String ProductName){
			ProductNameTextField.sendKeys(ProductName);
			saveButton.click();
				}
		
		public void saveButton(){
			saveButton.click();
			
		}
		
	

}
