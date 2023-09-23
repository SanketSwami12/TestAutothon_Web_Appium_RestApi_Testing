package com.utility;

import org.openqa.selenium.TimeoutException;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class CustomRetryAnalyzer implements IRetryAnalyzer{ 
	private int retryCount = 0;
private static final int maxRetryCount = 3;

	@Override
	public boolean retry(ITestResult result) {
	    if (retryCount < maxRetryCount) {
	        if (result.getThrowable() instanceof TimeoutException) {
	            retryCount++;
	            return true; 
	        }
	    }
	    return false; 
	}
	

}
