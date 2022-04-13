package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.seleniumframework.ObjectRepository.LoginPage;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLogintest {

	public static void main(String[] args) throws Throwable {
		
		WebDriverUtility wlib= new WebDriverUtility();
	    FileUtility flib = new FileUtility();
	    ExcelUtility elib = new ExcelUtility();
	    
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
	     String url = flib.getPropertyKeyValue("url");
	     String Un = flib.getPropertyKeyValue("un");
	     String pwd= flib.getPropertyKeyValue("pwd");
	     driver.manage().window().maximize();
	     driver.get(url);
	     wlib.waitforPageToLoad(driver);
		 LoginPage login = new LoginPage(driver);
		 login.Login(Un, pwd);
	     driver.close();

	}

}
