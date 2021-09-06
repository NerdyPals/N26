package com.pom.monefy.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pom.monefy.base.BaseTest;
import com.pom.monefy.pages.ExpensePage;
import com.pom.monefy.pages.HomePage;
import junit.framework.Assert;

public class ExpensePageTest extends BaseTest {

	HomePage homepage;
	ExpensePage expensepage;

	@BeforeMethod
	public void beforeMethod() {
		homepage = new HomePage(driver, test);
		expensepage = homepage.clickExpenseButton();
	}

	@Test(testName = "New Expense Page Verification", priority = 1,description = "Verify that expense page should be opened correctly")
	public void verifyExpenseButton() throws Exception {
		Assert.assertEquals(true, expensepage.newExpenseIsDisplayed());

	}

	@Test(testName = "Submission of zero expense", priority = 0,description = "Verify that if expense amount is 0 then user should not be able to add expense")
	public void verifyExpenseShouldNotBeAccepted() throws Exception {
		expensepage.clickOnChooseCategory();
		Assert.assertEquals(true, expensepage.newExpenseIsDisplayed());
	}

}
