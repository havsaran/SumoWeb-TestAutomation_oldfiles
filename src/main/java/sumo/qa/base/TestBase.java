package sumo.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import sumo.qa.util.TestUtil;


public class TestBase {
	//public int number = 5;
	public static WebDriver driver;
	public static Properties prop;
	
	public ExtentReports extent;
	public ExtentTest logger;
	
// 	TestBase constructor
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/sumo/qa/config"
					+ "/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
		
// Browser initialization
	public static void initialization() throws InterruptedException{
		String browserName = prop.getProperty("browser");
		
		String OS=System.getProperty("os.name");
		
	if(OS.toUpperCase().contains("WINDOWS")) {
	
		if(browserName.equals("chrome")){
			//System.setProperty("webdriver.chrome.driver", "C:\\Files needed for Testing Automation\\chromedriver_win32\\chromedriver.exe");	
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
	}
	
	else if(OS.toUpperCase().contains("MAC")) {
	
		if(browserName.equals("chrome")){
			//System.setProperty("webdriver.chrome.driver", "C:\\Files needed for Testing Automation\\chromedriver_win32\\chromedriver.exe");	
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "geckodriver");	
			driver = new FirefoxDriver(); 
		}
	}
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicityWait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		Thread.sleep(TestUtil.sleepTime);
		
	}
			
}