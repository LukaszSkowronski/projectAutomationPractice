package pl.b2b.ProjectAutomationPractice;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AutomationPracticeTest extends Utils {

	LoginPage LoginPage = new LoginPage();
	DefaultPage DefaultPage = new DefaultPage();

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

}
