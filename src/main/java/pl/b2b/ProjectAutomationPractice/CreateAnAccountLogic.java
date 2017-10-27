package pl.b2b.ProjectAutomationPractice;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccountLogic extends Methods{

	@FindBy(id = "submitAccount")
	private WebElement buttonRegister;

	@FindBy(id = "customer_firstname")
	private WebElement firstName;

	@FindBy(id = "customer_lastname")
	private WebElement lastName;

	@FindBy(id = "passwd")
	private WebElement password;
	
	@FindBy(id = "firstname")
	private WebElement firstNameAddress;
	
	@FindBy(id = "lastname")
	private WebElement lastNameAddress;
	
	@FindBy(id = "company")
	private WebElement company;
	
	@FindBy(id = "address1")
	private WebElement addressLine1;
	
	@FindBy(id = "address2")
	private WebElement addressLine2;
	
	@FindBy(id = "city")
	private WebElement city;
	
	@FindBy(id = "id_state")
	private WebElement stateDropdown;
	
	@FindBy(name = "id_gender")
	private List<WebElement> genderPanel;
	
	@FindBy(id = "id_gender1")
	private WebElement genderMr;
	
	@FindBy(id = "id_gender2")
	private WebElement genderMrs;
	
	@FindBy(id = "days")
	private WebElement dobDays;
	
	@FindBy(id = "months")
	private WebElement dobMonths;
	
	@FindBy(id = "years")
	private WebElement dobYears;
	
	@FindBy(id = "postcode")
	private WebElement postcode;
	
	@FindBy(id = "id_country")
	private WebElement countryDropdown;
	
	@FindBy(id = "other")
	private WebElement additionalInformation;
	
	@FindBy(id = "phone")
	private WebElement homePhone;
	
	@FindBy(id = "phone_mobile")
	private WebElement mobilePhone;
	
	@FindBy(id = "alias")
	private WebElement addressAlias;

	public boolean verifyRegisterButtonIsVisible() {
		return this.buttonRegister.isEnabled();
	}

	public void enterFirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}

	public void enterLastName(String firstName) {
		this.lastName.clear();
		this.lastName.sendKeys(firstName);
	}

	public void enterPassword(String firstName) {
		this.password.clear();
		this.password.sendKeys(firstName);
	}

	public void enterFirstNameAddress(String firstNameAddress) {
		this.firstNameAddress.clear();
		this.firstNameAddress.sendKeys(firstNameAddress);
	}

	public void enterLastNameAddress(String lastNameAddress) {
		this.lastNameAddress.clear();
		this.lastNameAddress.sendKeys(lastNameAddress);
	}

	public void enterCompany(String company) {
		this.company.clear();
		this.company.sendKeys(company);
	}

	public void enterAddressLine1(String addressLine1) {
		this.addressLine1.clear();
		this.addressLine1.sendKeys(addressLine1);
	}

	public void enterAddressLine2(String addressLine2) {
		this.addressLine2.clear();
		this.addressLine2.sendKeys(addressLine2);
	}

	public void enterCity(String city) {
		this.city.clear();
		this.city.sendKeys(city);
	}

	public void selectState(String state) {
		Select s = new Select(stateDropdown);
		s.selectByVisibleText(state);
	}
	
	public void enterPostcode(String postcode) {
		this.postcode.clear();
		this.postcode.sendKeys(postcode);
	}
	
	public void selectCountry(String country) {
		Select s = new Select(countryDropdown);
				s.deselectByVisibleText(country);
	}
	
	public void enterAdditionalInformation(String addInfo) {
		this.additionalInformation.clear();
		this.additionalInformation.sendKeys(addInfo);
	}
	
	public void enterHomePhone(String homePhone) {
		this.homePhone.clear();
		this.homePhone.sendKeys(homePhone);
	}
	
	public void enterMobilePhone(String mobilePhone) {
		this.mobilePhone.clear();
		this.mobilePhone.sendKeys(mobilePhone);
	}
	
	public void enterAddressAlias(String addressAlias) {
		this.addressAlias.clear();
		this.addressAlias.sendKeys(addressAlias);
	}

	public String selectGenderRadioButton(String genderNumber) {
//		Methods.waitForElementVisible(genderMr);
		for (WebElement radioText : genderPanel) {
			if (radioText.getAttribute("id").endsWith(genderNumber)) {
				genderMr.click();
				genderMr.isSelected();
			}
			if (radioText.getAttribute("id").endsWith(genderNumber)) {
				genderMrs.click();
				genderMrs.isSelected();
			} else {
				System.out.println("Provided button not displayed!");
			}
		}
		return genderNumber;
	}

	public void selectDOB(String DOB) { // DD/MM/YYYY format of DOB
		try {
			int dayDOB = Integer.parseInt(DOB.substring(0, 2));
			int monthDOB = Integer.parseInt(DOB.substring(3, 5));
			int yearDOB = Integer.parseInt(DOB.substring(6, 10));
			if (dayDOB > 0 && dayDOB < 32) {
				Select d = new Select(dobDays);
				String dayDOBString = String.valueOf(dayDOB);
				d.selectByValue(dayDOBString);
			}
			if (monthDOB > 0 && monthDOB < 13) {
				Select m = new Select(dobMonths);
				String monthDOBString = String.valueOf(monthDOB);
				m.selectByValue(monthDOBString);
			}
			if (yearDOB > 1899 && yearDOB < 2017) {
				Select y = new Select(dobYears);
				String yearDOBString = String.valueOf(yearDOB);
				y.selectByValue(yearDOBString);
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Day of birth not provided or incorrect!");
		} catch (StringIndexOutOfBoundsException sioobe) {
			System.out.println("Day of birth not provided or incorrect!");
		}

	}
}
