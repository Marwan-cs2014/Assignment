package com.facebook.automation.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class Browser {

	static WebDriver driver;

	/**
	 * 
	 * @return FireFox WebDriver
	 */
	public static WebDriver createInstance() {
		return createInstance(null);
	}

	/**
	 * 
	 * @param browserName
	 *            firefox, IE, Chrome, Safari, HTMLUnit or HTMLUnitJS
	 * 
	 * @return WebDriver
	 */
	public static WebDriver createInstance(String browserName) {
//		WebDriver driver;
		browserName = (browserName != null) ? browserName : "firefox";

		switch (Browsers.valueOf(browserName.toUpperCase())) {
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case IE:
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(caps);
			break;
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			break;
		// case HTMLUNIT:
		// driver = new HtmlUnitDriver();
		// break;
		// case HTMLUNITJS:
		// driver = new HtmlUnitDriver(true);
		// break;
		case SAFARI:
			driver = new SafariDriver();
			break;
		default:
			driver = new FirefoxDriver();
			break;
		}
		// maximize browser's window on start
		driver.manage().window().maximize();
		return driver;
	}

	private static enum Browsers {
		FIREFOX, CHROME, IE, HTMLUNIT, SAFARI, HTMLUNITJS;
	}
}