package com.crm.autodesk.seleniumframework.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateOrgwithMembersOf extends WebDriverUtility{
	
	//Utilization
	public CreateOrgwithMembersOf(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	//decalaration
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement membersofIcon;
	
	@FindBy(className="moduleName")
	private WebElement frame;
	
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchButton;
	
	@FindBy(linkText="qsp_raj")
	private WebElement orgname;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchnowButton;
	
	
    //getters
	public WebElement getMembersofIcon() {
		return membersofIcon;
	}
	public WebElement getFrame() {
		return frame;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	public WebElement getSaveButton() {
		return searchnowButton;
	}
	public WebElement getOrgname() {
		return orgname;
	}
	
	/**
	 * this method will click on memebers of icon and switch the control from main to child browser
	 * @param driver
	 * @param name
	 */
	//Bussiness logic
    public void MemberofIcon(WebDriver driver, String name){
		membersofIcon.click();
		switchToWindow(driver, "frame");
		searchButton.sendKeys(name);
		orgname.click();
	    switchToAlertWindowAndAccept(driver);
		//searchnowButton.click();
		
		
		
		
	}

	
}
