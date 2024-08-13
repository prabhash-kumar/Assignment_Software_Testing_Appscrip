package prabhash.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends BasePage {

	@FindBy(id = "full_name")
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

	private By cardNumberIframe = By.xpath("//iframe[contains(@src, 'number-frame')]");
	private By cvvIframe = By.xpath("//iframe[contains(@src, 'cvv-frame')]");

	private WebDriverWait wait;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	}

	public void addNewCard() {
		wait.until(ExpectedConditions.elementToBeClickable(addNewPaymentCard)).click();
	}

	public void enterCardDetails(String name, String cardNumber, String cvv, String month, String year) {

		wait.until(ExpectedConditions.visibilityOf(cardHolderName)).sendKeys(name);

		WebElement cardNumberIframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(cardNumberIframe));
		driver.switchTo().frame(cardNumberIframeElement);
		WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("card_number")));
		cardNumberField.sendKeys(cardNumber);

		driver.switchTo().defaultContent();

		WebElement cvvIframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(cvvIframe));
		driver.switchTo().frame(cvvIframeElement);
		WebElement cvvField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cvv")));
		cvvField.sendKeys(cvv);

		driver.switchTo().defaultContent();

		wait.until(ExpectedConditions.visibilityOf(expiryMonth)).sendKeys(month);
		wait.until(ExpectedConditions.visibilityOf(expiryYear)).sendKeys(year);

		wait.until(ExpectedConditions.elementToBeClickable(addCard)).click();
	}

	public void confirmOrder() {
		wait.until(ExpectedConditions.elementToBeClickable(confirmOrderButton)).click();
	}

	public void closeExclusiveDeals() {
		wait.until(ExpectedConditions.elementToBeClickable(exclusiveDealsCrossIcon)).click();
	}
}
