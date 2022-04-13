package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender {

	public static void main(String[] args) throws Throwable {
		
		
		WebDriverUtility wlib=new WebDriverUtility();
		FileUtility flib= new FileUtility();
		ExcelUtility elib= new ExcelUtility();
		JavaUtility jlib= new JavaUtility();
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		String url = flib.getPropertyKeyValue("url1");
		driver.get(url);
		wlib.waitforPageToLoad(driver);
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		wlib.mouseOverbyoffset(driver, 10, 10);
		driver.findElement(By.linkText("DEPARTURE")).click();
		
	
	}

}
