package GenericUtility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/*
 * 
 *@author POOJA P R 
 * 
 */

public class FileUtility
{

	/**
	 * 
	 * its used to read the data from the commonData properties File based on Key which you pass an on aruguments
	 * @param key
	 * @throws Throwable 
	 * 
	 */
      public String getPropertyKeyValue(String key) throws Throwable{
    	  FileInputStream fs= new FileInputStream("./src/test/resources/testdata/Credentails.properties");
    	  Properties pobj=new Properties();
    	  pobj.load(fs);
    	  String value= pobj.getProperty(key);
		  return value;
    	  
      }
		



}
