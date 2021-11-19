package com.mindtree.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.ResuableComponents.DriverFunctions;
import com.mindtree.UIStore.Cart_checkout_UI;
import com.mindtree.Util.ExtentUtility;
import com.mindtree.Util.Log;
import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.model.Log;

public class Cart_checkout_POM extends Cart_checkout_UI{
	public Cart_checkout_POM(WebDriver driver,Logger logger, ExtentTest test) throws InterruptedException {
		Thread.sleep(3000);
		DriverFunctions.click(driver, cart);
		Thread.sleep(8000);
		DriverFunctions.click(driver, checkout);
		if(driver.findElement(checkout).isDisplayed())
		{
			
			Log.testLoggerInfo(logger, "Navigated As Expected");
			ExtentUtility.pass(test, driver, "Navigated As Expected");
		}
		else
		{
			Log.testLoggerInfo(logger, "Did not navigate As Expected");
			ExtentUtility.pass(test, driver, "Did not navigate As Expected");
		}
		driver.navigate().back();
		DriverFunctions.click(driver, home);
	}

}
