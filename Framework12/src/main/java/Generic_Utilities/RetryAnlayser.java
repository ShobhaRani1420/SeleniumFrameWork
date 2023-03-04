package Generic_Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnlayser implements IRetryAnalyzer{

	int count=0;
	int retrylimit=4;
	
	
	public boolean retry(ITestResult result) {
		
		if(count<retrylimit)
		{
			count++;
			return true;
		}
		return false;
	}
}
