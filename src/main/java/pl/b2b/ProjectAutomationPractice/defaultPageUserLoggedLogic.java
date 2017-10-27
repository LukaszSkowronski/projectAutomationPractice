package pl.b2b.ProjectAutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class defaultPageUserLoggedLogic {

	@FindBy(xpath = "//*[@id='center_column']/p")
	private WebElement successfulLoginMessage;

	public String getSuccessfulLoginMessage(WebDriver driver) {
		return this.successfulLoginMessage.getText().trim();
	}
}
