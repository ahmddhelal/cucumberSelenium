package Runners;


import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonFormat;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "steps", tags = "@contactUse",
                plugin = {"pretty", "html:D:target\\reports\\regression.html"},
                dryRun = false, monochrome = true)
public class TestRunner {
}
