package GenericUtility;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.IfFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * its contains Webdriver specific resuable actions
 * @POOJA P R
 * 
 * 
 */

public class WebDriverUtility {
/*
 * wait for the page to load before indentifying any sychronized element in DOM[HTML-Document]
 * @param driver
 * 
 */
	public void waitforPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
}
	
/*
 * wait for the page to load before indentifying any assychronized[javascript actions] element in DOM[HTML-Document]
 * @param driver
 * @param element
 */
	public void waitforPageToLoadforJSElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		
	}
	
/*
 *Used to  wait for element to be clickable in GUI. & cj]heck for specific element for every 500 milli seconds
 * @param driver
 * @param element
 */
	public void waitforPageTobeClickable(WebDriver driver,String title) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable((By) driver));
	}
	
/*
 *Used to  wait for element to be clickable in GUI. & cj]heck for specific element for every 500 milli seconds
 * @param driver
 * @param element
 * @param poling time in the from second
 * @throws Throwable
 */
	public void waitforElementWithCumtomTimeOut(WebDriver driver,WebElement element, int pollingTime) throws Throwable {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
/*
 *Used to switch to Any window based on window title
 *@param driver
 *@param partialWindowTiltle
 */
    public void switchToWindow(WebDriver driver, String partialWindowTitle){
    	Set<String> set = driver.getWindowHandles();
    	Iterator<String> it= set.iterator();
    	
    	while(it.hasNext()){
    		               String wID=it.next();
    		               driver.switchTo().window(wID);
    		              String CurrentWindowtitle = driver.getTitle();
    		              if (CurrentWindowtitle.contains(partialWindowTitle)) {
							break;
						}
    	}
    	
    }
/*
 *Used to switch to Alert Window & click on ok button
 *@param driver
 *
 */
    public void switchToAlertWindowAndAccept(WebDriver driver){
    	driver.switchTo().alert().accept();
    
    }
/*
 *Used to switch to Alert Window & click on Cancle button
 *@param driver
 *
 */
    public void switchToAlertWindowAndCancle(WebDriver driver){
    	driver.switchTo().alert().dismiss();
    
    }
	
	
/*
 *Used to switch to Alert Window & click on Cancle button
 *@param driver
 *
 */
       public void switchToFrame(WebDriver driver,int index){
       	driver.switchTo().frame(index);
       
       }
       
/*
 *Used to switch to Alert Window & click on Cancle button
 *@param driver
 *
 */
   public void switchToFrame(WebDriver driver,String id_name_attribute){
       driver.switchTo().frame(id_name_attribute);
          
    }
/*
 *Used to select the value from the dropDown based on index
 *@param driver
 *@param value
 *
 */
       public void select(WebElement dropdownValue, int industryDropDown){
    	   Select sel=new Select(dropdownValue);
    	   sel.selectByIndex(industryDropDown);
   	   
       }
 /*
  *Used to select the value from the dropDown based on values or values visible IN GUI
  *@param driver
  *@param value
  *
  */
       public void select(WebElement element, String text){
       Select sel=new Select(element);
      sel.selectByVisibleText(text);
      
       }
/*
 *Used to placve mouse cursor on specified element
 *@param driver
 *@param element
 *
 */    
        public void mouseOverOnElement(WebDriver driver, WebElement element){
        Actions act= new Actions(driver);
        act.moveToElement(element).perform();
          
        }
        /*
         *Used to placve mouse cursor on specified element
         *@param driver
         *@param element
         *
         */
        
        public void mouseOverbyoffset(WebDriver driver, int x, int y){
            Actions act= new Actions(driver);
            act.moveByOffset(x, y).click().perform();
              
            }
/*
 *Used to placve mouse cursor on specified element
 *@param driver
 *@param element
 *
 */
         public void rightclickONElement(WebDriver driver, WebElement element){
         Actions act= new Actions(driver);
         act.contextClick(element).perform();
           
         }    
/*
 *@param drivert
 *@param javascript
 */
         public void executeJavaScript(WebDriver driver, String javascript){
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeAsyncScript(javascript, null);   
         }	
	
         public void waitAndClick(WebElement element) throws InterruptedException{
        	 
        	 int count=0;
        	 while(count<20){
        		 try{
        			 element.click();
        			 break;
        			 
        		 }catch (Throwable e) {
		                 Thread.sleep(1000);
				         count++;
				         }
        	 }
         }
         public String takeScreenshort(WebDriver driver , String screenshotName) throws Throwable{
        	 TakesScreenshot ts=(TakesScreenshot)driver;
        	 File src=ts.getScreenshotAs(OutputType.FILE);
        	 String timeStamp = LocalDateTime.now().toString().replace(":", "-");
        	 File dest=new File("./screenshot/"+screenshotName+timeStamp+".png");
        	 FileUtils.copyFile(src, dest);
        	 
        	 return dest.getAbsolutePath();
         }
/*
 *pass enter Key appertain in to Browser
 *@param driver 
 * 
 */
	     public void passEnterKey(WebDriver driver){
	        Actions act=new Actions(driver);
	        act.sendKeys(Keys.ENTER).perform();
	    	 
	     }

		public void waitforPageTobeClickable1(WebDriver driver, String createdOrg) {
			// TODO Auto-generated method stub
			
		}

		

		
		


	
	
	
	
}
