package sumo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sumo.qa.base.TestBase;

public class Frontpage extends TestBase {
	
	
	@FindBy(xpath = "//span[text()= \"Logg inn\"]")
	WebElement Logginn;
	
	@FindBy(xpath="//span[contains(text(),'Få tilgang')]")
	WebElement FåTilgang;
	

public Frontpage () {
	PageFactory.initElements(driver, this);
	}
	
public void clickOn_LoggInnBtn () 
{
	
	
	
}

public void clickOn_FåtilgangBtn () {}



}

