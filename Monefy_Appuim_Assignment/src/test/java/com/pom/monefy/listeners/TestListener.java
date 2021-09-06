package com.pom.monefy.listeners;



import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pom.monefy.util.ExtentManager;





public class TestListener  implements ITestListener {
	
	private WebDriver driver = null;
	private ExtentTest test=null;
	
	
	public void onTestFailure(ITestResult result) {
		
		ITestContext context = result.getTestContext();
		 driver = (WebDriver) context.getAttribute("AppuimDriver");
		 test =  (ExtentTest) context.getAttribute("Test");
		
		System.out.println("On failure executing");
		if(result.getThrowable() != null) {
			  StringWriter sw = new StringWriter();
			  PrintWriter pw = new PrintWriter(sw);
			  result.getThrowable().printStackTrace(pw);
			
					Date d = new Date();
					String fileName=d.toString().replace(":", "_").replace(" ", "_");
					TakesScreenshot scr=(TakesScreenshot)driver;
					File sourceFile=scr.getScreenshotAs(OutputType.FILE);
					String destfilePath=ExtentManager.screenshotFolderPath+"//"+fileName+".png";
					File destFile=new File(destfilePath);
					try {
						FileUtils.copyFile(sourceFile,destFile);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					try {
						test.log(Status.INFO,"screenshot"+test.addScreenCaptureFromPath(destfilePath));
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					test.log(Status.FAIL,"Test case "+result.getName()+" failed due to following: "+"\n\n"+sw.toString());
					System.out.println("On failure ended");
		}

	}

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ITestContext context = result.getTestContext();
		 test =  (ExtentTest) context.getAttribute("Test");
		 test.log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestContext context = result.getTestContext();
		 test =  (ExtentTest) context.getAttribute("Test");
		 test.log(Status.SKIP, "Test skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {	
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {	
	}

}
