package pl.b2b.ProjectAutomationPractice;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPageTest extends Methods{
	
	defaultPageLogic defaultPageLogic = PageFactory.initElements(driver, defaultPageLogic.class);
	loginPageLogic loginPageLogic = PageFactory.initElements(driver, loginPageLogic.class);
	defaultPageUserLoggedLogic defaultPageUserLoggedLogic = PageFactory.initElements(driver, defaultPageUserLoggedLogic.class);
	
	@BeforeClass
	public static void createBrowserInstanceNavigateToURL() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");

	}

	@Test
	public void incorrectEmailLoginPage() {
		Methods.verifyUserLoggedOffIfNotClickSignOut(driver);
		defaultPageLogic.clickButtonSignIn();
		loginPageLogic.enterEmail("!email", driver);
		loginPageLogic.enterPassword("n3tw0rk2017", driver);
		loginPageLogic.clickButtonSignInAfterProvidingLoginDetails(driver);
		assertEquals("There is 1 error\n" + "Invalid email address.",
				loginPageLogic.getIncorretLoginDetailsMessage(driver));
	}

	@Test
	public void incorrectPasswordLoginPage() {
		Methods.verifyUserLoggedOffIfNotClickSignOut(driver);
		defaultPageLogic.clickButtonSignIn(driver);
		loginPageLogic.enterEmail("b2bnetworkwarszawa@gmail.com", driver);
		loginPageLogic.enterPassword("!password", driver);
		loginPageLogic.clickButtonSignInAfterProvidingLoginDetails(driver);
		assertEquals("There is 1 error\n" + "Authentication failed.",
				loginPageLogic.getIncorretLoginDetailsMessage(driver));
	}

	@Test
	public void missingEmailLoginPage() {
		Methods.verifyUserLoggedOffIfNotClickSignOut(driver);
		defaultPageLogic.clickButtonSignIn();
		loginPageLogic.enterEmail("", driver);
		loginPageLogic.enterPassword("n3tw0rk2017", driver);
		loginPageLogic.clickButtonSignInAfterProvidingLoginDetails(driver);
		assertEquals("There is 1 error\n" + "An email address required.",
				loginPageLogic.getIncorretLoginDetailsMessage(driver));
	}

	@Test
	public void missingPasswordLoginPage() {
		Methods.verifyUserLoggedOffIfNotClickSignOut(driver);
		defaultPageLogic.clickButtonSignIn(driver);
		loginPageLogic.enterEmail("b2bnetworkwarszawa@gmail.com", driver);
		loginPageLogic.enterPassword("", driver);
		loginPageLogic.clickButtonSignInAfterProvidingLoginDetails(driver);
		assertEquals("There is 1 error\n" + "Password is required.",
				loginPageLogic.getIncorretLoginDetailsMessage(driver));
	}

	@Test
	public void successfulLogin() {
		Methods.verifyUserLoggedOffIfNotClickSignOut(driver);
		defaultPageLogic.clickButtonSignIn(driver);
		loginPageLogic.enterEmail("b2bnetworkwarszawa@gmail.com", driver);
		loginPageLogic.enterPassword("n3tw0rk2017", driver);
		loginPageLogic.clickButtonSignInAfterProvidingLoginDetails(driver);
		assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.",
				defaultPageUserLoggedLogic.getSuccessfulLoginMessage(driver));
	}

	@Test
	public void incorrectEmailCreateAnAccount() throws InterruptedException {
		Methods.verifyUserLoggedOffIfNotClickSignOut(driver);
		defaultPageLogic.clickButtonSignIn(driver);
		loginPageLogic.enterEmailCreateAnAccount("!email", driver);
		loginPageLogic.clickButtonCreateAnAccount(driver);
		assertEquals("Invalid email address.", loginPageLogic.getIncorrectEmailMessageAccountCreation(driver));
	}

	@Test
	public void successfulEmailAccountCreation() throws InterruptedException {
		Methods.verifyUserLoggedOffIfNotClickSignOut(driver);
		defaultPageLogic.clickButtonSignIn(driver);
		loginPageLogic.enterEmailCreateAnAccount("test@testt.pl", driver);
		loginPageLogic.clickButtonCreateAnAccount(driver);
		Methods.waitForElementVisible("submitAccount", driver);
		assertEquals(true, CreateAnAccountLogic.verifyRegisterButtonIsVisible(driver));
	}

	@AfterClass
	public static void close() {
		driver.close();
	}

}
