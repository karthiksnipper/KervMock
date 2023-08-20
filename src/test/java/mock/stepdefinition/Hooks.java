package mock.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import mock.baseclass.BaseClass;

public class Hooks extends BaseClass{
	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
//		anyDriver(getPropertyFileValue("browserName"));
		getChromeDriver();
		enterApplUrl(getPropertyFileValue("url"));
		maximizewindow();
		implicitlyWait(10);

	}
	
	@After
	public void afterScenario(Scenario scenario) {
		
		if(scenario.isFailed())
				scenario.attach(scenarioScreenShot(),"image/png","failed scenario");
			quitWindow();
		}


		}



