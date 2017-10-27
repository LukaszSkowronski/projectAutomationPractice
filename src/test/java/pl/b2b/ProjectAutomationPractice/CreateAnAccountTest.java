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
		driver.manage().window().maximize();
	}
	
	@Test
	public void successfulCreateAnAccount() throws InterruptedException {
		Methods.verifyUserLoggedOffIfNotClickSignOut(driver);
		defaultPageLogic.clickButtonSignIn(driver);
		loginPageLogic.enterEmailCreateAnAccount("test@testt.pl", driver);
		loginPageLogic.clickButtonCreateAnAccount(driver);
		CreateAnAccountLogic.selectGenderRadioButton("2", driver); // "1" - Mr, "2" - Mrs
		CreateAnAccountLogic.enterFirstName("Lukasz", driver);
		CreateAnAccountLogic.selectDOB("11/11/1995", driver);
		CreateAnAccountLogic.selectState("Alabama", driver);
	}
	
//	@AfterClass
//	public static void close() {
//		driver.close();
//	}
}
