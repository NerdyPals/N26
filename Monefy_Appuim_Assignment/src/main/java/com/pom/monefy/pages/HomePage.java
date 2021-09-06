package com.pom.monefy.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pom.monefy.base.BasePage;
import com.pom.monefy.functions.GenericFunctions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {
	
	
	public HomePage(AndroidDriver<AndroidElement> driver,ExtentTest test)
	{
		super(driver,test);
	}
	
	@AndroidFindBy(id="com.monefy.app.lite:id/income_button")
	private AndroidElement incomeButton;
	
	@AndroidFindBy(id="com.monefy.app.lite:id/overflow")
	private AndroidElement settingsButton;

	@AndroidFindBy(id="com.monefy.app.lite:id/expense_button")
	private AndroidElement expenseButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Monefy']")
	private AndroidElement appHeader;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@index='1']")
	private AndroidElement eating;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@index='2']")
	private AndroidElement house;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@index='3']")
	private AndroidElement food;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@index='13']")
	private AndroidElement car;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@index='15']")
	private AndroidElement toiletry;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@index='21']")
	private AndroidElement sport;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@index='20']")
	private AndroidElement health;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@index='19']")
	private AndroidElement communication;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@index='18']")
	private AndroidElement entertainment;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@index='10']")
	private AndroidElement clothes;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@index='8']")
	private AndroidElement taxi;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@index='0']")
	private AndroidElement transport;
	
	@AndroidFindBy(id="com.monefy.app.lite:id/categories_panel")
	private AndroidElement categoriesPanel;
	
	@AndroidFindBy(id="com.monefy.app.lite:id/transfer_menu_item")
	private AndroidElement newTransfer;
	
	@AndroidFindBy(id="com.monefy.app.lite:id/expense_amount_text")
	private AndroidElement foodExpenseAmount;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Open navigation']")
	private AndroidElement LeftMenu;
	
	@AndroidFindBy(id="com.monefy.app.lite:id/fragment_date_settings")
	private AndroidElement datePanel;
	
	@AndroidFindBy(id="com.monefy.app.lite:id/imageButtonAddCategory")
	private AndroidElement plusButton;
	
	@AndroidFindBy(id="com.monefy.app.lite:id/monefyProTitle")
	private AndroidElement proHeader;
	
	
	public IncomePage clickIncomeButton()
	{
		test.log(Status.INFO, "Clicking on Income Button");
		GenericFunctions.clickElement(driver, incomeButton);
		IncomePage incomepage=new IncomePage(driver,test);
		return incomepage;
	}
	
	public ExpensePage clickExpenseButton()
	{
		test.log(Status.INFO, "Clicking on Expense Button");
		GenericFunctions.clickElement(driver, expenseButton);
		ExpensePage expensepage=new ExpensePage(driver,test);
		return expensepage;
	}
	

	public ExpensePage clickOnFoodButton()
	{
		test.log(Status.INFO, "Clicking on Food Button");
		GenericFunctions.clickElement(driver, food);
		ExpensePage expensepage=new ExpensePage(driver,test);
		return expensepage;
	}
	
	public void clickOnLeftSettingsButton()
	{
		test.log(Status.INFO, "Clicking on Left setting Button");
		GenericFunctions.clickElement(driver, LeftMenu);
	}
	
	public void clickOnRightSettingsButton()
	{
		test.log(Status.INFO, "Clicking on right setting Button");
		GenericFunctions.clickElement(driver, settingsButton);
	}
	
	
	public String getTextOfHeader()
	{
		test.log(Status.INFO, "Getting text of Header");
		return GenericFunctions.getText(driver, appHeader);
	}
	
	public boolean incomeButtonIsDisplayed()
	{
		test.log(Status.INFO, "Checking if income buttton is displayed");
		return GenericFunctions.isElementDisplayed(incomeButton);
	}
	
	public String getTextOfproHeader()
	{
		test.log(Status.INFO, "Checking if pro page is displayed");
		return GenericFunctions.getText(driver,proHeader);
	}

	public boolean expenseButtonIsDisplayed()
	{
		test.log(Status.INFO, "Checking if expense buttton is displayed");
		return GenericFunctions.isElementDisplayed(expenseButton);
	}
	
	public boolean categoriesPanelIsDisplayed()
	{
		test.log(Status.INFO, "Checking if categories pannel is displayed");
		return GenericFunctions.isElementDisplayed(categoriesPanel);
	}
	
	public void clickOnCategoriesPanel()
	{
		test.log(Status.INFO, "clicking on categories pannel");
		 GenericFunctions.clickElement(driver,categoriesPanel);
	}
	
	public void clickOnPlusButton()
	{
		test.log(Status.INFO, "clicking on + button");
		 GenericFunctions.clickElement(driver,plusButton);
	}
	
	public boolean datePanelIsDisplayed()
	{
		test.log(Status.INFO, "Checking if date pannel is displayed");
		return GenericFunctions.isElementDisplayed(datePanel);
	}
		
	public NewTransferPage clickOnNewTransferButton()
	{
		test.log(Status.INFO, "Clicking on  new transfer Button");
		GenericFunctions.clickElement(driver, newTransfer);
		NewTransferPage newtransferpage = new NewTransferPage(driver,test);
		return newtransferpage;
	}
	
	public String getFoodExpenseAmount()
	{
		return GenericFunctions.getText(driver,foodExpenseAmount);
	}
	
}
