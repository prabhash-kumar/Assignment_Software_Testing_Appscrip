package prabhash.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PDPPage extends BasePage {

	@FindBy(xpath = "//*[contains(@name,'one-time-purchase')]")
	private WebElement quantityField;

	@FindBy(css = "button.add_to_cart_btn")
	private WebElement addToCartButton;

	@FindBy(css = "span.product_count")
	private WebElement cartCount;

	public PDPPage(WebDriver driver) {
		super(driver);
	}

	public void changeQuantity(String quantity) {

		Select quantityChange = new Select(quantityField);
		quantityChange.selectByValue(quantity);
	}

	public void addToCart() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
		
		Thread.sleep(1000);
	}

	public boolean isCartCountUpdated(String expectedCount) {
		// System.out.println(cartCount.getText());
		return cartCount.getText().equals(expectedCount);
	}
}
