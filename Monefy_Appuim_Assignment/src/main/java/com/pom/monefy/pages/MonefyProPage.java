package com.pom.monefy.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pom.monefy.base.BasePage;
import com.pom.monefy.functions.GenericFunctions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MonefyProPage extends BasePage {
	
	
	public MonefyProPage(AndroidDriver<AndroidElement> driver,ExtentTest test)
	{
		super(driver,test);
	}

	
	@AndroidFindBy(id="com.monefy.app.lite:id/monefyProTitle")
	private AndroidElement proHeader;
	
	

	public boolean proHeaderIsDisplayed()
	{
		test.log(Status.INFO, "Checking if new income  is displayed");
		return GenericFunctions.isElementDisplayed(proHeader);
	}
	

	
}
