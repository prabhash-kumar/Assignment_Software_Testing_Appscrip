package prabhash.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends BasePage {

	@FindBy(css = "#full_name")
	private WebElement cardHolderName;

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

	private By cardNumberIframe = By.id("spreedly-number-frame-1057");
	private By cvvIframe = By.id("spreedly-cvv-frame-1057");

	public PaymentPage(WebDriver driver) {
		super(driver);
	}

	public void addNewCard() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(addNewPaymentCard)).click();
		Thread.sleep(1000);
	}

	public void enterCardDetails(String name, String cardNumber, String cvv, String month, String year) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(cardHolderName)).sendKeys(name);

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(cardNumberIframe));
		WebElement paycardNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("card_number")));
		paycardNumber.sendKeys(cardNumber);

		driver.switchTo().defaultContent();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(cvvIframe));
		WebElement cardCVV = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cvv")));
		cardCVV.sendKeys(cvv);
		driver.switchTo().defaultContent();

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
