package runner;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

// This is a runner class using TestNG



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ConfigUtils;
import utilities.DriverUtils;

@CucumberOptions(features="src/test/resources/features",
glue="stepDefinations",
monochrome = true,
//tags="@HomePageTabs",
plugin = {
		"html:target/cucumber-html-report", "json:target/cucumber-reports/cucumber.json",
		"junit:target/cucumber-reports/cucumber.xml","pretty", "html:target/HtmlReports/index.html"})
		//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})



public class runner_TestNG  extends AbstractTestNGCucumberTests{
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


