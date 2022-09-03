package commonTest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import utilities.ConfigUtil;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	int count = 0;

	@Override
	public boolean retry(ITestResult result) {
		if (count<ConfigUtil.retryCount) {
			count++;
			return true;
		}
		return false;
	}

}
