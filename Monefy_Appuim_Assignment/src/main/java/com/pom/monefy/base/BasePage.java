package com.pom.monefy.base;


import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class BasePage {
	
	protected  AndroidDriver<AndroidElement> driver;
	protected  ExtentTest test;
	
	public BasePage(AndroidDriver<AndroidElement> driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

}
