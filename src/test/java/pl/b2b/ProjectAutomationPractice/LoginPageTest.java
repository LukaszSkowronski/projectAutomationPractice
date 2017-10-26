package pl.b2b.ProjectAutomationPractice;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {

	private static WebDriver driver;

	@BeforeClass
	public static void createBrowserInstanceNavigateToURL() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
	}

	@Test
	public void incorrectEmailLoginPage() {
		Utils.verifyUserLoggedOffIfNotClickSignOut();
		DefaultPageLogic.clickButtonSignIn(driver);
		LoginPageLogic.enterEmail("!email", driver);
		LoginPageLogic.enterPassword("n3tw0rk2017", driver);
		LoginPageLogic.clickButtonSignInAfterProvidingLoginDetails(driver);
		assertEquals("There is 1 error\n" + "Invalid email address.", LoginPageLogic.getIncorretLoginDetailsMessage(driver));
	}

	@Test
	public void incorrectPasswordLoginPage() {
		Utils.verifyUserLoggedOffIfNotClickSignOut();
		DefaultPageLogic.clickButtonSignIn(driver);
		LoginPageLogic.enterEmail("b2bnetworkwarszawa@gmail.com", driver);
		LoginPageLogic.enterPassword("!password", driver);
		LoginPageLogic.clickButtonSignInAfterProvidingLoginDetails(driver);
		assertEquals("There is 1 error\n" + "Authentication failed.", LoginPageLogic.getIncorretLoginDetailsMessage(driver));
	}

	@Test
	public void missingEmailLoginPage() {
		Utils.verifyUserLoggedOffIfNotClickSignOut();
		DefaultPageLogic.clickButtonSignIn(driver);
		LoginPageLogic.enterEmail("", driver);
		LoginPageLogic.enterPassword("n3tw0rk2017", driver);
		LoginPageLogic.clickButtonSignInAfterProvidingLoginDetails(driver);
		assertEquals("There is 1 error\n" + "An email address required.",
				LoginPageLogic.getIncorretLoginDetailsMessage(driver));
	}

	@Test
	public void missingPasswordLoginPage() {
		Utils.verifyUserLoggedOffIfNotClickSignOut();
		DefaultPageLogic.clickButtonSignIn(driver);
		LoginPageLogic.enterEmail("b2bnetworkwarszawa@gmail.com", driver);
		LoginPageLogic.enterPassword("", driver);
		LoginPageLogic.clickButtonSignInAfterProvidingLoginDetails(driver);
		assertEquals("There is 1 error\n" + "Password is required.", LoginPageLogic.getIncorretLoginDetailsMessage(driver));
	}
	
	@Test
	public void successfulLogin() {
		Utils.verifyUserLoggedOffIfNotClickSignOut();
		DefaultPageLogic.clickButtonSignIn(driver);
		LoginPageLogic.enterEmail("b2bnetworkwarszawa@gmail.com", driver);
		LoginPageLogic.enterPassword("n3tw0rk2017", driver);
		LoginPageLogic.clickButtonSignInAfterProvidingLoginDetails(driver);
		assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", DefaultPageUserLoggedLogic.getSuccessfulLoginMessage(driver));
	}
	
	@Test
	public void incorrectEmailCreateAnAccount () throws InterruptedException {
		Utils.verifyUserLoggedOffIfNotClickSignOut();
		DefaultPageLogic.clickButtonSignIn(driver);
		LoginPageLogic.enterEmailCreateAnAccount("!email", driver);
		LoginPageLogic.clickButtonCreateAnAccount(driver);
		assertEquals("Invalid email address.", LoginPageLogic.getIncorrectEmailMessageAccountCreation(driver));
	}
	
	@Test
	public void successfulEmailAccountCreation() throws InterruptedException {
		Utils.verifyUserLoggedOffIfNotClickSignOut();
		DefaultPageLogic.clickButtonSignIn(driver);
		LoginPageLogic.enterEmailCreateAnAccount("test@testt.pl", driver);
		LoginPageLogic.clickButtonCreateAnAccount(driver);
		Thread.sleep(10000);
		assertEquals(true, CreateAnAccountLogic.verifyRegisterButtonIsVisible());
	}

	@AfterClass
	public static void close() {
		driver.close();
	}

}
