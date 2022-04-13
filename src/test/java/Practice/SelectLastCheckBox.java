package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectLastCheckBox {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");

		
		driver.findElement(By.name("user_name")).sendKeys("admin");
	      driver.findElement(By.name("user_password")).sendKeys("root");
	      driver.findElement(By.id("submitButton")).click();

	      driver.findElement(By.linkText("Organizations")).click();
	     driver.findElement(By.xpath("(//input[@name='selected_id'])[last()]")).click();
	 //    driver.close();
}

}
