package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	
	public ResourceBundle rb;
	
	@BeforeClass
	@Parameters("browser")  //getting browser parameter from tstng.xml
	public void setup(String browser) {
		/*//Resource bundle setup
		 * 2 Types
		 * --------
		 * Approach1
		 * ---------   By creating an object for resource bundle with config.properties file and retrieve data
		 * ResourceBundle rb = ResourceBundle.getBundle("config");
		 * rb.getString("appURL")      ==> returns url
		 * rb.getString("email")       ==> returns email
		 * rb.getString("password")    ==> returns password
		 * 
		 * Approach 2
		 * ----------   Using File reader to read config.properties file 
		 * FileReader file = new FileReader("path\\config.properties");  ==== Assigns config.properties file to file object;
		 * Properties prop = new Properties();
		 * prop.load(file);
		 * String url = prop.getProperty("appURL");    ====  retrieves data as properties
		 * String username = prop.getProperty("username")
		 * 
		 */
		
		rb = ResourceBundle.getBundle("config");
		String url = rb.getString("appURL");
		//String email = rb.getString("username");
		//String pwd = rb.getString("password");
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		//Log4j code
		logger = LogManager.getLogger(this.getClass());
		
		if (browser.equals("chrome")){
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	//generate eandom strings and numbers
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String randomAlphaNumeric() {
		String str = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(4);
		return (str + num);
	}
	
	//capture screenshots
	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		try {
			FileUtils.copyFile(source,  new File(destination));
		} catch(Exception e) {
			e.getMessage();
		}
		
		return destination;
	}
	
	
}
