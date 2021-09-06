package com.pom.monefy.functions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.pom.monefy.base.BasePage;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GenericFunctions extends BasePage {
	

	public GenericFunctions(AndroidDriver<AndroidElement> driver, ExtentTest test) {
		super(driver, test);
	}

	
	public static void clickElement(AndroidDriver<AndroidElement> driver,AndroidElement ele)
	{
		WaitForElement(driver, ele);
		ele.click();
	}
	
	
	 public static void clear(AndroidDriver<AndroidElement> driver,AndroidElement ele) {
		 WaitForElement(driver, ele);
		  ele.clear();
	  }
	

	public static void sendKeys(AndroidDriver<AndroidElement> driver,AndroidElement ele,String entryText)
	{
		
		WaitForElement(driver, ele);
		ele.sendKeys(entryText);
	}
	
	
	 public static String getAttribute(AndroidDriver<AndroidElement> driver,AndroidElement ele, String attribute) {
		 WaitForElement(driver, ele);
		  return ele.getAttribute(attribute);
	  }
	
	
	
	public static Boolean WaitForElement(AndroidDriver<AndroidElement> driver,AndroidElement ele)
    {
        try
        {
        	WebDriverWait wait=new WebDriverWait(driver,20);
        	wait.until(ExpectedConditions.visibilityOf(ele));
            return true;
        }
        catch (NoSuchElementException e)
        {
        	e.printStackTrace();
            return false;
        }
    }
	
	
	public static Boolean isElementDisplayed(AndroidElement ele)
    {
		boolean presence=false;
		try {
		presence=ele.isDisplayed();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
        return presence;
    }
	
	public static String getText(AndroidDriver<AndroidElement> driver,AndroidElement ele)
	{
		WaitForElement(driver, ele);
		return ele.getText();
	}
	
	




	public static AndroidElement scrollToElementByText(AndroidDriver<AndroidElement> driver,String text) {
		
	AndroidElement ele=	driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).getChildByText("
+ "new UiSelector().className(\"android.widget.TextView\"), \""+text+"\")"));
		
	return ele;
		
	}
	
	
	public static AndroidElement findElementByText(AndroidDriver<AndroidElement> driver,String text)
	{
		AndroidElement ele=	driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='"+text+"\']"));
		return ele;
	}
	
	
	
}
