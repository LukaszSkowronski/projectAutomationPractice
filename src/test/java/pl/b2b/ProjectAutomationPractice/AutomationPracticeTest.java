package pl.b2b.ProjectAutomationPractice;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationPracticeTest {

	private WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
	}

	// @Test
	// public void verifyWarningMessageAfterIncorrectSearch() {
	//
	// }
	@Test
	public void successfulLogin() {
		Utils.pushSignInButton(driver);
		Utils.enterEmail(driver);
		Utils.enterPassword(driver);
		Utils.pushSignInButtonAfterEnteringEmailAndPassword(driver);
		Utils.getSuccessfulLogonMessage(driver);
		assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.",
				Utils.getSuccessfulLogonMessage(driver));

	}
	
	@Test
	public void unsuccessfulLoginIncorrectEmailWarningMessage() {
		Utils.pushSignInButton(driver);
		Utils.enterIncorrectEmail(driver);
		Utils.pushSignInButtonAfterEnteringEmailAndPassword(driver);
		Utils.getWarningIncorrectEmailMessage(driver);
		assertEquals("There is 1 error\n"+
				"Password is required.", Utils.getWarningIncorrectEmailMessage(driver));
	}

	@After
	public void close() {
		driver.close();
	}
}
