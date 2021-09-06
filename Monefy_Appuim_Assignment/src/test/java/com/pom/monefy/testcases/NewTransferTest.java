package com.pom.monefy.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pom.monefy.base.BaseTest;
import com.pom.monefy.pages.HomePage;
import com.pom.monefy.pages.NewTransferPage;
import junit.framework.Assert;

public class NewTransferTest extends BaseTest {

	HomePage homepage;
	NewTransferPage newtransferpage;

	@BeforeMethod
	public void beforeMethod() {
		homepage = new HomePage(driver, test);
		newtransferpage = homepage.clickOnNewTransferButton();
	}

	@Test(testName = "New Income Page Verification", priority = 0 ,description = "Verify that income page should be opened correctly")
	public void verifyNewIncome() throws Exception {
		Assert.assertEquals(true, newtransferpage.newTransferIsDisplayed());

	}


}
