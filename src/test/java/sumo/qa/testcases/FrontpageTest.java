package sumo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sumo.qa.base.TestBase;
import sumo.qa.pages.Frontpage;

public class FrontpageTest extends TestBase{
	
	Frontpage frontpage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		frontpage = new Frontpage ();
		
	}
	
	@Test(priority=1)
	public void logginnBtn_Click_Testcase(){		
		frontpage.clickOn_LoggInnBtn ();		
		Assert.assertEquals(frontpage.LogginnVerifyText.getText(), "Logg inn", "Logginn Button is not working ");
		//System.out.println(frontpage.LogginnVerifyText.getText());
	}
	
//	@Test(priority=1)
//	public void FåTilgangBtn_Click_Testcase(){		
//		frontpage.clickOn_FåtilgangBtn();	
//		System.out.println(driver.getTitle());
//		Assert.assertEquals(driver.getTitle(), "Velkommen | TV 2 Sumo", "Fåtilgang Button is not working ");
//			}
	
	@Test(priority=2)
	public void GlemtPassordLink_Click_Testcase(){		
		frontpage.clickOn_LoggInnBtn ();
		frontpage.clickOnGlemtPassordLink();		
		Assert.assertEquals(frontpage.GlemtPassordVerifyText.getText(), "Få passord", "Glemt Passordlink is not working");
		//System.out.println(frontpage.LogginnVerifyText.getText());
	}
	
	@Test(priority=3)
	public void NyBruker_FåtilgangNåLink_Click_Testcase(){	
		frontpage.clickOn_LoggInnBtn ();
		frontpage.clickOn_NyBruker_FåtilgangNåBtn();		
		Assert.assertEquals(frontpage.NybrukerFåtilgangverifyText.getText(), "Registrer ny bruker", "Ny bruker? Få tilgang nå! Link is not working");
		//System.out.println(frontpage.LogginnVerifyText.getText());
	}
	
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
