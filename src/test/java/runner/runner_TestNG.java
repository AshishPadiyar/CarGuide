package runner;

// This is a runner class using TestNG



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features/SearchCars.feature",
glue="stepDefinations",
tags="@Searchcars",
monochrome = true,


/*plugin = {
		"html:target/cucumber-html-report", "json:target/cucumber-reports/cucumber.json",
		"junit:target/cucumber-reports/cucumber.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}*/

plugin = { 
"pretty", "html:target/HtmlReports/index.html",
"json:target/JsonReports/cucumber.json",
"junit:target/JunitReports/cucumber.xml"})



public class runner_TestNG  extends AbstractTestNGCucumberTests{
	

}
