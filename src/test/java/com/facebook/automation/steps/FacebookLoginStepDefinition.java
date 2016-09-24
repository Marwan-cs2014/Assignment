package com.facebook.automation.steps;

import org.openqa.selenium.WebDriver;

import com.facebook.automation.common.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FacebookLoginStepDefinition {

WebDriver driver = PageFactory.instance().getWebDriver();
	
	@Given("^Navigate to Facebook site$")
	public void NavigatetoFacebookSite() throws Throwable {
		PageFactory.instance().LoginPage().NavigateToLoginPage();
	}

	@When("^Login with valid username \"(.*?)\" and password \"(.*?)\"$")
	public void LogintoFacebook(String email, String pass) throws Throwable {
		PageFactory.instance().LoginPage().Login(email, pass);
	}

	@Then("^Will redirect to the user home page$")
	public void HomepageAssert() throws Throwable {
		PageFactory.instance().HomePage().PageAssert();
	}

	@When("^User try to login with (.*?) username and (.*?) password$")
	public void LoginToFacebook(String email, String pass) throws Throwable {
		LogintoFacebook(email, pass);
	}

	@Then("^(.*?) Validation message should be displayed$")
	public void ValidationAssertion(String validation) throws Throwable {
		PageFactory.instance().HomePage().AssertValidationMessages(validation);
	}

}
