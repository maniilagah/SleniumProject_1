package CucumberRunnerFile;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber; 

@RunWith(Cucumber.class) 
@CucumberOptions(features = "C:\\Users\\Owner\\eclipse-workspace\\seleniumProject_1\\src\\CucumberFeatureFiles\\NewFeatureFile.feature",
	glue = "abc") 

public class CucumberTestRunner {

}
