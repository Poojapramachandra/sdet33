package PracticeUsingPom;

import org.testng.annotations.Test;

import com.crm.autodesk.seleniumframework.ObjectRepository.CreatOrganationWith;
import com.crm.autodesk.seleniumframework.ObjectRepository.CreateNewOrganization;
import com.crm.autodesk.seleniumframework.ObjectRepository.HomePage;
import com.crm.autodesk.seleniumframework.ObjectRepository.OrganazationInfromation;

import GenericUtility.BaseClass;

public class CreateOrganizationWithType extends BaseClass{
	
	
	
	@Test
	public void CreateOrgwithType() throws Throwable{
		
    //Organization Name and type text
	String orgName = elib.getDataFromExcel("Sheet1", 1, 0)+jlib.getRandomNumber();
    String text=elib.getDataFromExcel("Sheet1", 1, 4);	
    
    //Application Homepae
    HomePage home= new HomePage(driver);
    home.Organationlink();
		    
    //Create Organization with type and save
     CreateNewOrganization add= new CreateNewOrganization(driver);
     add.Addicon();
   	 CreatOrganationWith type = new CreatOrganationWith(driver);
     type.CreateOrgWithType(orgName, text);
	 System.out.println("Orgcreated with orgName:"+orgName);
      
    //verify the result and get text
	 OrganazationInfromation info= new OrganazationInfromation(driver);
	 String Actualresult = info.Orginfo();
    
	 if (Actualresult.contains(orgName)) {
			System.out.println("Contact Created sucessfully"+orgName+"====>pass");
		} else {
			System.out.println("Contact not created ======>failed");
		}
		
	
	   
	}

}
