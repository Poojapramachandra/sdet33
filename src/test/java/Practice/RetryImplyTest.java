package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryImplyTest {
	
	
	@Test(retryAnalyzer=GenericUtility.RetryAnalayzerImplementationClass.class)
	public void create(){
		System.out.println("retry");
		Assert.assertEquals(false, true);
	}
}
