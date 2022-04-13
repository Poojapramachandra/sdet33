package PracticeUsingPom;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class retryPractice {
	
	@Test(retryAnalyzer=GenericUtility.RetryAnalayzerImplementationClass.class)
	public void test(){
		Reporter.log("Hi", true);
		Assert.fail();
		Reporter.log("Hello",true);
	}

}
