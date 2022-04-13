package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtility.FileUtility;
import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {
	public static void main(String[] args) throws Throwable  {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverUtility wLib= new WebDriverUtility();
		wLib.waitforPageToLoad(driver);
		FileUtility fLib=new FileUtility();
		String url = fLib.getPropertyKeyValue("url");
		driver.get(url);
		wLib.takeScreenshort(driver, "puja");
		
	}

}
