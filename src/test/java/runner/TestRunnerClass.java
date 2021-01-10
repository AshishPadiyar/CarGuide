package runner;


import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;

// This is a runner class using Junit


import org.junit.runner.RunWith;

//import com.vimalselvam.cucumber.listener.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utilities.ConfigUtils;
import utilities.DriverUtils;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
glue="stepDefinations",
tags="@HomePageTabs",
plugin = { 
"pretty", "html:target/HtmlReports/index.html",
"json:target/JsonReports/cucumber.json",
"junit:target/JunitReports/cucumber.xml",
},
monochrome = true
		
		)

//"com.cucumber.listener.ExTentCucumberFormatter:target/cucumber-reports/report.html"

public class TestRunnerClass {
	
	@BeforeClass
	public static void before() throws IOException 
	{
		ConfigUtils.beforeTest();
	}
	
	@AfterClass
	public static void writeReport() throws IOException 
	{
		ConfigUtils.log.info("<log end>");
		ConfigUtils.log.info("Log end time is "+DriverUtils.dateTime());
		//Reporter.loadXMLConfig(new File("extent-config.xml"));
	}

}
