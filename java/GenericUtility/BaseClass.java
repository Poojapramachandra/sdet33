package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.autodesk.seleniumframework.ObjectRepository.HomePage;
import com.crm.autodesk.seleniumframework.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver = null;
	public FileUtility flib= new FileUtility();
    public ExcelUtility elib= new ExcelUtility();
    public WebDriverUtility wlib= new WebDriverUtility();
    public JavaUtility  jlib= new JavaUtility();
    public static WebDriver sDriver;
    
    
    @BeforeSuite(groups={"SmokeTesting","RegressionTesting"})
    public void OpenDataBase(){
    	System.out.println("data base connection");
    }
    
    @BeforeTest(groups={"SmokeTesting","RegressionTesting"})
    public void ParallelExecution(){
    	System.out.println("execute script in parallel mode");
    }
    
    //@Parameters("browser")
    @BeforeClass(groups={"SmokeTesting","RegressionTesting"})
    public void LaunchBrowser() throws Throwable{
    	//String browser = flib.getPropertyKeyValue("br");
    	//String url = flib.getPropertyKeyValue("url");
    	String browser= System.getProperty("browser");
    	String url= System.getProperty("url");
    	if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
			
		}else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		    driver= new FirefoxDriver();
		}else{
			throw new Exception("Browser is not supporting");
		}
    	driver.get(url);
    	driver.manage().window().maximize();
    	wlib.waitforPageToLoad(driver);
    	sDriver=driver; 
    }
   
    @BeforeMethod(groups={"SmokeTesting","RegressionTesting"})
    public void LoginToApplication() throws Throwable{
    	String un = flib.getPropertyKeyValue("un");
    	String pwd = flib.getPropertyKeyValue("pwd");
    	
    	LoginPage login= new LoginPage(driver);
    	login.Login(un, pwd);
    }
    
    @AfterMethod(groups={"SmokeTesting","RegressionTesting"})
    public void LogoutFromApplication(){
    	HomePage home= new HomePage(driver);
    	home.logout(driver);
    }
    @AfterClass(groups={"SmokeTesting","RegressionTesting"})
    public void CloseBrowser(){
    	driver.quit();
    	
    }
    @AfterTest(groups={"SmokeTesting","RegressionTesting"})
    public void CloseparallelExecution(){
    	System.out.println("close parallel mode execution");
    }
    
    @AfterSuite(groups={"SmokeTesting","RegressionTesting"})
    public void CloseDatabaseConnection(){
    	System.out.println("close data base connection");
    }
}
