package prabhash.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage extends BasePage {

	@FindBy(xpath = "//div[@class='jsx-353953937 orderid']//span[@class='jsx-353953937']")
	private WebElement orderId;

	private WebDriverWait wait;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	public String getOrderId() {
		wait.until(ExpectedConditions.visibilityOf(orderId));
		return orderId.getText();
	}
}
