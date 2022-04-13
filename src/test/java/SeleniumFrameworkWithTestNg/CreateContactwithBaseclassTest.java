 /**package SeleniumFrameworkWithTestNg;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.seleniumframework.ObjectRepository.ContactInformation;
import com.crm.autodesk.seleniumframework.ObjectRepository.CreateContact;
import com.crm.autodesk.seleniumframework.ObjectRepository.CreateNewContact;
import com.crm.autodesk.seleniumframework.ObjectRepository.HomePage;

import GenericUtility.BaseClass;
import GenericUtility.RetryAnalayzerImplementationClass;


//@Listeners(GenericUtility.ListenersImplementaionClass.class)


public class CreateContactwithBaseclassTest extends BaseClass{

	@Test(retryAnalyzer=RetryAnalayzerImplementationClass.class)
	public void  createContact() throws Throwable{
		String lastname = elib.getDataFromExcel("sheet2", 1, 1)+jlib.getRandomNumber();
	
		
		HomePage home= new HomePage(driver);
		home.Contact();
		
		CreateContact con= new CreateContact(driver);
		con.AddIcon();
		
		Assert.fail();
		
		CreateNewContact contact= new CreateNewContact(driver);
		contact.lastnameTextField(lastname);
		
		ContactInformation info= new ContactInformation(driver);
		String Actualresult = info.ContactInformationLink();
		
	
		Assert.assertEquals(Actualresult.contains(lastname), true, Actualresult);
		
	}
	
	
	
}
*/
 
 