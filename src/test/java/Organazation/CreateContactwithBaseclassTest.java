package Organazation;

import org.testng.annotations.Test;

import com.crm.autodesk.seleniumframework.ObjectRepository.ContactInformation;
import com.crm.autodesk.seleniumframework.ObjectRepository.CreatOrganationWith;
import com.crm.autodesk.seleniumframework.ObjectRepository.CreateContact;
import com.crm.autodesk.seleniumframework.ObjectRepository.CreateNewContact;
import com.crm.autodesk.seleniumframework.ObjectRepository.HomePage;

import GenericUtility.BaseClass;

public class CreateContactwithBaseclassTest extends BaseClass{

	@Test
	public void  createContact() throws Throwable{
		String lastname = elib.getDataFromExcel("sheet2", 1, 1)+jlib.getRandomNumber();
	
		
		HomePage home= new HomePage(driver);
		home.Contact();
		
		CreateContact con= new CreateContact(driver);
		con.AddIcon();
		
		CreateNewContact contact= new CreateNewContact(driver);
		contact.lastnameTextField(lastname);
		
		ContactInformation info= new ContactInformation(driver);
		String Actualresult = info.ContactInformationLink();
		
		if (Actualresult.contains(lastname)) {
			System.out.println("Contact Created sucessfully====>pass");
		} else {
			System.out.println("Contact not created ======>failed");
		}
		
		
	}
	
	
	
}
