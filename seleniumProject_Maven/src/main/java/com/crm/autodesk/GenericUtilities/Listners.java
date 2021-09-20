package com.crm.autodesk.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Listners implements ITestListener {

	ExtentReports reports; // attach the reporter
	ExtentTest test; // to make entries of test cases and logs

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = reports.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, result.getMethod().getMethodName() + "is passed");

	}

	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, result.getName() + "is Failed");
		BaseClass baseClass = new BaseClass();

		try {
			String path = baseClass.getScreenShot(result.getName());
			test.addScreenCaptureFromPath(path);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, result.getMethod().getMethodName() + "is Skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/ExtentReportsSDET21/ExtentReports.html");
		reporter.config().setDocumentTitle("SDET21");
		reports = new ExtentReports();
		reports.attachReporter(reporter);

		reports.setSystemInfo("BuildNo", "5.1");
		reports.setSystemInfo("Env", "Pre-Prod");
		reports.setSystemInfo("Platform", "Windows");
		reports.setSystemInfo("Browser Version", "Chrome-93");

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		reports.flush();

	}

}
