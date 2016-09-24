package com.facebook.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	private static final int ELEMENT_WAIT_PERIOD_SECS = 30;
	protected WebDriver driver;
	private WebDriverWait _wait;

	public PageBase(WebDriver driver){
		this.driver = driver;
		_wait = new WebDriverWait(driver, ELEMENT_WAIT_PERIOD_SECS);
		PageFactory.initElements(this.driver, this);
	}

	/**
	 *
	 * @param element
	 *			Web Element
	 *
	 * @param Value
	 * 			String value
     */
	public void sendKeyCharByChar(WebElement element, String Value) {
		for (int i = 0; i <Value.length(); i++) {
			element.sendKeys(String.valueOf(Value.charAt(i)));
		}
	}

	/**
	 * 
	 * @param element
	 *            Maximum wait = 30 seconds
	 * 
	 * @return wait.until(ExpectedConditions.visibilityOf(element));
	 */
	public WebElement waitElement(WebElement element) {
		return _wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * 
	 * @param element
	 * 			Web Element
	 * 
	 * @param seconds
	 * 			Maximum wait for visibility of web element
	 * 
	 * @return
	 */
	public WebElement waitElement(WebElement element, int seconds ){
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * 
	 * Refresh the current page
	 * 
	 */
	public void refresh() {
		driver.navigate().refresh();
	}

	/**
	 * 
	 * Close the driver
	 * 
	 */
	public void CloseDriver() {
		driver.quit();
	}
}
