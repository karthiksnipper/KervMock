package mock.pages;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import junit.framework.Assert;
import mock.baseclass.BaseClass;

public class KervPage extends BaseClass {
	public KervPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath  = "//*[@class='cookie-box']/div/div/div/p/a[contains(text(),' Accept only essential cookies ')]")
	private WebElement cookieAcceptEssentials;

	@FindBy(xpath  = "//div[contains(text(),'Back')]/following-sibling::a[contains(text(),' Careers')]")
	private WebElement headerCareerButton;

	@FindBy(xpath  = "//div[@class='navbar__sub-big-list']/child::a[contains(text(),'Job Opportunities')]")
	private WebElement jobOpportunity;

	@FindBy(xpath  = "//button[contains(text(),'Location')]")
	private WebElement locationButton;
	
	@FindBy(xpath  = "//button[contains(text(),'India')]")
	private WebElement locationIndiaButton;
	
	@FindBy(xpath  = "//button[contains(text(),'Type')]")
	private WebElement jobTypeButton;
	
	@FindBy(xpath  = "//button[contains(text(),'Full Time')]")
	private WebElement fullTimeTypeButton;
	
	@FindBy(xpath  = "//button[contains(text(),'Remote')]/parent::div")
	private WebElement remoteOptButton;
	
	@FindBy(xpath= "//button[contains(text(),'Hybrid')]/parent::li")
	private WebElement hybridButton;
	
	@FindBy(xpath= "//div[@class='search-results__item']/div[@class='search-results__title']")
	private List<WebElement> listOfJobs;
	
	@FindBy(xpath= "//div[@class='search-results__item']/div[contains(text(),'Senior Test Engineer- Automation')]/parent::*/child::a")
	private WebElement seniorSoftwareTesterJobs;
	

	

public void userClicksOnJobOppVia() {
	
	elementClick(cookieAcceptEssentials);
	try {
	actionsObj().moveToElement(headerCareerButton).click(jobOpportunity).build().perform();
	}catch (RuntimeException e) {
		clickByJs(jobOpportunity);
	}
}

public void userAppliesJobFilter() {
	clickByJs(locationButton);
	clickByJs(locationIndiaButton);
	
	clickByJs(jobTypeButton);
	clickByJs(fullTimeTypeButton);
	
	clickByJs(remoteOptButton);
	clickByJs(hybridButton);
	
}
public void userPrintsListedJobs() {
List<WebElement> liJobs = listOfJobs;
for (WebElement x : liJobs) {
	System.out.println(x.getText());
}



}

public void userSelectsSeniorSoftwareTester() throws InterruptedException {
	
	try{scrollByJs(seniorSoftwareTesterJobs);
	clickByJs(seniorSoftwareTesterJobs);     }
	     
	catch (RuntimeException e) {
//		scrollByJs(seniorSoftwareTesterJobs);
		actionsObj().moveToElement(seniorSoftwareTesterJobs).click(seniorSoftwareTesterJobs).build().perform();}
	
	catch (Exception e) {
		elementClick(seniorSoftwareTesterJobs);
	}
	
	
//	explicitWait(10).until(ExpectedConditions.elementToBeClickable(seniorSoftwareTesterJobs));
Thread.sleep(5000);
	
	}





	
	
	}
	
	
	
