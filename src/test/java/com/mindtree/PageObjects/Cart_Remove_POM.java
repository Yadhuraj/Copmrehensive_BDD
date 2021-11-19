package com.mindtree.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.ResuableComponents.DriverFunctions;
import com.mindtree.UIStore.Cart_checkout_UI;
import com.mindtree.Util.ExtentUtility;
import com.mindtree.Util.Log;
import com.relevantcodes.extentreports.ExtentTest;

public class Cart_Remove_POM extends Cart_checkout_UI{
	
	public Cart_Remove_POM(WebDriver driver,Logger logger, ExtentTest test) throws InterruptedException {
		try {
			Thread.sleep(3000);
			DriverFunctions.click(driver, cart);
			Thread.sleep(8000);
			DriverFunctions.click(driver, remove);
			Log.testLoggerInfo(logger, "Removed the item As Expected");
			ExtentUtility.pass(test, driver, "Removed the item As Expected");
		}
		catch (Exception e) {
			Log.testLoggerInfo(logger, "Did not remove As Expected");
			ExtentUtility.pass(test, driver, "Did not remove As Expected");
		}
		Thread.sleep(5000);
		DriverFunctions.click(driver, cart_close);
		
//		driver.navigate().back();
		DriverFunctions.click(driver, home);
	}

	}


