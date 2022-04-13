package PracticeUsingPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.seleniumframework.ObjectRepository.CreatOrganationWith;
import com.crm.autodesk.seleniumframework.ObjectRepository.CreateOrgIconPage;
import com.crm.autodesk.seleniumframework.ObjectRepository.CreateOrgwithMembersOf;
import com.crm.autodesk.seleniumframework.ObjectRepository.HomePage;
import com.crm.autodesk.seleniumframework.ObjectRepository.LoginPage;
import com.crm.autodesk.seleniumframework.ObjectRepository.OrganazationInfromation;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_OrganizationWithType {
	
	public static void main(String[] args) throws Throwable {
		WebDriver driver= null;
		
		
	FileUtility flib=new FileUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelUtility elib= new ExcelUtility();
	JavaUtility jlib= new JavaUtility();
	
   String br = flib.getPropertyKeyValue("br");
   String url = flib.getPropertyKeyValue("url");
   String un = flib.getPropertyKeyValue("un");
   String pwd = flib.getPropertyKeyValue("pwd");
   
   if(br.equalsIgnoreCase("chrome")){
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   System.out.println("Launched  chrome browser");
	   
   }else if(br.equalsIgnoreCase("firefox")){
	   WebDriverManager.firefoxdriver().setup();
	   driver=new FirefoxDriver();
	   System.out.println("Launched  firefox  browser");
   }else{
	   System.out.println("browser not supported");
   }

   //maximize the browser page load, launch the url
   driver.manage().window().maximize();
   wlib.waitforPageToLoad(driver);
   driver.get(url);
   
   //login page displayed ,send username and passward click on login
   LoginPage login= new LoginPage(driver);
   login.Login(un, pwd);
   
   //Home page is displayed, click on Organization
   HomePage homepage =new HomePage(driver);
   homepage.Organationlink();
   
   //Organization page is displayed,click on Create Organization
   CreateOrgIconPage createNewOrg = new CreateOrgIconPage(driver);
   createNewOrg.CreateIcon();
   //random number
   int random = jlib.getRandomNumber();
   //Organization Name
    String orgName = elib.getDataFromExcel("sheet1", 1, 0);
    orgName=orgName+random;
    
   // String text = elib.getDataFromExcel("sheet1", 1, 4);
    
    
    //create org with 
    CreatOrganationWith org= new CreatOrganationWith(driver);
    org.CreateOrg(orgName);
    
    String name = elib.getDataFromExcel("sheet1", 1, 5);
    //move to members of icon and click
    CreateOrgwithMembersOf member= new CreateOrgwithMembersOf(driver);
    member.MemberofIcon(driver, name);
    wlib.switchToWindow(driver, orgName);
    
    
    
//	 Create Organization with type and save	   
//   CreatOrganationWith type = new CreatOrganationWith(driver);
//   type.CreateOrgWithType(orgName, text);
//   System.out.println("Orgcreated with orgName:"+orgName);
//   
//   
   
     
//   verify the result and get text
//   OrganazationInfromation info= new OrganazationInfromation(driver);
//   }else{
//	   System.out.println("Organazation not created====>Tc005===>fail");
//   }
//    String Actualresult = info.Orginfo();
//    System.out.println("Orgcreated with Actualresult:"+Actualresult);
//    
//    
//   verify
//   if(Actualresult.contains(orgName)){
//	 System.out.println("Organazation created Sucessfully= OrganazationTC005===>pass");
//   driver.close();
   
}
}