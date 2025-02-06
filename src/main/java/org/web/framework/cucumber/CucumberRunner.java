package org.web.framework.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//org.mobile.framework.StepDefinations
@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"org.web.framework.StepDefinations"},
        features = {"src/test/features"},
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/cucumber.html",
                "junit:target/junitreports.xml",
                "html:target/site/cucumber-pretty",
                "json:target/cucumber/cucumber.json"
        },

        monochrome = false

)
public class CucumberRunner {
}
