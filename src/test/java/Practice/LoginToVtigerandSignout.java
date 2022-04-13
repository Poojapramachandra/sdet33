package Practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class LoginToVtigerandSignout {
	public static void main(String[] args) {
		Random random = new Random();
		int ranNum = random.nextInt(1000);
		String orgName="TestyantrA_"+ranNum;
		
		WebDriver driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:88");
		
		/*Step1:login to application*/
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
		/*Step2: navigate to organzation*/
		driver.findElement(By.linkText("Organizations")).click();
		
		/*Step3 :navigate to create orgination page*/
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.className("detailedViewTextBox")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		/*Step4 verify*/
		String title = driver.findElement(By.className("dvHeaderText")).getText();
		if (title.contains(orgName)) {
			System.out.println(orgName+"is verified and pass");
			
		}else{
			System.out.println(orgName+"is not verified and fail");
		}
		
		/*Step 5 sign out and close the browser*/
		WebElement wb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act= new Actions(driver);
		act.moveToElement(wb).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		/*Step6 close the browser*/
		driver.close();
		
	}

}
