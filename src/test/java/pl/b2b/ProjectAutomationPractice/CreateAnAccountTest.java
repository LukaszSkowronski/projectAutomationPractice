package pl.b2b.ProjectAutomationPractice;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountTest {
	
	public static WebDriver driver;
	
	defaultPageLogic defaultPageLogic = PageFactory.initElements(driver, defaultPageLogic.class);
	loginPageLogic loginPageLogic = PageFactory.initElements(driver, loginPageLogic.class);
	defaultPageUserLoggedLogic defaultPageUserLoggedLogic = PageFactory.initElements(driver,
			defaultPageUserLoggedLogic.class);
	CreateAnAccountLogic createAnAccountLogic = PageFactory.initElements(driver, CreateAnAccountLogic.class);
	
	@BeforeClass
	public static void createBrowserInstanceNavigateToURL() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
		driver.manage().window().maximize();
	}
	
	@Test
	public void successfulCreateAnAccount() throws InterruptedException {
		Methods.verifyUserLoggedOffIfNotClickSignOut();
		defaultPageLogic.clickButtonSignIn();
		loginPageLogic.enterEmailCreateAnAccount("test@testt.pl");
		loginPageLogic.clickButtonCreateAnAccount();
		createAnAccountLogic.selectGenderRadioButton("2"); // "1" - Mr, "2" - Mrs
		createAnAccountLogic.enterFirstName("Lukasz");
		createAnAccountLogic.selectDOB("11/11/1995");
		createAnAccountLogic.selectState("Alabama");
	}
	
//	@AfterClass
//	public static void close() {
//		driver.close();
//	}
}
