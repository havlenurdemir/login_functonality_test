package com.login_functionality.step_definitions;

import com.login_functionality.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before(order=1)
    public void setupScenario(){
        System.out.println("====Setting up browser using cucumber @Before");
    }

    @Before(value ="@login", order=2)
    public void setupScenarioForLogins(){
        System.out.println("====this will apply to scenarios with @login");
    }

    @Before(value="@db",order=8)
    public void setupScenarioForDB(){
        System.out.println("====this will apply to scenarios with @db");
    }

    @After
    public void teardownScenario(Scenario scenario){

        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();

        //System.out.println("====Tearing down browser using cucumber @After");
        //System.out.println("====Scenario ended/ Take screenshot if failed!");
    }

    @BeforeStep
    public void setupStep(){
        System.out.println("---------applying setup using @BeforeStep");
    }

    @AfterStep
    public void teardownStep(){
        System.out.println("---------applying teardown using @AfterStep");
    }
}
