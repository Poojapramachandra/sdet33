package Practice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectTodaysDateTest {
	
	public static void main(String[] args) {
		
		WebDriverUtility wlib=new WebDriverUtility();
		
		 LocalDateTime dateAndTime = LocalDateTime.now();
			String month = dateAndTime.getMonth().toString();
			int date = dateAndTime.getDayOfMonth();
			int year = dateAndTime.getYear();
			String actualmonth = month.substring(0, 1)+month.substring(1).toLowerCase();
			String monthAndYear = actualmonth+" "+year;
		   
		    
		    WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			wlib.waitforPageToLoad(driver);
			driver.get("https://www.makemytrip.com");
			
			Actions act = new Actions(driver);
			act.moveByOffset(10, 10).click().perform();
			driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
			driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
			String Path = "//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
			driver.findElement(By.xpath(Path)).click();
			
			driver.findElement(By.xpath("//label[@for='fromCity']")).click();
			driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).sendKeys("Bangalore");
			driver.findElement(By.xpath("//p[text()='Bangalore, India']")).click();
			
			
			driver.findElement(By.xpath("//span[text()='To']")).click();
			driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).sendKeys("New Delhi");
			driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();
			
			driver.findElement(By.xpath("//a[text()='Search']")).click();
			List<WebElement> ele = driver.findElements(By.xpath("//div[@class='makeFlex simpleow']/descendant::div[@class='makeFlex align-items-center  ']"));
			
			for(WebElement names : ele){
				System.out.println(names.getText());
			}
	}	

}
