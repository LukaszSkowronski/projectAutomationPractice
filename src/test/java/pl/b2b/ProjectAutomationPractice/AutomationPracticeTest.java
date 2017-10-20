package pl.b2b.ProjectAutomationPractice;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationPracticeTest {

	private WebDriver driver;
	LoginPage LoginPage = new LoginPage();
	DefaultPage DefaultPage = new DefaultPage();

	@Before

	public void createBrowserInstanceNavigateToURL() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
	}

	@Test
	public void incorrectEmailLoginPage() {
		DefaultPage.clickButtonSignIn();
		LoginPage.enterEmail("incorrectEmail@test.com");
		LoginPage.enterPassword("n3tw0rk2017");
		assertEquals("There is 1 error\n" + "Invalid email address.", LoginPage.getWarningIncorrectLoginDetails());
	}

	@Test
	public void incorrectPasswordLoginPage() {
		DefaultPage.clickButtonSignIn();
		LoginPage.enterEmail("b2bnetworkwarszawa@gmail.com");
		LoginPage.enterPassword("incorrectpassword");
		assertEquals("There is 1 error\n" + "Authentication failed.", LoginPage.getWarningIncorrectLoginDetails());
	}

	@After
	public void close() {
		driver.close();
	}
}
