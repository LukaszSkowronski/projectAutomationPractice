package pl.b2b.ProjectAutomationPractice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DefaultPage {
	
	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	private WebElement buttonSignIn;
	
	public void clickButtonSignIn() {
		this.buttonSignIn.click();
	}

}
