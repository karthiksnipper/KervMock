package mock.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {	
	
	public static WebDriver driver;
	
	
	public static void anyDriver(String browserName) {
			
			if(browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver","C:\\Users\\mrv02\\Downloads\\KervMock -20230820T042823Z-001\\KervMock\\Drivers\\chromedriver.exe");
				ChromeOptions co = new ChromeOptions ();
				co.addArguments("--remote-allow-origins=*");
				driver=new ChromeDriver(co);
			}
			else if(browserName.equalsIgnoreCase("firefox")){
				driver=new FirefoxDriver();
	}
			else if(browserName.equalsIgnoreCase("ie")) {
				driver=new InternetExplorerDriver(); }
			
	        else if(browserName.equalsIgnoreCase("edge")){
				driver=new EdgeDriver();
				
			}
			}


	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
		}
	
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties=new Properties();
		properties.load(new FileInputStream(getProjectPath()+"\\Config\\config.properties"));
		Object object = properties.get(key);
		String value=(String)object;
		return value;

	}
	
	
		public static void getChromeDriver() {
			WebDriverManager.chromedriver().setup();
			ChromeOptions co = new ChromeOptions ();
			co.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(co);
			
		}
		
	
	
	
	public static void getChromeDriverSetProp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\mrv02\\Downloads\\KervMock -20230820T042823Z-001\\KervMock\\Drivers\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions ();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		
	}
	
	public static void enterApplUrl(String url) {
		driver.get(url);
		}
	
	public static  void maximizewindow() {
		driver.manage().window().maximize();
		}
	
	public static void elementInsertValue(WebElement element, String data) {
		element.sendKeys(data);
		}
	
	public static void elementClick(WebElement element) {
		element.click();
		}
	
	public static Actions  actionsObj() {
		Actions act= new Actions(driver);
		return act;
	}
	
	public static void elementClear(WebElement element) {
		element.clear();
	}
	
	public static  void maximize() {
		driver.manage().window().maximize();
		}
	
	public static String elementGetText(WebElement element) {
		String text = element.getText();
		return text; }
		
		public static String elementGetAttribute(WebElement element, String value) {
			String attribute = element.getAttribute("value");
			return attribute;
			}
	
		public static  void closeCurrentWin() {
			driver.close();
		}
		
		public static void insertValueByJs(WebElement element, String data) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('value','"+data+"')", element);

		}
		
		
		
		public void windowHandleToParent() {
			String parentWinId = driver.getWindowHandle();
	        Set<String> allWinIds = driver.getWindowHandles();
	       for(int i = 0; i <allWinIds.size(); i++)  {
	            if (!(allWinIds.equals(parentWinId)))
	                driver.switchTo().window(parentWinId);
	        };
		}
		
		public static byte[] scenarioScreenShot() {
            TakesScreenshot ts = (TakesScreenshot)driver;
			byte[] b= ts.getScreenshotAs(OutputType.BYTES);		
			return b;
		}
		
		
		public static void quitWindow() {
			driver.quit();

		}
		public static void clickByJs(WebElement element) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click()", element);
		}

		public static void scrollByJs(WebElement element) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);",element);
		}
		
		public static WebElement findElementByXpath(String xpath) {
			WebElement element = driver.findElement(By.xpath(xpath));
			return element;
		}

		public static void implicitlyWait(long seconds) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		}
		public static WebDriverWait explicitWait(long seconds) {
			WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			
			return w1;
		}
		
		public static String readFromExcell( String sheetName,
				  Integer rowNum, Integer cellNum) 
				  throws IOException{
			String cellval="";
FileInputStream fs = new FileInputStream("C:\\Users\\User\\eclipse-workspace 11 java\\MockAmazon\\Excel\\TestData.xlsx");

Workbook workbook = new XSSFWorkbook(fs);
Sheet sheet = workbook.getSheet(sheetName);
Row row = sheet.getRow(rowNum);
Cell cell = row.getCell(cellNum);
CellType type = cell.getCellType();


switch (type) {
case STRING:
	cellval = cell.getStringCellValue();
		break;
case NUMERIC:
	double numericCellValue = cell.getNumericCellValue();
	long numberL = Math.round(numericCellValue);
	if(numberL== numericCellValue) {
	cellval=String.valueOf(numberL);}
        	else
			{cellval=String.valueOf(numericCellValue);}
	break;

default:
	break;
}


return cellval;


}
		public static void selectByVisibleText(WebElement ele, String text) {
			Select sel =new Select(ele);
			sel.selectByVisibleText(text);
			
		}

}
