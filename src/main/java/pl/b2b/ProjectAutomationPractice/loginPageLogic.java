package pl.b2b.ProjectAutomationPractice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPageLogic {

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "passwd")
	private WebElement password;

	@FindBy(id = "email_create")
	private WebElement emailCreate;

	@FindBy(xpath = "//*[@id='center_column']/div[1]")
	private WebElement incorretLoginDetailsMessage;

	@FindBy(id = "create_account_error")
	private WebElement incorrectEmailMessageAccountCreation;

	@FindBy(xpath = "//*[@id='SubmitLogin']")
	private WebElement buttonSignInAfterProvidingLoginDetails;

	@FindBy(xpath = "//*[@id='SubmitCreate']/span")
	private WebElement buttonCreateAnAccount;

	public void enterEmail(String email) {
		this.email.sendKeys(email);
	}

	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}

	public void enterEmailCreateAnAccount(String email) {
		this.emailCreate.sendKeys(email);
	}

	public String getIncorretLoginDetailsMessage() {
		return this.incorretLoginDetailsMessage.getText().trim();
	}

	public String getIncorrectEmailMessageAccountCreation() throws InterruptedException {
		Thread.sleep(1000);
		return this.incorrectEmailMessageAccountCreation.getText().trim();
	}

	public void clickButtonSignInAfterProvidingLoginDetails() {
		this.buttonSignInAfterProvidingLoginDetails.click();
	}

	public void clickButtonCreateAnAccount() throws InterruptedException {
		this.buttonCreateAnAccount.click();
		Thread.sleep(3000);
	}

}
