package GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * 
 * @author POOJA P R
 *
 */
public class ListenersImplementaionClass implements ITestListener {

	
	
    public void onStart(ITestContext context) {
		
		System.out.println("Execution Started");
		
	}
	public void onFinish(ITestContext context) {
	
		System.out.println("Execution Finish");
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	
	
    public void onTestStart(ITestResult result) {
		
    	String methodName = result.getMethod().getMethodName();
    	System.out.println(methodName+"---------->Start");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
    	System.out.println(methodName+"---------->Executed Succesfully");
	}
	

	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-----Failed");
		System.out.println(result.getThrowable());
		
		
		try {
		String path = new WebDriverUtility().takeScreenshort(BaseClass.sDriver, methodName);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--------->Execution Skipped");
		System.out.println(result.getThrowable());

		
	}

	

	
	
	
	

}
