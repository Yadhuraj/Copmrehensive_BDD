package com.mindtree.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.ResuableComponents.BaseClass;
import com.mindtree.ResuableComponents.DriverFunctions;
import com.mindtree.UIStore.Footer_UI;
import com.mindtree.Util.ExtentUtility;
import com.mindtree.Util.Log;
import com.relevantcodes.extentreports.ExtentTest;

public class Footer_POM extends Footer_UI {
	public Footer_POM(WebDriver driver,Logger logger, ExtentTest test) throws InterruptedException {
			Thread.sleep(3000);
			DriverFunctions.click(driver, contact);
			Thread.sleep(3000);
			DriverFunctions.sendkeys(driver, name, "XYZ");
			Thread.sleep(3000);
			DriverFunctions.sendkeys(driver, email, BaseClass.rp.user());
			Thread.sleep(3000);
			DriverFunctions.sendkeys(driver, msg, "THANK YOU!!!");
			Thread.sleep(3000);
			DriverFunctions.click(driver, submit);
			Thread.sleep(5000);
			if(driver.findElements(validate2).size()>0)
			{
				System.out.println("if1");
				Log.testLoggerInfo(logger, "Sucessful in reteiving password");
				ExtentUtility.pass(test,driver, "Sucessful in reteiving password");
			}
			else
			if(driver.findElements(validate).size()>0)
			{
				Log.testLoggerInfo(logger, "Sucessful in reteiving password");
				ExtentUtility.pass(test, driver, "Sucessful in reteiving password");
			}
			else
			{
				Log.testLoggerInfo(logger, "NOT Sucessful in reteiving password");
				ExtentUtility.pass(test, driver, "NOT Sucessful in reteiving password");
			}
			Thread.sleep(3000);
			DriverFunctions.click(driver, home);
	}
}
