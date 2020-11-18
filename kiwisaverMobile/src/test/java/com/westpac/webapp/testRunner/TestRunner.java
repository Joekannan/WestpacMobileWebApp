package com.westpac.webapp.testRunner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import static com.westpac.webapp.testRunner.AppiumServerController.startAppiumServer;
import static com.westpac.webapp.testRunner.AppiumServerController.stopAppiumServer;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/", glue="com.westpac.webapp.MobilestepDef")
public class TestRunner {
	
	@BeforeClass
	public static void startAppium() {
		startAppiumServer();
	}
	@AfterClass
	public static void stopAppium() {
		stopAppiumServer();
	}

	
}
