package prabhash.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	@FindBy(xpath = "//span[text()='Log In To Get Free Talents']")
	private WebElement forlogin;

	@FindBy(css = "span.jsx-3199853284")
	private WebElement signUpButton;

	@FindBy(id = "regPhoneInput")
	private WebElement mobile_Number;

	@FindBy(css = "input[type='checkbox'][class='jsx-2520378272']")
	private WebElement termsCheckbox;

	@FindBy(xpath = "//span[@class='MuiButton-label']")
	private WebElement continueButton;

	@FindBy(id = "otpField")
	private WebElement otpField;

	@FindBy(name = "firstName")
	private WebElement firstNameField;

	@FindBy(name = "lastName")
	private WebElement lastNameField;

	@FindBy(name = "email")
	private WebElement emailField;

	@FindBy(xpath = "//span[@class='MuiButton-label']")
	private WebElement doneButton;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void signUp(String phone, String firstName, String lastName, String email, String otp)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(forlogin)).click();
		wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
		wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox)).click();
		wait.until(ExpectedConditions.visibilityOf(mobile_Number)).sendKeys(phone);
		wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();

		for (int i = 0; i < otp.length(); i++) {

			WebElement otpDigitField = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//input[contains(@aria-label, 'Digit " + (i + 1) + "')]")));
			otpDigitField.sendKeys(String.valueOf(otp.charAt(i)));
		}
		wait.until(ExpectedConditions.elementToBeClickable(firstNameField)).sendKeys(firstName);
		wait.until(ExpectedConditions.elementToBeClickable(lastNameField)).sendKeys(lastName);

		wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(email);

		wait.until(ExpectedConditions.elementToBeClickable(doneButton)).click();

	}

}
