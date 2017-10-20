package pl.b2b.ProjectAutomationPractice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(id = "email")
	private WebElement fieldEmailLogin;

	@FindBy(id = "passwd")
	private WebElement fieldPassword;

	@FindBy(xpath = "//*[@id=\\\"SubmitLogin\\\"]/span")
	private WebElement buttonSignInAfterEnteringLoginDetails;

	@FindBy(xpath = "//*[@id=\\\"searchbox\\\"]/button")
	private WebElement buttonSearchMagnifyingGlass;

	@FindBy(xpath = "//*[@id=\\\"center_column\\\"]/p")
	private WebElement messageSuccessfulLogin;

	@FindBy(xpath = "//*[@id=\\\"center_column\\\"]/div[1]")
	private WebElement warningIncorrectLoginDetails;



	public String enterEmail(String email) {
		this.fieldEmailLogin.sendKeys(email);
		return email;
	}

	public String enterPassword(String password) {
		this.fieldPassword.sendKeys(password);
		return password;
	}

	public void clickButtonSignInAfterEnteringLoginDetails() {
		this.buttonSignInAfterEnteringLoginDetails.click();
	}

//	public void clickButtonSearchMagnifyingGlass() {
//		this.buttonSearchMagnifyingGlass.click();
//	}

	public String getMessageSuccessfulLogin() {
		return this.messageSuccessfulLogin.getText().trim();
	}

	public String getWarningIncorrectLoginDetails() {
		return this.warningIncorrectLoginDetails.getText().trim();
	}

}
