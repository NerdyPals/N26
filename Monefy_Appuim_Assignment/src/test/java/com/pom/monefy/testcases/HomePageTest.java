package com.pom.monefy.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pom.monefy.base.BaseTest;
import com.pom.monefy.pages.HomePage;
import com.pom.monefy.util.Constants;
import junit.framework.Assert;

public class HomePageTest extends BaseTest {

	HomePage homepage;

	@BeforeMethod
	public void beforeMethod() {
		homepage = new HomePage(driver, test);
	}

	@Test(testName = "App Header Verification", priority = 0 ,description = "Verifying the application Header Name")
	public void verifyAppHeader() throws Exception {
		String actualText = homepage.getTextOfHeader();
		Assert.assertEquals(actualText, Constants.MONEFY_APP_TITLE);

	}

	@Test(testName = "Income Button Verification", priority = 1 , description = "Verify that income button should be present")
	public void verifyIncomeButton() throws Exception {
		Assert.assertEquals(true, homepage.incomeButtonIsDisplayed());

	}

	@Test(testName = "Expense Button Verification", priority = 2 ,description = "Verify that Expense button should be present")
	public void verifyExpenseButton() throws Exception {
		Assert.assertEquals(true, homepage.expenseButtonIsDisplayed());

	}

	@Test(testName = "Right settings menu verification", priority = 3 ,description = "Verify that right menu should be opened")
	public void verifyRightSettingsMenu() throws Exception {
		homepage.clickOnRightSettingsButton();
		Assert.assertEquals(true, homepage.categoriesPanelIsDisplayed());
	}

	@Test(testName = "Left settings menu verification", priority = 4 ,description = "Verify that Left menu should be opened")
	public void verifyLeftSettingsMenu() throws Exception {
		homepage.clickOnLeftSettingsButton();
		Assert.assertEquals(true, homepage.datePanelIsDisplayed());
	}

	@Test(testName = "Monefy pro page verification", priority = 5 , description = "Verify that pro page should be opened")
	public void verifyProPage() throws Exception {
		homepage.clickOnRightSettingsButton();
		homepage.clickOnCategoriesPanel();
		homepage.clickOnPlusButton();
		Assert.assertEquals(Constants.PRO_PAGE_TITLE,homepage.getTextOfproHeader());
	}

}
