package com.mindtree.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.ResuableComponents.DriverFunctions;
import com.mindtree.UIStore.Wishlist_UI;
import com.mindtree.Util.ExtentUtility;
import com.mindtree.Util.Log;
import com.relevantcodes.extentreports.ExtentTest;

public class Wishlist_POM extends Wishlist_UI{
	public Wishlist_POM(WebDriver driver,Logger logger, ExtentTest test) throws InterruptedException {
		
		DriverFunctions.click(driver, wishlist);
		Thread.sleep(5000);
		if(driver.findElement(button).isDisplayed())
		{	DriverFunctions.click(driver, button);
		
			Log.testLoggerInfo(logger, "Navigated as expected");
			ExtentUtility.pass(test, driver, "Navigated as expected");
		}
		else
		{
			Log.testLoggerError(logger, "Did not navigate as expected");
			ExtentUtility.fail(test, driver, "Did not navigate as expected");
		}
		Thread.sleep(5000);
		DriverFunctions.click(driver, home);
		
		
	}
}
