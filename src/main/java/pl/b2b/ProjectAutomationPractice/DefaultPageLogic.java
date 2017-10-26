package pl.b2b.ProjectAutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class DefaultPageLogic {

	public static void clickButtonSignIn(WebDriver driver) {
		WebElement signInButton = driver.findElement(By.partialLinkText("Sign"));
		signInButton.click();
	}

}
