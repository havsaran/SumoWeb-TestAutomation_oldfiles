package sumo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sumo.qa.base.TestBase;


public class TestcaseTrialTest extends TestBase{
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		
	}
	
	@Test(priority=1)
	public void Testcase1(){
	
		System.out.println("TestCase 1 is executed");
	}
		
	@Test(priority=1)
	public void Testcase2(){
	
		System.out.println("TestCase 2 is executed");
	}
		
	@Test(priority=1)
	public void Testcase3(){
	
		System.out.println("TestCase 3 is executed");
	}
		
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
