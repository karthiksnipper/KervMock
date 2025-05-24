package mock.pages;

import java.util.List;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import mock.baseclass.BaseClass;

public class CareerFormPageKerv extends BaseClass {
	public CareerFormPageKerv() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath  = "//input[@id='candidate_first_name']")
	private WebElement candfirstName;

	@FindBy(xpath  = "//input[@id='candidate_last_name']")
	private WebElement candlastName;
	
	@FindBy(xpath  = "//input[@id='candidate_email']")
	private WebElement candemailId;
	
	@FindBy(xpath  = "//input[@id='candidate_phone']")
	private WebElement candphoneNo;
	
	@FindBy(xpath  = "//input[@id='resume']")
	private WebElement uploadResume;
	
	@FindBy(xpath  = "//input[@id='notice_period']")
	private WebElement candnoticePeriod;
	
	@FindBy(xpath  = "//*[contains(text(),'Submit')] /parent::button[@type='submit']")
	private WebElement sumbit;
	
	@FindBy(xpath  = "//br/parent::p[contains(text(),'Thank')]")
	private WebElement successMsg;
	
	
public void	userEnterTheForm(String firstName, String lastName, String emailId, String phoneNo, String noticePeriod) throws IOException{


    URL url = new URL(driver.getCurrentUrl());
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    long startTime = System.currentTimeMillis();
    connection.connect();
    long endTime = System.currentTimeMillis();

    long responseTime = endTime - startTime;
    System.out.println("Response time: " + responseTime + " ms");

    connection.disconnect();
	
	Set<String> allWin = driver.getWindowHandles();
	List<String> orderedId = new ArrayList<String>(allWin);
	driver.switchTo().window(orderedId.get(1));
//	String resumePath ="C:\Users\User\eclipse-workspace 11 java\KervMock\src\test\resources\karthik_softwareTester.pdf";
	elementInsertValue(candfirstName, firstName);
	elementInsertValue(candlastName, lastName);
	elementInsertValue(candemailId, emailId);
	elementInsertValue(candphoneNo, phoneNo);
	elementInsertValue(candnoticePeriod, noticePeriod);
	elementInsertValue(uploadResume, System.getProperty("user.dir")+"\\src\\test\\resources\\karthik_softwareTester.pdf");
	clickByJs(sumbit);
			
}
public void userValidatingTheSuccessMsg() throws IOException{
	explicitWait(10).until(ExpectedConditions.visibilityOf(successMsg));
	URL url = new URL(driver.getCurrentUrl());
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    long startTime = System.currentTimeMillis();
    connection.connect();
    long endTime = System.currentTimeMillis();

    long responseTime = endTime - startTime;
    System.out.println("Response time: " + responseTime + " ms");
    
	String text = elementGetText(successMsg);
	assertTrue("validating the success message", text.contains("Thank you for your"));
	
}

public void jason(){
//timer jason check
} 

}