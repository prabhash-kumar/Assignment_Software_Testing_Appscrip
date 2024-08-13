package prabhash.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PDPPage extends BasePage {

	@FindBy(css = "div.timeline")
	private WebElement quantityField;

	@FindBy(css = "button.add_to_cart_btn")
	private WebElement addToCartButton;

	@FindBy(css = "span.product_count")
	private WebElement cartCount;
	private WebDriverWait wait;

	public PDPPage(WebDriver driver) {
		super(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public void changeQuantity(String quantity) {

		quantityField.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-value='" + quantity + "']")))
				.click();
		System.out.println("Quantity is " + quantityField.getText());
	}

	public void addToCart() {
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
		button.click();
	}

	public boolean isCartCountUpdated(String expectedCount) throws InterruptedException {
		WebElement updatedCartCount = wait.until(ExpectedConditions.visibilityOf(cartCount));
		Thread.sleep(6000);
		System.out.println(updatedCartCount.getText());

		return updatedCartCount.getText().equals(expectedCount);
	}
}