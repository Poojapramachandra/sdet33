package Organazation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Organization {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		
	
		String orgName = eLib.getDataFromExcel("Orgnazation", 1, 3);
		System.out.println("Organization name is "+ orgName);	
		int random=jLib.getRandomNumber();
		orgName=orgName+random;
		
		String br=fLib.getPropertyKeyValue("br");
		String url=fLib.getPropertyKeyValue("url");
		String un=fLib.getPropertyKeyValue("un");
		String pwd=fLib.getPropertyKeyValue("pwd");
		
		WebDriverManager.chromedriver().setup();
	     driver=new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.get(url);
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   /*login using valid user name and passward*/
	     driver.findElement(By.name("user_name")).sendKeys(un);
	     driver.findElement(By.name("user_password")).sendKeys(pwd);
	     driver.findElement(By.id("submitButton")).click();
	     
	  /*click on organization*/
         driver.findElement(By.linkText("Organizations")).click();
         driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
         
      /*validate the OrganizationName is created*/   
         driver.findElement(By.className("detailedViewTextBox")).sendKeys(orgName);
         driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
         
         String CreatedOrg = driver.findElement(By.className("dvHeaderText")).getText();
         if (CreatedOrg.contains(orgName)) {
        	 System.out.println("Organization created Succesfully: "+orgName+"===>pass");
			
		} else {
			System.out.println("Organization created UnSuccesfully"+orgName+"===>failed");

		}
         
         driver.close();
  
	}

	
	}


