package pl.b2b.ProjectAutomationPractice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class defaultPageLogic {

	@FindBy(partialLinkText = "Sign")
	private WebElement buttonSignIn;

	public void clickButtonSignIn() {
		this.buttonSignIn.click();
	}

}
