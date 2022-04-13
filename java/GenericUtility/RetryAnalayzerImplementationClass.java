package GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalayzerImplementationClass implements IRetryAnalyzer {

	
	int count=0;
	int recount=3;
	public boolean retry(ITestResult arg0) {
		if (count<recount) {
			count++;
			return true;
		}
		return false;
	}

}
