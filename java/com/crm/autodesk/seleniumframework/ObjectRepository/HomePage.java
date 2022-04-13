package com.crm.autodesk.seleniumframework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

/*
 * 
 *This  
 * 
 * 
 */
public class HomePage extends WebDriverUtility {
	 public  HomePage(WebDriver driver){
		 PageFactory.initElements(driver, this);
		
	}
	 @FindBy(linkText="Organizations")
	 private WebElement Organization;
	 
	 @FindBy(linkText="Leads")
	 private WebElement Leads;
	 
	 @FindBy(linkText="Contacts")
	 private WebElement Contacts;
	 
	 @FindBy(linkText="Products")
	 private WebElement ProductsLink;
	 
	 @FindBy(linkText="Opportunities")
	 private WebElement Opportunities;
	 
	 @FindBy(linkText="Calendar")
	 private WebElement Calendar;
	 
	 
	 @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	 private WebElement signoutIcon;
	 
	 @FindBy(linkText="Sign Out")
	 private WebElement signoutlink;


	public WebElement getOrganization() {
		return Organization;
	}


	public WebElement getLeads() {
		return Leads;
	}


	public WebElement getContacts() {
		return Contacts;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}


	public WebElement getOpportunities() {
		return Opportunities;
	}


	public WebElement getCalendar() {
		return Calendar;
	}


	public WebElement getSignoutIcon() {
		return signoutIcon;
	}
	 
	 
	 public WebElement getSignoutlink() {
		return signoutlink;
	}



	/**
	  * this method is used to create Organization
	  * 
	  *
	  */
	 public void Organationlink(){
		  Organization.click();
		  
	  }
	 
	 /**
	  * this method is used to click on contacts on home page
	  */
	 public void Contact(){
		 Contacts.click();
		  
	  }
	 /**
	  * this method will return to home page and signout
	  * @param driver
	  */
	 public void logout(WebDriver driver){
		mouseOverOnElement(driver, signoutIcon);
		signoutlink.click();
	 }
	 
	 /**
	  * this method will click on product
	  */
	 public void Products(){
			ProductsLink.click();
		}
	 

}
