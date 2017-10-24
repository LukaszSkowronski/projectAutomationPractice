package pl.b2b.ProjectAutomationPractice;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utils {

	private WebDriver driver;

	@Before
	public void createBrowserInstanceNavigateToURL() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");
	}

	@After
	public void close() {
		driver.close();
	}
}
