package sumo.qa.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import sumo.qa.base.TestBase;
import sumo.qa.pages.Frontpage;
import sumo.qa.pages.Nybruker;

public class NybrukerTest extends TestBase{
	Nybruker nybruker;

	public ExtentReports extent;
	public ExtentTest extentTest;
    	
	@BeforeTest
	public void setExtent () {
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html",true);
					
	}
	
			
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
				nybruker= new Nybruker ();
	
	}	
	
	@Test

	String NybrukerTest () {
		extentTest = extent.startTest("NybrukerTest_Testcase");
		String howmanyapple = "10";
		System.out.println(this);
		return howmanyapple;
		
	}
	
	@Test
	void goToPakkerTest() {
	extentTest = extent.startTest("goToPakkerTest_Testcase");
		nybruker.goToPakker();
	
	
	}
	
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		if (result.getStatus()==ITestResult.FAILURE) {
			extentTest.log (LogStatus.FAIL, "Test Case Failed -"+ result.getName());//to add name in extent Report
		    extentTest.log (LogStatus.FAIL, "Test Case Failed -"+ result.getThrowable());// to add error/exception in extent report
		
		    String screenshotPath = FrontpageTest.getScreenshot(driver, result.getName());
		
		    extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));// to add screenshot in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, result.getName());
		}
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		driver.quit();
	}

	
	@AfterTest
	public void endReport () {
		extent.flush();
		extent.close();
	}
	

	
	
}

