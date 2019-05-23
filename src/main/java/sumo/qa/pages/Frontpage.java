package sumo.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sumo.qa.base.TestBase;
import sumo.qa.util.TestUtil;

public class Frontpage extends TestBase {
	
	//Page Factory
	
	@FindBy(xpath = "//span[text()= \"Logg inn\"]")
	private WebElement LogginnTriggerLink;
	@FindBy(xpath = "//h1[contains(text(), 'Logg')]")
	public	WebElement LogginnVerifyText;
	
	@FindBy(xpath="//span[contains(text(),'Få tilgang')]")
	private WebElement FåTilgang;
	
	@FindBy (partialLinkText = "Ny bruker")
	private WebElement NybrukerFåtilgang;	
	@FindBy (xpath = "//h3[contains(text(),'Registrer ny bruker')]")
	public WebElement NybrukerFåtilgangverifyText;
	
	
	@FindBy(xpath = "//button[contains(text(),'Glemt passord?')]")
	private WebElement GlemtPassord;	
	@FindBy(xpath = "//span[contains(text(),'Få passord')]")
	public WebElement GlemtPassordVerifyText;
	
	//Page Factory: For Logginn Purpose
	@FindBy (name= "user_name")
	private WebElement UserName;
	
	@FindBy (name= "password")
	private WebElement Password;
		
	@FindBy(xpath = "//span[@class='button__text'][contains(text(),'Logg inn')]")
	private WebElement LogginnBtn;
	
	@FindBy (xpath = "//span[@class='dropdown__trigger-text']")
	public WebElement ValidateLoggedinnPage;
	
	
	// Actions 
	
public Frontpage () {
	
	PageFactory.initElements(driver, this);
	}
	
public void clickOn_LoggInnBtn () 
{	LogginnTriggerLink.click();
}

public void clickOn_NyBruker_FåtilgangNåBtn () 
{	LogginnTriggerLink.click();
	NybrukerFåtilgang.click();
	}

public void clickOnGlemtPassordLink () 
{	
	LogginnTriggerLink.click();
	GlemtPassord.click();
	}

public void clickOn_FåtilgangBtn () {
	
	FåTilgang.click();
}

public void logginnFunction () throws InterruptedException {
	
	LogginnTriggerLink.click();
	
	String user = prop.getProperty("username");
	String pass = prop.getProperty("password");
	
	UserName.sendKeys(user);
	Password.sendKeys(pass);
	LogginnBtn.click();
	Thread.sleep(2000);
		
}


}



