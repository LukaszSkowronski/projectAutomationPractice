package pl.b2b.ProjectAutomationPractice;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAnAccountTest {
	
	public static WebDriver driver;
	
	
	@BeforeClass
	public static void createBrowserInstanceNavigateToURL() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
	}
	
	@Test
	public void successfulCreateAnAccount() throws InterruptedException {
		Utils.verifyUserLoggedOffIfNotClickSignOut(driver);
		DefaultPageLogic.clickButtonSignIn(driver);
		LoginPageLogic.enterEmailCreateAnAccount("test@testt.pl", driver);
		LoginPageLogic.clickButtonCreateAnAccount(driver);
		CreateAnAccountLogic.selectGenderRadioButton("2", driver); // "1" - Mr, "2" - Mrs
		CreateAnAccountLogic.enterFirstName("Lukasz", driver);
		CreateAnAccountLogic.enterDOB("11/11/1995", driver);
	}
	
//	@AfterClass
//	public static void close() {
//		driver.close();
//	}
}
