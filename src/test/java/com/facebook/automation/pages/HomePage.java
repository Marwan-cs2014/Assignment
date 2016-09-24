package com.facebook.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.facebook.automation.runner.Assert;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(className = "_1tp8")
	private WebElement validation1;
	private WebElement getValidation1(){
		return validation1;
	}

	@FindBy(className = "_4rbf")
	private WebElement validation2;
	private WebElement getValidation2(){
		return validation2;
	}

	/**
	 * Assert the page title
	 * 
	 * @return HomePage object
	 */
	public HomePage PageAssert(){
		Assert.softAssert.assertEquals(driver.getTitle(), "Facebook", "Wrong Fat Value : expected <" + "Facebook" + "> but was <" + driver.getTitle() + ">");
		return new HomePage(driver);
	}

	/**
	 * 
	 * @param validation
	 * 			String validation message that should be displayed
	 * 
	 * @return HomePage object
	 */
	public HomePage AssertValidationMessages(String validation){
		if (!validation.equalsIgnoreCase("no")) {
			try {
				Assert.softAssert.assertEquals(waitElement(getValidation1(), 2).getText(), validation, "Wrong Fat Value : expected <" + validation + "> but was <" + getValidation1().getText() + ">");
			} catch (Exception e) {
				try {
					Assert.softAssert.assertEquals(waitElement(getValidation2(), 2).getText(), validation, "Wrong Fat Value : expected <" + validation + "> but was <" + getValidation2().getText() + ">");
				} catch (Exception e2) {
					
				}
			}
		}
		return new HomePage(driver);
	}
}
