package com.pom.monefy.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pom.monefy.base.BaseTest;
import com.pom.monefy.pages.HomePage;
import com.pom.monefy.pages.IncomePage;
import junit.framework.Assert;

public class IncomePageTest extends BaseTest {

	HomePage homepage;
	IncomePage incomepage;

	@BeforeMethod
	public void beforeMethod() {
		homepage = new HomePage(driver, test);
		incomepage = homepage.clickIncomeButton();
	}

	@Test(testName = "New Income Page Verification", priority = 1 , description = "Verify that income page should be opened correctly")
	public void verifyNewIncome() throws Exception {
		Assert.assertEquals(true, incomepage.newIncomeIsDisplayed());

	}

	@Test(testName = "Submission of zero income", priority = 0 ,description = "Verify that if income amount is 0 then user should not be able to add income")
	public void verifyIncomeShoulsNotBeAccepted() throws Exception {
		incomepage.clickOnChooseCategory();
		Assert.assertEquals(true, incomepage.newIncomeIsDisplayed());

	}

}
