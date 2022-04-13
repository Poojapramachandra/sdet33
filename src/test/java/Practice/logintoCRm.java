package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class logintoCRm {
	public static void main(String[] args) throws Throwable {
	
		
        WebDriver driver = null;
       
		
		FileInputStream fs = new FileInputStream(".\\src\\main\\resources\\common_data\\Credentails.properties");
		Properties pro_obj = new Properties();
		pro_obj.load(fs);
		String br = pro_obj.getProperty("br");
		String url = pro_obj.getProperty("url");
		String un = pro_obj.getProperty("un");
		String pwd = pro_obj.getProperty("pwd");	
		if (br.equalsIgnoreCase(br)) {
			WebDriverManager.chromedriver().setup();
	       driver = new ChromeDriver();	
	       System.out.println("Launched Chrome browser");
		}else {
			WebDriverManager.chromedriver().setup();
	        driver = new FirefoxDriver();
	        System.out.println("launched firefox browser");
	       
		}
		System.out.println("url:"+url);
		System.out.println("username: "+un);
		System.out.println("passward: "+pwd);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       
       driver.findElement(By.name("user_name")).sendKeys(un);
       driver.findElement(By.name("user_password")).sendKeys(pwd);
       driver.findElement(By.id("submitButton")).click();
       driver.close();
        
        
	}
	
	
	
	
	

}
