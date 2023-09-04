package com.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.utility.Screenshot;
import saucelab.tests.TestBase;

public class MyListener extends TestBase implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {	
		test = reports.createTest(result.getName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Testcase passes with name as "+result.getName());
		Screenshot.getScreenshot(result.getName());
	}
	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,"Testcase failed with name as "+result.getName());
		Screenshot.getScreenshot(result.getName());	
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,"Testcase skipped with name as "+result.getName());
		Screenshot.getScreenshot(result.getName());
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
	
	@Override
	public void onStart(ITestContext context) {
	     test = reports.createTest("Test context: " + context.getName());
	}
	@Override
	public void onFinish(ITestContext context) {
	}

}
