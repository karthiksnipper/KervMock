package mock.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import mock.report.ReportCucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources",
			                  glue={"mock.stepdefinition"},
			                  tags= "@TC-1",
			                  monochrome=true,
			                  plugin= {"pretty","json:target/index.json"},
			                  dryRun=false
		                        )
public class TestRunnerKerv extends ReportCucumber {
	
	@AfterClass
	public static void afterClass() throws Exception {
		System.out.println("AfterClass");
		ReportCucumber.generateJVMReport(getProjectPath()+getPropertyFileValue("jsonPath"));
	}

}
