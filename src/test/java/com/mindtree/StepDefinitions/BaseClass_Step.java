package com.mindtree.StepDefinitions;

import java.io.IOException;

import org.apache.log4j.Logger;
//import org.junit.runner.RunWith;
//import org.junit.runner.RunWith;

import com.mindtree.PageObjects.Cart_Remove_POM;
import com.mindtree.PageObjects.Cart_checkout_POM;
import com.mindtree.PageObjects.Footer_POM;
import com.mindtree.PageObjects.Latest_POM;
import com.mindtree.PageObjects.Login_Forgot_POM;
import com.mindtree.PageObjects.Login_Invalid_POM;
import com.mindtree.PageObjects.Login_POM;
import com.mindtree.PageObjects.Search_header;
import com.mindtree.PageObjects.Shopping_Searcbar;
import com.mindtree.PageObjects.Wishlist_POM;
import com.mindtree.ResuableComponents.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

//@RunWith(Cucumber.class)
public class BaseClass_Step extends BaseClass {
	public static Logger logger;
	public static ExtentTest extentTest;
	
	@Given("The user lands on the expected url")
	public void the_user_lands_on_the_expected_url() {
		driver = DriverSetUp();
		System.out.println(date);
		
	}

	@When("the user Login is checked with valid data")
	public void the_user_login_is_checked_with_valid_data() throws InterruptedException {
		logger = Logger.getLogger("Login");
		extentTest= extent.startTest("Login");
		new Login_POM(driver,logger,extentTest);
		extent.flush();
		driver.close();
	}

	@Then("the user Login is checked with invalid data {string} and {string}")
	public void the_user_login_is_checked_with_invalid_data_and(String string, String string2) throws InterruptedException {
	    
		System.out.println(string);
		System.out.println(string2);
		driver = DriverSetUp();
		logger = Logger.getLogger("Invalid_Login");	
		extentTest= extent.startTest("Invalid_Login");
//		ExtentUtility.fail(extentTest, driver, "Invalid_Login");
		new Login_Invalid_POM(driver, logger, extentTest,string,string2);
//		System.out.println("here");
		extent.flush();
		driver.close();
		Thread.sleep(2000);
	}

	@Then("The forgot password functionality is checked")
	public void the_forgot_password_functionality_is_checked() throws InterruptedException {
		driver = DriverSetUp();
		extentTest= extent.startTest("Forgot_Password");
		logger = Logger.getLogger("Forgot_Login");	
		new Login_Forgot_POM(driver, logger, extentTest);
		System.out.println("here");
		extent.flush();
		
		
	}

	@Then("close the report")
	public void close_the_report() throws InterruptedException {
		driver.close();
		Thread.sleep(2000);
	}
	
	@Then("To buy Item using the search bar")
	public void to_buy_item_using_the_search_bar() throws InterruptedException, IOException {
		driver = DriverSetUp();
		extentTest= extent.startTest("SearchBar");
		logger = Logger.getLogger("SearchBar");
		new Shopping_Searcbar(driver, logger, extentTest);
		extent.flush();
		Thread.sleep(2000);
	    
	}

	@Then("To buy Item using the header dropdown")
	public void to_buy_item_using_the_header_dropdown() throws InterruptedException {
		extentTest= extent.startTest("Header");
		logger = Logger.getLogger("Header");
		new Search_header(driver, logger, extentTest);
		extent.flush();
		Thread.sleep(2000);
	}

	@Then("To buy from the Latest products")
	public void to_buy_from_the_latest_products() throws InterruptedException {
		extentTest= extent.startTest("Latest");
		logger = Logger.getLogger("Latest");
		new Latest_POM(driver, logger, extentTest);
		extent.flush();
		Thread.sleep(2000);
	}

	@Given("Checks the wishList")
	public void checks_the_wish_list() throws InterruptedException {
		extentTest= extent.startTest("Wishlist");
		logger = Logger.getLogger("Wishlist");
		new Wishlist_POM(driver, logger, extentTest);
		extent.flush();
	}

	@Then("Checkout from the cart")
	public void checkout_from_the_cart() throws InterruptedException {
		extentTest= extent.startTest("Cart_checkout");
		logger = Logger.getLogger("Cart_checkout");
		new Cart_checkout_POM(driver, logger, extentTest);
		extent.flush();
	}

	@Then("Remove from teh cart")
	public void remove_from_teh_cart() throws InterruptedException {
		extentTest= extent.startTest("Cart_remove");
		logger = Logger.getLogger("Cart_remove");
		new Cart_Remove_POM(driver, logger, extentTest);
		extent.flush();
	}

	@Then("Contact the owner for conveying a Message")
	public void contact_the_owner_for_conveying_a_message() throws InterruptedException {
		extentTest= extent.startTest("Footer_ContactUS");
		logger = Logger.getLogger("Footer_ContactUS");
		new Footer_POM(driver, logger, extentTest);
		extent.flush();
//		extent.close();
		driver.close();
	}



}