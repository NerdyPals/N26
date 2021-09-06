package com.pom.monefy.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pom.monefy.base.BaseTest;
import com.pom.monefy.pages.ExpensePage;
import com.pom.monefy.pages.HomePage;
import com.pom.monefy.util.Constants;
import junit.framework.Assert;

public class FoodExpenseTest extends BaseTest {

	HomePage homepage;
	ExpensePage expensepage;

	@BeforeMethod
	public void beforeMethod() {
		homepage = new HomePage(driver, test);
		expensepage = homepage.clickOnFoodButton();
	}


	
	@Test(testName = "Expense addition verification",priority = 0,description = "Verify that expense should be added and updated accordingly")
	public void verifyAddedExpense() throws Exception {
		
		expensepage.enterAmount();
		expensepage.clickonAddEatingout();
		String actualText=homepage.getTextOfHeader();
		Assert.assertEquals(actualText,Constants.MONEFY_APP_TITLE);

	}
	
	
	
	
}
