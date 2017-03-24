package com.cucumber.runner;

import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/"}, glue = {"com.cucumber.stepdefinitions"},
                    plugin = {"com.cucumber.listener.ExtentCucumberFormatter"},tags = {"@Abhi,@inValidLogin,@newCustomer"})
public class RunCukesTest {

	public static WebDriver DriverObj;
    @BeforeClass
    public static void setup() {
        ExtentCucumberFormatter.initiateExtentCucumberFormatter();
        ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));

        ExtentCucumberFormatter.addSystemInfo("Browser Name", "Firefox");
        ExtentCucumberFormatter.addSystemInfo("Browser version", "v28.0");
        ExtentCucumberFormatter.addSystemInfo("Selenium version", "v2.53.0");

        Map systemInfo = new HashMap();
        systemInfo.put("Cucumber version", "v1.2.3");
        systemInfo.put("Extent Cucumber Reporter version", "v1.1.0");
        ExtentCucumberFormatter.addSystemInfo(systemInfo);
    }

}
