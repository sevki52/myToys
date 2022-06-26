package de.myToys.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "de/myToys/step_definition",
        dryRun = false,
        tags = "@shop"
)
public class CukesRunner {
}
