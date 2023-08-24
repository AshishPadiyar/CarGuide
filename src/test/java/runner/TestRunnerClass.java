package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utilities.ConfigUtils;
import utilities.DriverUtils;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
                 tags = "@HomePage",
        monochrome = true,
        glue = "stepDefinitions", stepNotifications = true,
        plugin = {
                "pretty", "json:target/cucumber-reports/cucumber.json"
//		"html:target/cucumber-reports/cucumber.html",
//"junit:target/JunitReports/cucumber.xml"
        }


)

public class TestRunnerClass {

    @BeforeClass
    public static void before() throws IOException {
        ConfigUtils.beforeTest();
    }

    @AfterClass
    public static void writeReport() {
        ConfigUtils.log.info("<log end>");
        ConfigUtils.log.info("Log end time is " + DriverUtils.dateTime());
    }

}
