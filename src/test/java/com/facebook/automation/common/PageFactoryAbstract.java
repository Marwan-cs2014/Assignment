package com.facebook.automation.common;

import org.openqa.selenium.WebDriver;

public abstract class PageFactoryAbstract {

    public PageFactoryAbstract()
    {
        this.setWebDriver(Browser.createInstance());
    }
    
    private WebDriver _driver;

    public WebDriver getWebDriver() {
        return _driver;
    }
    public void setWebDriver(WebDriver driver) {
        this._driver = driver;
    }

    public void deleteAllDriverCookies()
    {
        getWebDriver().manage().deleteAllCookies();
    }

}
