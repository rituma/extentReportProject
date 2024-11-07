package CommonMethods;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	int count=1;
	int retrycount=0;
	@Override
	public  boolean retry(ITestResult arg0) {
		while(retrycount<count) {
			count++;
		}
		if(count==1)
			return true;
		else
			return false;
	}

}
