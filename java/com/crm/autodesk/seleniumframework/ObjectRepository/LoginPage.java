package com.crm.autodesk.seleniumframework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//initalization of web element
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}
	
	//declaration of web elements
	@FindBy(name="user_name")
	private WebElement UsernameTextfiled;
	
	@FindBy(name="user_password")
	private WebElement PasswardTextfiled;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	//getter method to use it in the test script

	public WebElement getUsernameTextfiled() {
		return UsernameTextfiled;
	}

	public WebElement getPasswardTextfiled() {
		return PasswardTextfiled;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	//Bussiness logic
	
   public  void Login(String Un, String pwd){
	   UsernameTextfiled.sendKeys(Un);
	   PasswardTextfiled.sendKeys(pwd);
	   loginButton.click();
	   
   }
	

}
