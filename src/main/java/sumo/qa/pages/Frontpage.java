package sumo.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sumo.qa.base.TestBase;
import sumo.qa.util.TestUtil;

public class Frontpage extends TestBase {
	
	
	
	@FindBy(xpath = "//span[text()= \"Logg inn\"]")
	private WebElement Logginn;
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
	
	
public Frontpage () {
	
	PageFactory.initElements(driver, this);
	}
	
public void clickOn_LoggInnBtn () 
{	Logginn.click();
}

public void clickOn_NyBruker_FåtilgangNåBtn () 
{	NybrukerFåtilgang.click();
	}

public void clickOnGlemtPassordLink () 
{	GlemtPassord.click();
	}

public void clickOn_FåtilgangBtn () {
	
	FåTilgang.click();
}



}

