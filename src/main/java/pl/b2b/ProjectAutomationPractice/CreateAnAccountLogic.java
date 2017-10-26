package pl.b2b.ProjectAutomationPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccountLogic {

	public static boolean verifyRegisterButtonIsVisible(WebDriver driver) {
		WebElement registerButton = driver.findElement(By.id("submitAccount"));
		return registerButton.isEnabled();
	}

	public static String selectGenderRadioButton(String genderNumber, WebDriver driver) {
		Utils.waitForElementVisible("id_gender1", driver);
		List<WebElement> genderList = driver.findElements(By.name("id_gender"));
		for (WebElement radioText : genderList) {
			if (radioText.getAttribute("id").endsWith(genderNumber)) {
				WebElement mr = driver.findElement(By.id("id_gender1"));
				mr.click();
				mr.isSelected();
			}
			if (radioText.getAttribute("id").endsWith(genderNumber)) {
				WebElement mrs = driver.findElement(By.id("id_gender2"));
				mrs.click();
				mrs.isSelected();
			} else {
				System.out.println("Provided button not displayed!");
			}
		}
		return genderNumber;
	}

	public static void enterFirstName(String firstName, WebDriver driver) {
		WebElement fieldFirstName = driver.findElement(By.id("customer_firstname"));
		fieldFirstName.clear();
		fieldFirstName.sendKeys(firstName);
	}

	public static void enterLastName(String firstName, WebDriver driver) {
		WebElement fieldLastName = driver.findElement(By.id("customer_lastname"));
		fieldLastName.clear();
		fieldLastName.sendKeys(firstName);
	}

	public static void enterPassword(String firstName, WebDriver driver) {
		WebElement fieldPassword = driver.findElement(By.id("passwd"));
		fieldPassword.clear();
		fieldPassword.sendKeys(firstName);
	}

	public static void enterDOB (String DOB, WebDriver driver) { // DD/MM/YYYY format of DOB
		String dayDOB = DOB.substring(0,2);
		String monthDOB = DOB.substring(3,5);
		String yearDOB = DOB.substring(6,10);
		if(DOB.isEmpty()) {
			System.out.println("DOB not provided!");
		}
		else {
			if(dayDOB) {
			WebElement dayOfBirth = driver.findElement(By.id("days"));
			Select d = new Select (dayOfBirth);
			d.selectByValue(dayDOB);
			}
			else {
				System.out.println("Day of birth not provided!");
			}
		}
	}
}