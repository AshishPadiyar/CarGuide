package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigUtils;
import utilities.DriverUtils;

import java.io.IOException;

public class Hooks {
    public static String TestName = null;

    @Before()
    public static void BeforeSteps(Scenario scenario) throws IOException {
        ConfigUtils.beforeTest();
        System.out.println("TestCase Execution started");
        TestName = scenario.getName();
        DriverUtils.createWordDoc(TestName);
        DriverUtils.setUp();
    }

    @After()
    public static void afterSteps(Scenario s) {

        DriverUtils.driver.close();
        System.out.println("Test case execution has been completed");
    }
}

//hooks can only be added to step definitions package , as it has to run before or after each scenario
//we can specify to which scenario or feature file we need these hooks by tagging hooks to feature or scenario