package pl.b2b.ProjectAutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class Utils {

	private static WebDriver driver;

//	public static void verifyUserLoggedOffIfNotClickSignOut() {
//
//		WebElement signInButton = driver.findElement(By.className("login"));
//		String loginStatus = signInButton.getText().toString().trim();
//		if (loginStatus == "Sign in") {
//			WebElement signOut = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a"));
//			signOut.click();
//		}
//	}
	
	public static void verifyUserLoggedOffIfNotClickSignOut(){
		try {
			WebElement signInButton = driver.findElement(By.className("login"));
			String loginStatus = signInButton.getText().toString().trim();
			if (loginStatus == "Sign in") {
			WebElement signOut = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a"));
			signOut.click();
			}
		}catch (WebDriverException e) {
			System.out.println("User not Logged!");
		}catch (NullPointerException e) {
			System.out.println("User not Logged!");
		}
	}
}
