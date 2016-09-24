package com.facebook.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "email")
	private WebElement username;
	private WebElement getEmailField(){
		return username;
	}

	@FindBy(id = "pass")
	private WebElement password;
	private WebElement getPasswordField(){
		return password;
	}

	@FindBy(css = "#loginbutton > input")
	private WebElement login;
	private WebElement getLoginButton(){
		return login;
	}

	/**
	 * Navigate to Facebook page
	 *
	 * @return LoginPage object
	 */
	public LoginPage NavigateToLoginPage() {
		String url = "https://www.facebook.com/";
		driver.navigate().to(url);
		return new LoginPage(driver);
	}

	/**
	 * Login to Facebook.com
	 * 
	 * @return HomePage object
	 */
	public HomePage Login(String email, String pass){
		sendKeyCharByChar(waitElement(getEmailField()), email);
		sendKeyCharByChar(getPasswordField(), pass);
		getLoginButton().click();
		return new HomePage(driver);
	}

}
