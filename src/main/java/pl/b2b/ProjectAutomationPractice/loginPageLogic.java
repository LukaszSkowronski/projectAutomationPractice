package pl.b2b.ProjectAutomationPractice;

import org.openqa.selenium.WebDriver;
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

	public void enterEmail(String email, WebDriver driver) {
		this.email.sendKeys(email);
	}

	public void enterPassword(String password, WebDriver driver) {
		this.password.sendKeys(password);
	}

	public void enterEmailCreateAnAccount(String email, WebDriver driver) {
		this.emailCreate.sendKeys(email);
	}

	public String getIncorretLoginDetailsMessage(WebDriver driver) {
		return this.incorretLoginDetailsMessage.getText().trim();
	}

	public String getIncorrectEmailMessageAccountCreation(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		return this.incorrectEmailMessageAccountCreation.getText().trim();
	}

	public void clickButtonSignInAfterProvidingLoginDetails(WebDriver driver) {
		this.buttonSignInAfterProvidingLoginDetails.click();
	}

	public void clickButtonCreateAnAccount(WebDriver driver) {
		this.buttonCreateAnAccount.click();
	}

}
