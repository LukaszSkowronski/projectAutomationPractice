package pl.b2b.ProjectAutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
	
	public static void pushSignInButton(WebDriver driver) {
		WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
		signInButton.click();
	}
	
	public static void enterEmail (WebDriver driver){
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("b2bnetworkwarszawa@gmail.com");
	}
	
	public static void enterIncorrectEmail (WebDriver driver) {
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("test@testing.com");
	}
	
	public static void enterPassword (WebDriver driver) {
		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.sendKeys("n3tw0rk2017");
	}
	
	public static void pushSignInButtonAfterEnteringEmailAndPassword(WebDriver driver) {
		WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
		signInButton.click();
	}
	
	
	public static void pushSearchIcon(WebDriver driver) {
		WebElement searchIcon = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button"));
		searchIcon.click();
	}
	
	public static String getSuccessfulLogonMessage(WebDriver driver) {
		WebElement successfulLogonMessage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));
		String logonMessage = successfulLogonMessage.getText().trim();
		return logonMessage;
	}
	public static String getWarningIncorrectEmailMessage (WebDriver driver) {
		WebElement warningIncorrectEmail = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]"));
		String IncorrectEmail = warningIncorrectEmail.getText();
		System.out.println(IncorrectEmail);
		return IncorrectEmail;
	}
	
}
