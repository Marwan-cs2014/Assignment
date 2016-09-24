package com.facebook.automation.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * An example of using TestNG when the test class does not inherit from
 * AbstractTestNGCucumberTests.
 */
@RunWith(Cucumber.class)
@CucumberOptions(glue = { "com.facebook.automation.steps",
		"com.facebook.automation.runner"},tags = {"@FacebookLogin"}, features = "src/test/features", strict = true ,
		plugin = {"html:target/cucumber-html-report","junit:target/cucumber-junit.xml","json:target/cucumber.json","pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json"})

public class RunCukesByCompositionTest {
	
}
