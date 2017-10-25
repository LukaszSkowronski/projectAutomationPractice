package pl.b2b.ProjectAutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DefaultPageUserLoggedLogic {
	
	public static String getSuccessfulLoginMessage(WebDriver driver) {
		WebElement successfulLoginMessage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));
		return successfulLoginMessage.getText().toString();
	}
}
