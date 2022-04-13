package SeleniumFrameworkWithTestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.seleniumframework.ObjectRepository.CreatOrganationWith;
import com.crm.autodesk.seleniumframework.ObjectRepository.CreateNewContact;
import com.crm.autodesk.seleniumframework.ObjectRepository.CreateNewOrganization;
import com.crm.autodesk.seleniumframework.ObjectRepository.HomePage;
import com.crm.autodesk.seleniumframework.ObjectRepository.OrganazationInfromation;

import GenericUtility.BaseClass;

public class CreateContactWithOrganization extends BaseClass{

	
	@Test
	public void CreateContactWithOrg() throws Throwable{
		//Click on  Organazation 
		//Added this line
		HomePage home= new HomePage(driver);
		home.Organationlink();
		
		//Click on Create new Organazation icon
		CreateNewOrganization add= new CreateNewOrganization(driver);
	    add.Addicon();
	    
	    
	    //sendOrgName in the mandatory filed
	    String orgName = elib.getDataFromExcel("Sheet1", 1, 0)+jlib.getRandomNumber();
	    CreatOrganationWith ORGname= new CreatOrganationWith(driver);
	    ORGname.CreateOrg(orgName);
	    
	    //verify the Organization and get text
	    OrganazationInfromation info= new OrganazationInfromation(driver);
	    String ActualValue = info.Orginfo();
	    
	    Assert.assertEquals(ActualValue.contains(orgName), true, orgName);
	    
	    //click on contacts
		home.Contact();
		
		//click on new contact icon
		String lastname = elib.getDataFromExcel("sheet2", 1, 1)+jlib.getRandomNumber();
		CreateNewContact addcontact= new CreateNewContact(driver);
		addcontact.lastnameTextField(lastname);
		
		
		
	}
}
