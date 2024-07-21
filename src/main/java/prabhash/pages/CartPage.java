package prabhash.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

	@FindBy(xpath = "//a[@href=\"/cart\"]")
	private WebElement cartIcon;
	@FindBy(xpath = "//*[text()='Apple iPhone 13 (128GB) DarkRed']")
	private WebElement productInCart;

	@FindBy(css = ".total_price.ml-auto")
	private WebElement productPrice;

	@FindBy(xpath = "//a[@href='/shipping-address']")
	private WebElement checkoutButton;

	public CartPage(WebDriver driver) {
		super(driver);
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void clickOnCartIcon() {
		cartIcon.click();
	}

	public boolean isProductDisplayedInCart() {
		wait.until(ExpectedConditions.visibilityOf(productInCart));

		//System.out.println(productInCart.isDisplayed());
		return productInCart.isDisplayed();
	}

	public boolean isProductPriceCorrect(String expectedPrice) {
		wait.until(ExpectedConditions.visibilityOf(productPrice));

		//System.out.println(productPrice.getText().substring(1));
		return productPrice.getText().substring(1).equals(expectedPrice);
	}

	public void proceedToCheckout() {
		checkoutButton.click();
	}
}
