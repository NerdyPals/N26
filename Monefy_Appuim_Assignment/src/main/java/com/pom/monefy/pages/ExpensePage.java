package com.pom.monefy.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pom.monefy.base.BasePage;
import com.pom.monefy.functions.GenericFunctions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ExpensePage extends BasePage {
	
	
	public ExpensePage(AndroidDriver<AndroidElement> driver,ExtentTest test)
	{
		super(driver,test);
	}

	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='New expense']")
	private AndroidElement newExpense;
	
	@AndroidFindBy(id="com.monefy.app.lite:id/keyboard_action_button")
	private AndroidElement chooseCategory;
	
	@AndroidFindBy(id="com.monefy.app.lite:id/buttonKeyboard5")
	private AndroidElement amount;
	
	@AndroidFindBy(id="com.monefy.app.lite:id/keyboard_action_button")
	private AndroidElement addEatingOutButton;
	
	public boolean newExpenseIsDisplayed()
	{
		test.log(Status.INFO, "Checking if new Expense is displayed");
		return GenericFunctions.isElementDisplayed(newExpense);
	}
	
	public void clickOnChooseCategory()
	{
		test.log(Status.INFO, "Clicking on Choose Category");
		 GenericFunctions.clickElement(driver, chooseCategory);
	}
	
	public void enterAmount()
	{
		test.log(Status.INFO, "Entering the expense Amount");
		 GenericFunctions.clickElement(driver, amount);
	}
	
	public void clickonAddEatingout()
	{
		test.log(Status.INFO, "Submitting the expense");
		 GenericFunctions.clickElement(driver, addEatingOutButton);
	}
}
