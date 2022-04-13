package Practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test
	public void Assert(){
	String a="Duthi";
	String b="Duhi";
	//org.testng.Assert.assertEquals(a, b);
	
	SoftAssert sf = new SoftAssert();
	sf.assertEquals(a, b, a);
	//sf.assertAll();
	
}
}
