package pl.b2b.ProjectAutomationPractice;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPageTest extends Methods {

	defaultPageLogic defaultPageLogic = PageFactory.initElements(driver, defaultPageLogic.class);
	loginPageLogic loginPageLogic = PageFactory.initElements(driver, loginPageLogic.class);
	defaultPageUserLoggedLogic defaultPageUserLoggedLogic = PageFactory.initElements(driver,
			defaultPageUserLoggedLogic.class);
	CreateAnAccountLogic createAnAccountLogic = PageFactory.initElements(driver, CreateAnAccountLogic.class);

	@BeforeClass
	public static void createBrowserInstanceNavigateToURL() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");

	}

	@Test
	public void incorrectEmailLoginPage() {
		Methods.verifyUserLoggedOffIfNotClickSignOut();
		defaultPageLogic.clickButtonSignIn();
		loginPageLogic.enterEmail("!email");
		loginPageLogic.enterPassword("n3tw0rk2017");
		loginPageLogic.clickButtonSignInAfterProvidingLoginDetails();
		assertEquals("There is 1 error\n" + "Invalid email address.",
				loginPageLogic.getIncorretLoginDetailsMessage());
	}

	@Test
	public void incorrectPasswordLoginPage() {
		Methods.verifyUserLoggedOffIfNotClickSignOut();
		defaultPageLogic.clickButtonSignIn();
		loginPageLogic.enterEmail("b2bnetworkwarszawa@gmail.com");
		loginPageLogic.enterPassword("!password");
		loginPageLogic.clickButtonSignInAfterProvidingLoginDetails();
		assertEquals("There is 1 error\n" + "Authentication failed.",
				loginPageLogic.getIncorretLoginDetailsMessage());
	}

	@Test
	public void missingEmailLoginPage() {
		Methods.verifyUserLoggedOffIfNotClickSignOut();
		defaultPageLogic.clickButtonSignIn();
		loginPageLogic.enterEmail("");
		loginPageLogic.enterPassword("n3tw0rk2017");
		loginPageLogic.clickButtonSignInAfterProvidingLoginDetails();
		assertEquals("There is 1 error\n" + "An email address required.",
				loginPageLogic.getIncorretLoginDetailsMessage());
	}

	@Test
	public void missingPasswordLoginPage() {
		Methods.verifyUserLoggedOffIfNotClickSignOut();
		defaultPageLogic.clickButtonSignIn();
		loginPageLogic.enterEmail("b2bnetworkwarszawa@gmail.com");
		loginPageLogic.enterPassword("");
		loginPageLogic.clickButtonSignInAfterProvidingLoginDetails();
		assertEquals("There is 1 error\n" + "Password is required.",
				loginPageLogic.getIncorretLoginDetailsMessage());
	}

	@Test
	public void successfulLogin() {
		Methods.verifyUserLoggedOffIfNotClickSignOut();
		defaultPageLogic.clickButtonSignIn();
		loginPageLogic.enterEmail("b2bnetworkwarszawa@gmail.com");
		loginPageLogic.enterPassword("n3tw0rk2017");
		loginPageLogic.clickButtonSignInAfterProvidingLoginDetails();
		assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.",
				defaultPageUserLoggedLogic.getSuccessfulLoginMessage());
	}

	@Test
	public void incorrectEmailCreateAnAccount() throws InterruptedException {
		Methods.verifyUserLoggedOffIfNotClickSignOut();
		defaultPageLogic.clickButtonSignIn();
		loginPageLogic.enterEmailCreateAnAccount("!email");
		loginPageLogic.clickButtonCreateAnAccount();
		assertEquals("Invalid email address.", loginPageLogic.getIncorrectEmailMessageAccountCreation());
	}

	@Test
	public void successfulEmailAccountCreation() throws InterruptedException {
		Methods.verifyUserLoggedOffIfNotClickSignOut();
		defaultPageLogic.clickButtonSignIn();
		loginPageLogic.enterEmailCreateAnAccount("test@testt.pl");
		loginPageLogic.clickButtonCreateAnAccount();
		createAnAccountLogic.verifyRegisterButtonIsVisible();
		assertEquals(true, createAnAccountLogic.verifyRegisterButtonIsVisible());
	}

	@AfterClass
	public static void close() {
		driver.close();
	}

}
