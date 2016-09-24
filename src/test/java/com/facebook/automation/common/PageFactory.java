package com.facebook.automation.common;

import com.facebook.automation.pages.HomePage;
import com.facebook.automation.pages.LoginPage;

public class PageFactory extends PageFactoryAbstract {

	private static PageFactory _pageFactory;

	public PageFactory() {
		super();
	}

	private HomePage _homepage;
	private LoginPage _loginpage;

	public static PageFactory instance() {
		if (_pageFactory == null) {
			_pageFactory = new PageFactory();
		}
		return _pageFactory;
	}

	// pages object
	public HomePage HomePage() {
		if (_homepage == null) {
			_homepage = new HomePage(getWebDriver());
		}
		return _homepage;
	}

	public LoginPage LoginPage() {
		if (_loginpage == null) {
			_loginpage = new LoginPage(getWebDriver());
		}
		return _loginpage;
	}

}
