package com.mindtree.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.ResuableComponents.BaseClass;
import com.mindtree.ResuableComponents.DriverFunctions;
import com.mindtree.UIStore.Login_UI;
import com.mindtree.Util.ExtentUtility;
import com.mindtree.Util.Log;
import com.mindtree.exception.PageObjectRException;
import com.relevantcodes.extentreports.ExtentTest;

public class Login_POM extends Login_UI{

	public Login_POM(WebDriver driver,Logger logger, ExtentTest test) throws InterruptedException {
		try {
			Thread.sleep(5000);
			DriverFunctions.click(driver, sign_in);
			Thread.sleep(5000);
			DriverFunctions.sendkeys(driver, email, BaseClass.rp.user());
			DriverFunctions.sendkeys(driver, password, BaseClass.rp.pass());
			Thread.sleep(5000);
			DriverFunctions.click(driver, submit );
			Thread.sleep(5000);
			System.out.println("1");
			if(driver.findElements(validate2).size()>0)
			{
				System.out.println("if1");
				Log.testLoggerInfo(logger, "Login successful");
				ExtentUtility.pass(test,driver, "Login successful");
			}
			else
				if(driver.findElements(validate).size()>0)
			{
				System.out.println("if2");
				Log.testLoggerInfo(logger, "Login successful");
				ExtentUtility.pass(test,driver, "Login successful");
			}
			else {
				System.out.println("else");
				DriverFunctions.click(driver, home);
				throw new PageObjectRException("Login interrupted");
			}
		}
		catch (PageObjectRException e) {
			System.out.println("catch");
			Log.testLoggerError(logger, e.toString());
			ExtentUtility.fail(test, driver, e.toString());
		}
		Thread.sleep(3000);
		DriverFunctions.click(driver, home);
	}
}
