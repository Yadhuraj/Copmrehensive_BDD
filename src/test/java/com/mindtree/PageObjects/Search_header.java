package com.mindtree.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.mindtree.ResuableComponents.DriverFunctions;
import com.mindtree.UIStore.Search_header_UI;
import com.mindtree.Util.ExtentUtility;
import com.mindtree.Util.Log;
import com.mindtree.exception.PageObjectRException;
import com.relevantcodes.extentreports.ExtentTest;

public class Search_header extends Search_header_UI{
	public Search_header(WebDriver driver,Logger logger, ExtentTest test) throws InterruptedException {
		try {
			Actions action = new Actions(driver);

			//Performing the mouse hover action on the target element.
			action.moveToElement(driver.findElement(gifts)).perform();
			Thread.sleep(3000);
			DriverFunctions.click(driver, item);
			
			Thread.sleep(3000);
			DriverFunctions.click(driver, product);
			Thread.sleep(3000);
			DriverFunctions.click(driver, add_cart);
			Thread.sleep(9000);
			
			if (driver.findElements(cart_close).size()>0) 
			{
				DriverFunctions.click(driver,cart_close);
				Log.testLoggerInfo(logger, "Added successfully");
				ExtentUtility.pass(test, driver, "Added successfully");
			}
			else {
				DriverFunctions.click(driver, home);
				throw new PageObjectRException("Adding to cart interrupted");
				}
//			DriverFunctions.click(driver, cart_close);
			Thread.sleep(5000);
			
		}
		catch( PageObjectRException e)
		{
			Log.testLoggerError(logger, e.toString());
			ExtentUtility.fail(test, driver, e.toString());
		}
		catch (Exception e) {
			Log.testLoggerError(logger, e.getMessage());
			ExtentUtility.fail(test, driver, e.getMessage());
		}
		DriverFunctions.click(driver, home);
	}
}
