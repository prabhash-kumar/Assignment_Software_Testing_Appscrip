package prabhash.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends BasePage {

	@FindBy(css = "#full_name")
	private WebElement cardHolderName;

	@FindBy(id = "card_number")
	private WebElement paycardNumber;

	@FindBy(id = "cvv")
	private WebElement cardCVV;

	@FindBy(id = "month")
	private WebElement expiryMonth;

	@FindBy(id = "year")
	private WebElement expiryYear;

	@FindBy(id = "sumbitbutton")
	private WebElement addCard;

	@FindBy(id = "confirm_btn")
	private WebElement confirmOrderButton;

	@FindBy(css = "svg.close_icon")
	private WebElement exclusiveDealsCrossIcon;

	@FindBy(css = "button.button__link")
	private WebElement addNewPaymentCard;

	public PaymentPage(WebDriver driver) {
		super(driver);
	}

	public void addNewCard() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(addNewPaymentCard)).click();

	}

	public void enterCardDetails(String name, String cardNumber, String cvv, String month, String year) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(cardHolderName)).sendKeys(name);

		// driver.switchTo().frame(driver.findElement(By.id("spreedly-number-frame-7393")));
		wait.until(ExpectedConditions.visibilityOf(paycardNumber)).sendKeys(cardNumber);
		// driver.switchTo().frame(driver.findElement(By.id("cvv-form")));
		wait.until(ExpectedConditions.visibilityOf(cardCVV)).sendKeys(cvv);
		wait.until(ExpectedConditions.visibilityOf(expiryMonth)).sendKeys(month);
		wait.until(ExpectedConditions.visibilityOf(expiryYear)).sendKeys(year);
		wait.until(ExpectedConditions.elementToBeClickable(addCard)).click();

	}

	public void confirmOrder() {
		confirmOrderButton.click();
	}

	public void closeExclusiveDeals() {
		exclusiveDealsCrossIcon.click();
	}
}
