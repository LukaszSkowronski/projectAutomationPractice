package pl.b2b.ProjectAutomationPractice;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAnAccountLogic {
	
	public static WebDriver driver;

	public static boolean verifyRegisterButtonIsVisible() {
		WebElement registerButton = driver.findElement(By.id("submitAccount"));
		return registerButton.isDisplayed();
	}
	
	public static String selectGenderRadioButton(String gender) {
		List<WebElement> genderList = driver.findElements(By.className("radio-inline"));
		for (WebElement radioText : genderList) {
			if(radioText.getText() == gender) {
				WebElement mr = driver.findElement(By.xpath("//*[@id=\"id_gender1\"]"));
				mr.click();
			}
			if(radioText.getText() == gender) {
				WebElement mrs = driver.findElement(By.xpath("//*[@id=\"id_gender2\"]"));
				mrs.click();
			}
			
		}
		return gender;

		
		
	}
}
