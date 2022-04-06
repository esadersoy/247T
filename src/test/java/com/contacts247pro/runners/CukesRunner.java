package com.contacts247pro.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt",
                "pretty"        },
        stepNotifications = true,
        features = "src/test/resources/features",
        glue = "com/contacts247pro/stepDefs",
        dryRun = false,
        tags = "@All"
)
public class CukesRunner {
}
