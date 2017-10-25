package pl.b2b.ProjectAutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAnAccountLogic {

	public static boolean verifyRegisterButtonIsVisible(WebDriver driver) {
		Utils.waitForElementVisible("//*[@id='submitAccount']");
		WebElement registerButton = driver.findElement(By.xpath("//*[@id='submitAccount']"));
		return registerButton.isDisplayed();
	}
}
