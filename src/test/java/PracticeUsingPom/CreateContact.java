package PracticeUsingPom;

import java.util.concurrent.TimeUnit;

import org.bouncycastle.jcajce.provider.asymmetric.EC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * 
 *@author POOJA P R 
 * 
 */
public class CreateContact {

	public static void main(String[] args) throws Throwable {
		
		/*Create object to libaries*/
		
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib= new WebDriverUtility();
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		
		/*get random number*/
		int randomNum = jLib.getRandomNumber();
		
		/*read common data from Properties File*/
		String br = fLib.getPropertyKeyValue("br");
		String url = fLib.getPropertyKeyValue("url");
		String un = fLib.getPropertyKeyValue("un");
		String pwd = fLib.getPropertyKeyValue("pwd");
		
		
		/*read test data from excel file*/
		String orgName = eLib.getDataFromExcel("sheet1", 1, 1)+ randomNum;
		String contactName = eLib.getDataFromExcel("sheet1", 1, 4)+ randomNum;
		
		
		/*Step1:launch browser pass test url*/
		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
	     driver= new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.get(url);
	     wLib.waitforPageToLoad(driver);
	     
	     /*Step2:Login to Application*/
	   
	     driver.findElement(By.name("user_name")).sendKeys(un);
	     driver.findElement(By.name("user_password")).sendKeys(pwd);
	     driver.findElement(By.id("submitButton")).click();
		
		/*Step3:Navigate to Org page and create  new Org*/
	     driver.findElement(By.linkText("Organizations")).click();
         driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
         
         /*Step4:Create Organization */
         driver.findElement(By.className("detailedViewTextBox")).sendKeys(orgName);
         driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
         
         /*verifty the Organization name*/
         String title = driver.findElement(By.className("dvHeaderText")).getText();
         
         if (orgName.contains(title)) {
        	 System.out.println(orgName);
			
		}
		
		wLib.waitforPageTobeClickable(driver, title);
		
		
		/*Step5:Naviogate to Conatact page*/
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		/*Step6: create new contact with Orgname*/
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*verifty the Contact name*/
        String header= driver.findElement(By.className("dvHeaderText")).getText();
        
       
        if (contactName.contains(header)) {
        	 System.out.println("Contact with created Name "+contactName);
             
		}
		
	
		wLib.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		
	}
}
