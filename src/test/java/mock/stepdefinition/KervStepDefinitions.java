package mock.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;

import io.cucumber.java.en.*;
import mock.baseclass.BaseClass;
import mock.manager.ObjectManager;

public class KervStepDefinitions extends BaseClass{
	
	ObjectManager obj= new ObjectManager();
	
@Given("User Launches the application")
public void user_Launches_the_application() {

}

@When("User Navigates to job opportunity via career header")
public void user_Navigates_to_job_opportunity_via_career_header() {
   obj.getKervPageInstance().userClicksOnJobOppVia();

}

@When("User Selects the job priority in the job filter")
public void user_Selects_the_job_priority_in_the_job_filter() {
	  obj.getKervPageInstance().userAppliesJobFilter();

}

@When("User Prints the listed jobs")
public void user_Prints_the_listed_jobs() {
obj.getKervPageInstance().userPrintsListedJobs();

}

@When("User Selects the software tester job")
public void user_Selects_the_software_tester_job() throws InterruptedException {
	obj.getKervPageInstance().userSelectsSeniorSoftwareTester();
	
}

@When("User Enters in the form {string},{string},{string},{string},{string}")
public void user_Enters_in_the_form(String firstName, String lastName, String emailId, String phoneNo, String noticePeriod) throws IOException {
obj.getCareerFormPageKervObjInstance().userEnterTheForm(firstName, lastName, emailId, phoneNo, noticePeriod);
}

@Then("User Validates the success message")
public void user_Validates_the_success_message() throws IOException {
obj.getCareerFormPageKervObjInstance().userValidatingTheSuccessMsg();
}



	
	
	
}
