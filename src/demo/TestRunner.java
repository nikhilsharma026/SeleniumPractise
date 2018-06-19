package demo;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features="Test.feature",plugin={"pretty","html:testoutput/test.html","junit:junit_xml/cucumber.xml"},glue={"demo.StepDefinition"},monochrome=true,tags = {"@RegressionTest"},dryRun=true,strict=true)

public class TestRunner {

}
