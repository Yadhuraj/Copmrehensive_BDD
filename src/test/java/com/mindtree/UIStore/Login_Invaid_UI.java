package com.mindtree.UIStore;

import org.openqa.selenium.By;

public class Login_Invaid_UI {
	public static By sign_in = By.xpath("//div[@class='site-nav__icons']//a[contains(@href ,'login')]");
	public static By email = By.cssSelector("[id = 'CustomerEmail']") ;
	public static By password = By.cssSelector("[id = 'CustomerPassword']") ;
	public static By submit = By.cssSelector("[value = 'Sign In']") ;
	public static By validate = By.cssSelector("div[class='errors']") ;
	public static By home = By.cssSelector("[class='h1 site-header__logo']") ;
	public static By validate2 = By.cssSelector("[value='Submit']") ;
}
