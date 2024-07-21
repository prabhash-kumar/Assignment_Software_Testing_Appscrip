package prabhash.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {

	@FindBy(name = "firstName")
	private WebElement firstNameField;

	@FindBy(name = "lastName")
	private WebElement lastNameField;

	@FindBy(id = "regPhoneInput")
	private WebElement phoneNumberField;

	@FindBy(name = "email")
	private WebElement emailField;

	@FindBy(name = "addLine1")
	private WebElement addressField;

	@FindBy(name = "pincode")
	private WebElement zipCodeField;

	@FindBy(id = "continue_btn")
	private WebElement continueButton;

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public void fillShippingDetails(String firstName, String lastName, String phoneNumber, String email, String address,
			String zipCode) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys(firstName);
		wait.until(ExpectedConditions.visibilityOf(lastNameField)).sendKeys(lastName);
		wait.until(ExpectedConditions.visibilityOf(phoneNumberField)).sendKeys(phoneNumber);
		// wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
		wait.until(ExpectedConditions.visibilityOf(addressField)).sendKeys(address);
		wait.until(ExpectedConditions.visibilityOf(zipCodeField)).sendKeys(zipCode);
		wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();

	}
}
