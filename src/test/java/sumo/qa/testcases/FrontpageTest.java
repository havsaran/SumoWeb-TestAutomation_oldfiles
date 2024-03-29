package sumo.qa.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class FrontpageTest extends TestBase {
	Frontpage frontpage;

	public ExtentReports extent;
	public ExtentTest extentTest;

	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		frontpage = new Frontpage();
	}

	@Test(priority = 1)

	public void LogginnFunction_Test() throws InterruptedException {
		extentTest = extent.startTest("LogginnFunction_Testcase");

		frontpage.logginnFunction();

		boolean flag = false;

		try {
			frontpage.GlemtPassord.click();
			Assert.assertEquals(flag, true, "LogginnFunction_Testcase is not clickable");
		} catch (Exception excep) {
			flag = true;
			Assert.assertEquals(flag, true, "LogginnFunction_Testcase is not clickable");
			// System.out.println(excep.getMessage());
		}
	}

	@Test(priority = 2)
	public void GlemtPassordLink_Click_Test() {
		extentTest = extent.startTest("GlemtPassordLink_Click_Testcase");

		frontpage.clickOnGlemtPassordLink();
		Assert.assertEquals(frontpage.GlemtPassordVerifyText.getText(), "Få passord",
				"Glemt Passordlink is not working");

	}

	@Test(priority = 3)
	public void NyBruker_FaatilgangNaaLink_Test() {

		extentTest = extent.startTest("NyBruker_FåtilgangNåLink_Testcase");

		frontpage.clickOn_NyBruker_FåtilgangNåBtn();
		// Assert.assertEquals(frontpage.NybrukerFåtilgangverifyText.getText(),
		// "Registrer ny bruker", "Ny bruker? Få tilgang nå! Link is not working");
		// System.out.println(frontpage.LogginnVerifyText.getText());
		Assert.assertEquals(driver.getTitle(), "Velkommen | TV 2 Sumo", "Asserting texts are not matchced");
	}

	@Test(priority = 4)
	public void logginnBtn_Click_Test() {

		extentTest = extent.startTest("logginnBtn_Click_Testcase");
		frontpage.clickOn_LoggInnBtn();
		Assert.assertEquals(frontpage.LogginnVerifyText.getText(), "Logg inn", "Logginn Button is not working ");
		// System.out.println(frontpage.LogginnVerifyText.getText());
	}

	@Test(priority = 5)
	public void LogginnAvbrytBtn_Click_Test() {
		extentTest = extent.startTest("LogginnAvbrytBtn_Click_Testcase");
		// frontpage.clickOn_LogginnAvbrytBtn();

		boolean flag = false;
		frontpage.clickOn_LogginnAvbrytBtn();

		try {
			frontpage.GlemtPassord.click();
			Assert.assertEquals(flag, true, "LogginnAvbrytBtn_Click_Testcase- is not clickable");
		} catch (Exception e) {
			flag = true;
			Assert.assertEquals(flag, true, "LogginnAvbrytBtn_Click_Testcase- is not working");
			// System.out.println(e.getMessage());
		}

	}

	@Test(priority = 6)
	public void SumoLogo_Click_Test() {
		extentTest = extent.startTest("SumoLogo_Click_Testcase");

		// System.out.println(driver.getTitle());

		frontpage.clickOn_SumoLogo();

		boolean flag = frontpage.FåTilgang.isDisplayed();

		Assert.assertEquals(flag, true, "It's redirected different page");

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "Test Case Failed -" + result.getName());// to add name in extent Report
			extentTest.log(LogStatus.FAIL, "Test Case Failed -" + result.getThrowable());// to add error/exception in
																							// extent report

			String screenshotPath = FrontpageTest.getScreenshot(driver, result.getName());

			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));// to add screenshot in extent
																						// report
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, result.getName());
		}
		extent.endTest(extentTest); // ending test and ends the current test and prepare to create html report
		driver.quit();
	}

	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"

		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;

	}

//	@Test(priority=1)
//	public void FåTilgangBtn_Click_Testcase(){		
//		frontpage.clickOn_FåtilgangBtn();	
//		System.out.println(driver.getTitle());
//		Assert.assertEquals(driver.getTitle(), "Velkommen | TV 2 Sumo", "Fåtilgang Button is not working ");
//			}

}
