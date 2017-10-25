package pl.b2b.ProjectAutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageLogic {

	public static String enterEmail(String email, WebDriver driver) {
		WebElement fieldEmail = driver.findElement(By.id("email"));
		fieldEmail.sendKeys(email);
		return email;
	}

	public static String enterPassword(String password, WebDriver driver) {
		WebElement fieldPassword = driver.findElement(By.id("passwd"));
		fieldPassword.sendKeys(password);
		return password;
	}
	
	public static String enterEmailCreateAnAccount(String email, WebDriver driver) {
		WebElement fieldEnterEmailCreateAnAccount = driver.findElement(By.id("email_create"));
		fieldEnterEmailCreateAnAccount.sendKeys(email);
		return email;
	}

	public static String getIncorretLoginDetailsMessage(WebDriver driver) {
		WebElement incorrectLoginMessage = driver.findElement(By.xpath("//*[@id='center_column']/div[1]"));
		return incorrectLoginMessage.getText().trim();
	}
	
	public static String getIncorrectEmailMessageAccountCreation(WebDriver driver) {
		WebElement incorrectAccountCreationMessage = driver.findElement(By.xpath("//*[@id='create_account_error']"));
		return incorrectAccountCreationMessage.getText().trim();
		
	}
	
	public static void clickButtonSignInAfterProvidingLoginDetails(WebDriver driver) {
		WebElement signInAfterProvidingLoginDetails = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]"));
		signInAfterProvidingLoginDetails.click();
	}
	
	public static void clickButtonCreateAnAccount (WebDriver driver) {
		WebElement createAnAcountButton = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
		createAnAcountButton.click();
	}
	
	public static void clickEnterEmailCreateAnAccount(WebDriver driver) {
		WebElement enterEmailCreateAnAccount = driver.findElement(By.xpath("//*[@id='SubmitCreate']/span"));
		enterEmailCreateAnAccount.click();	
	}
}
