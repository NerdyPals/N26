package com.pom.monefy.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pom.monefy.base.BasePage;
import com.pom.monefy.functions.GenericFunctions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class IncomePage extends BasePage {
	
	
	public IncomePage(AndroidDriver<AndroidElement> driver,ExtentTest test)
	{
		super(driver,test);
	}

	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='New income']")
	private AndroidElement newIncome;
	

	@AndroidFindBy(id="com.monefy.app.lite:id/keyboard_action_button")
	private AndroidElement chooseCategory;
	

	public boolean newIncomeIsDisplayed()
	{
		test.log(Status.INFO, "Checking if new income  is displayed");
		return GenericFunctions.isElementDisplayed(newIncome);
	}
	
	public void clickOnChooseCategory()
	{
		test.log(Status.INFO, "Clicking on Choose Category");
		 GenericFunctions.clickElement(driver, chooseCategory);
	}
	

	
}
