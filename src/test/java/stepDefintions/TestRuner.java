package stepDefintions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Resorces/Features", glue = {"stepdefinitions"})
public class TestRuner {

}
