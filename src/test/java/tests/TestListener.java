package tests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ExtentManager;

public class TestListener implements ITestListener {

	ExtentReports extent = ExtentManager.getInstance();
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed Successfully");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Skipped");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}
	}
}












