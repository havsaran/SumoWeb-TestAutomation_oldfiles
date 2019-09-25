
/* URL name is : 
 * https://sumo.tv2.no/ny-bruker
 */
package sumo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sumo.qa.base.TestBase;

public class Nybruker extends TestBase {

	public Nybruker() {

		PageFactory.initElements(driver, this);

	}

	// pagefactory

	@FindBy(xpath = "//a[contains(text(),'her')]")
	private WebElement pakkerLink;

	// Click methods

	public void goToPakker() {

		pakkerLink.click();

	}

}
