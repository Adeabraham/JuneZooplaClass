package co.uk.zoopla.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src/test/java/co/uk/zoopla/features/"},
        glue = {"co/uk/zoopla/hooks", "co/uk/zoopla/stepDefinitions"},
        plugin = {"pretty", "json:target/report.json",
                "de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber"},
        tags = ("not @ignore")
        // tags = ("@error) and not @ignore"), // this did not give error here but running the test does


)
public class TestRunnerSmoke{
}
