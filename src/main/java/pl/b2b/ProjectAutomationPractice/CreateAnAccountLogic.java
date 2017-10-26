package pl.b2b.ProjectAutomationPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccountLogic {

	public static boolean verifyRegisterButtonIsVisible(WebDriver driver) {
		WebElement registerButton = driver.findElement(By.id("submitAccount"));
		return registerButton.isEnabled();
	}

	public static String selectGenderRadioButton(String genderNumber, WebDriver driver) {
		Utils.waitForElementVisible("id_gender1", driver);
		List<WebElement> genderList = driver.findElements(By.name("id_gender"));
		for (WebElement radioText : genderList) {
			if (radioText.getAttribute("id").endsWith(genderNumber)) {
				WebElement mr = driver.findElement(By.id("id_gender1"));
				mr.click();
				mr.isSelected();
			}
			if (radioText.getAttribute("id").endsWith(genderNumber)) {
				WebElement mrs = driver.findElement(By.id("id_gender2"));
				mrs.click();
				mrs.isSelected();
			} else {
				System.out.println("Provided button not displayed!");
			}
		}
		return genderNumber;
	}

	public static void enterFirstName(String firstName, WebDriver driver) {
		WebElement fieldFirstName = driver.findElement(By.id("customer_firstname"));
		fieldFirstName.clear();
		fieldFirstName.sendKeys(firstName);
	}

	public static void enterLastName(String firstName, WebDriver driver) {
		WebElement fieldLastName = driver.findElement(By.id("customer_lastname"));
		fieldLastName.clear();
		fieldLastName.sendKeys(firstName);
	}

	public static void enterPassword(String firstName, WebDriver driver) {
		WebElement fieldPassword = driver.findElement(By.id("passwd"));
		fieldPassword.clear();
		fieldPassword.sendKeys(firstName);
	}

	public static void selectDOB (String DOB, WebDriver driver) { // DD/MM/YYYY format of DOB
		try{
			int dayDOB = Integer.parseInt(DOB.substring(0,2));
			int monthDOB = Integer.parseInt(DOB.substring(3,5));
			int yearDOB = Integer.parseInt(DOB.substring(6,10));
			if(dayDOB > 0 && dayDOB <32) {
				WebElement dayOfBirth = driver.findElement(By.id("days"));
				Select d = new Select (dayOfBirth);
				String dayDOBString = String.valueOf(dayDOB);
				d.selectByValue(dayDOBString);
			}
			if(monthDOB > 0 && monthDOB <13) {
				WebElement monthOfBirth = driver.findElement(By.id("months"));
				Select m = new Select (monthOfBirth);
				String monthDOBString = String.valueOf(monthDOB);
				m.selectByValue(monthDOBString);
			}
			if(yearDOB > 1899 && yearDOB <2017) {
				WebElement yearOfBirth = driver.findElement(By.id("years"));
				Select y = new Select (yearOfBirth);
				String yearDOBString = String.valueOf(yearDOB);
				y.selectByValue(yearDOBString);
			}
		}catch(NumberFormatException nfe) {
			System.out.println("Day of birth not provided or incorrect!");
		}catch(StringIndexOutOfBoundsException sioobe) {
			System.out.println("Day of birth not provided or incorrect!");
			}
			
		}
	
	public static void enterFirstNameAddress(String firstNameAddress, WebDriver driver) {
		WebElement fieldPassword = driver.findElement(By.id("firstname"));
		fieldPassword.clear();
		fieldPassword.sendKeys(firstNameAddress);
	}
	
	public static void enterLastNameAddress(String lastNameAddress, WebDriver driver) {
		WebElement fieldPassword = driver.findElement(By.id("lastname"));
		fieldPassword.clear();
		fieldPassword.sendKeys(lastNameAddress);
	}
	
	public static void enterCompany(String company, WebDriver driver) {
		WebElement fieldPassword = driver.findElement(By.id("company"));
		fieldPassword.clear();
		fieldPassword.sendKeys(company);
	}
	
	public static void enterAddressLine1(String addressLine1, WebDriver driver) {
		WebElement fieldPassword = driver.findElement(By.id("address1"));
		fieldPassword.clear();
		fieldPassword.sendKeys(addressLine1);
	}
	
	public static void enterAddressLine2(String addressLine2, WebDriver driver) {
		WebElement fieldPassword = driver.findElement(By.id("address2"));
		fieldPassword.clear();
		fieldPassword.sendKeys(addressLine2);
	}
	
	public static void enterCity(String city, WebDriver driver) {
		WebElement fieldPassword = driver.findElement(By.id("city"));
		fieldPassword.clear();
		fieldPassword.sendKeys(city);
	}
	
	public static void selectState(String state, WebDriver driver) {
		WebElement stateDropdown = driver.findElement(By.id("id_state"));
		Select s = new Select (stateDropdown);
		s.selectByVisibleText(state);
	}
			
	}
