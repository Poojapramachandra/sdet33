package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtility.ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleDataFromDAtaprovider {
	   WebDriver driver=null;
	@Test(dataProvider="getdata")
	public void login(String username,String passward,String lastname, String contact){
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://wwww.localhost:8888");
		 driver.findElement(By.name("user_name")).sendKeys(username);
	     driver.findElement(By.name("user_password")).sendKeys(passward);
	     driver.findElement(By.id("submitButton")).click();
	    
	}
@Test(dataProvider="getdata",dependsOnMethods="login")
	public void createContact(String username,String passward,String lastname, String contact){

    driver.findElement(By.linkText("Contacts")).click();
    driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
    driver.findElement(By.name("lastname")).sendKeys(lastname);
    driver.findElement(By.id("mobile")).sendKeys(contact);
    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    driver.close();
}

	@DataProvider
	public Object[][] getdata(){
		Object[][] objArray = new Object[1][4];
		objArray[0][0]="admin";
		objArray[0][1]="root";
		objArray[0][2]="pooja_123";
		objArray[0][3]="9900215128";
	
		return objArray;
		
	}
	
	@DataProvider
	public Object[][] dataProvider_Excel(String excelSheet) throws Throwable{
		ExcelUtility elib= new ExcelUtility();
		Object[][] arr = elib.fetchMutipleData(excelSheet);
		return arr;
		
	}

}
