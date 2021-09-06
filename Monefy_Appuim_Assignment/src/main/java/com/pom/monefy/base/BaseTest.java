package com.pom.monefy.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pom.monefy.util.Constants;
import com.pom.monefy.util.ExtentManager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;



public class BaseTest {
	
	protected Properties prop;
	protected FileInputStream fs;
	protected AndroidDriver<AndroidElement> driver;
	protected ExtentTest test;
	protected ExtentReports extent;
	protected String testCaseName;
	protected String browser;
	protected String failuremsg;	
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		// Load properties file and start Extent Report
		
		testCaseName=this.getClass().getSimpleName();
		System.out.println(testCaseName);
		prop=new Properties();
		fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties");
		prop.load(fs);
		extent= ExtentManager.getInstance(System.getProperty("user.dir")+Constants.REPORT_PATH);
		test=extent.createTest(testCaseName);
		test.log(Status.INFO, "Starting test: "+testCaseName);
		System.out.println("Before Class executed");
	}
	
	@BeforeMethod
	public void beforeMethod(ITestContext context) throws MalformedURLException  {
		
		//Check if test is executable is yes, launch driver
		
		System.out.println("test case name is:"+testCaseName);
	      test.log(Status.INFO, "Launching Driver");
	      launchApp();
	
	      System.out.println("Before method executed");
	      
	      context.setAttribute("AppuimDriver", driver);
	      context.setAttribute("Test", test);
	}
	


	@AfterMethod
	public void afterMethod()  {
		
		//quit driver
		if (driver!=null)
			driver.quit();
		System.out.println("After method executed");
	}
	
	
	@AfterClass
	public void afterClass() {
		
		//Flush report
		if (extent!=null)
			extent.flush();
		
		System.out.println("After Class executed");
	
	}

/*************Methods**************************/
	
	public AppiumDriverLocalService getAppiumService() {
		return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Users\\jaspreetchagger\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.usingPort(4723)
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.withLogFile(new File("ServerLogs/server.log")));
	}
	
	//LaunchDriver
	public void launchApp() throws MalformedURLException {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.UDID, prop.getProperty("UDID"));
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("platformName"));
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("platformVersion"));
		cap.setCapability(MobileCapabilityType.NO_RESET, prop.getProperty("noReset"));
		cap.setCapability(MobileCapabilityType.FULL_RESET, prop.getProperty("fullReset"));
		cap.setCapability("app", System.getProperty("user.dir")+"//apk//"+prop.getProperty("apkFileName"));
		cap.setCapability("appPackage",prop.getProperty("appPackage"));
		cap.setCapability("appActivity",prop.getProperty("appActivity"));
		
		try {
			
	driver=new AndroidDriver<AndroidElement>(new URL(prop.getProperty("hubURL")),cap);
	
		} catch(Exception e){
			e.printStackTrace();
			test.log(Status.FAIL, "Driver failed to start");			
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	}
	
	
}
	
	


