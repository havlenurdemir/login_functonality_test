package com.login_functionality.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
        "json:target/cucumber.json",
        "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "com/login_functionality/step_definitions",
        dryRun = false,
        tags="@TRAN10-281"
)
public class CukesRunner {


}
