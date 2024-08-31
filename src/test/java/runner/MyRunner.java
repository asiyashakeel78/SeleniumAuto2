package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Feature",
    glue = "stepDefintion",
    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
    monochrome = true
)/*configuring plugins for a Cucumber "pretty",plugin formats output of test in redabl way nd prints it to console in human-readable frmt
"html:Ths plugin generates an HTML report of the test results ad svs it in target fldr.
json:Ths plugin generates a JSON report of the test results and saves it to target*/

public class MyRunner extends AbstractTestNGCucumberTests {
//allows you to run Cucumber tests using TestNG. 
//AbstractTestNGCucumberTests,is cls by Cucumber to integrt with TestNG.

}
