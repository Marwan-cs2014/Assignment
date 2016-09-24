package com.facebook.automation.runner;

import java.io.IOException;

import org.testng.asserts.SoftAssert;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Assert{

	public static SoftAssert softAssert = new SoftAssert();
	@Before
	 public void beforeScenario() throws IOException, InterruptedException {
		softAssert = new SoftAssert();
		System.out.println("beforeScenario is called");
	 }
//	
//	@Override
//	public void executeAssert(IAssert a) {
//    try {
//        a.doAssert();
//    } catch (AssertionError ex) {
//        onAssertFailure(a, ex);
//        
//        m_errors.put(ex, a);
//    }
//    }
	 @After
	 public void afterScenario() throws IOException {
		 softAssert.assertAll();
		 System.out.println("afterScenario is called");

	 }
}
