package com.facebook.automation.runner;

import java.io.IOException;

import com.facebook.automation.common.PageFactory;
import com.facebook.automation.common.util.StateHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void beforeScenario() {
        System.out.println("custom Before scenario hook");
        PageFactory.instance().deleteAllDriverCookies();
    }

    @After
    public void tearDown(Scenario scenario) {
    	System.out.println("custom After scenario hook");
    	try {
			StateHelper.clearStepState();
		} catch (IOException e) {
			System.err.println("ERROR");
		}
    	PageFactory.instance().deleteAllDriverCookies();
        if (scenario.isFailed()) {
        	final byte[] screenshot  = ((TakesScreenshot) PageFactory.instance().getWebDriver())
                    .getScreenshotAs(OutputType.BYTES);        
            scenario.embed(screenshot , "image/png"); //stick it in the report
        }
    }

//    @After
//    public void endScenario(Scenario scenario) {
//	System.out.println("***** After hook from Hooks.java *****");
//	((RemoteWebDriver) PageFactory.instance().getWebDriver()).executeScript("/***  "
//		+ " Executing Scenario : " + scenario.getName()
//		+ " 			 Status: " + scenario.getStatus() + "   ***/");
//	    
//	TestContext tc = TestContextManager.getTestContext();
//	try {
//
//	    if (PropertiesManager.getCucumberEmbedScreenshots().equalsIgnoreCase("always")
//		    || (scenario.isFailed() && PropertiesManager.getCucumberEmbedScreenshots().equalsIgnoreCase("failed"))) {
//		if (tc.getExecLoc().equalsIgnoreCase("BrowserStack")) {
//		    System.out.println("Executing on browser stack...");
//		    this.embedBSImagePaths(scenario);
//		}else {
//			this.embedBSImagePaths(scenario);
//		}
//	    } else if (PropertiesManager.getCucumberEmbedScreenshots()
//		    .equalsIgnoreCase("never")) {
//		System.out.println("Embed screenshots to cucumber report: "
//			+ PropertiesManager.getCucumberEmbedScreenshots());
//	    } else if (!scenario.isFailed()
//		    && PropertiesManager.getCucumberEmbedScreenshots()
//			    .equalsIgnoreCase("failed")) {
//		System.out.println("Embed screenshots to cucumber report: "
//			+ PropertiesManager.getCucumberEmbedScreenshots()
//			+ " and scenario passed.");
//	    }
//	} catch (Exception e) {
//	    System.err
//		    .println("***** The following exception is thrown beacuse of not using Browser Stack or missing CucumberEmbedScreenshots properties. *****");
//	    e.printStackTrace();
//	}
//
//    }
//
//    private void embedBSImagePaths(Scenario scenario) {
//	try {
//	    ArrayList<String> imagesPath = RestAPI.getSessionLog(scenario
//		    .getName());
//
//	    // Following would be called for any type of execution location
//	    this.embedImagePaths(scenario, imagesPath);
//
//	} catch (Exception e) {
//	    e.printStackTrace();
//	}
//    }
//
//    private void embedImagePaths(Scenario scenario, ArrayList<String> imagesPath) {
//	// if (scenario.isFailed()) {
//	for (String imagePath : imagesPath) {
//	    String log = "<img style='width: 50%; height: 50%' src='"
//		    + imagePath + "'/><BR>";
//
//	    scenario.write(log);
//	}
//	// }
//    }

//    private void embedScreenshot(Scenario scenario, String log) {
//	// if (scenario.isFailed()) {
//	// byte[] screenshot = ((RemoteWebDriver) driver)
//	// .getScreenshotAs(OutputType.BYTES);
//	// scenario.embed(screenshot, "image/png");
//	byte[] logs = log.getBytes();
//	// scenario.embed(logs, "text/plain");
//	scenario.write(log);
//	// }
//    }
//
//    // TODO: This is hook not available and it is under development on
//    // cucumber-jvm project. We will work on this once this hook is released
//    // (Dt.
//    // 4/29/2015)
//    /*
//     * @AfterStep public void embedScreenshot(Scenario scenario) {
//     * if(scenario.isFailed()) { byte[] screenshot =
//     * ((RemoteWebDriver)driver).getScreenshotAs(OutputType.BYTES);
//     * scenario.embed(screenshot, "image/png"); } }
//     */
}