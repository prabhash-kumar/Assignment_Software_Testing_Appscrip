package prabhash.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage extends BasePage {

	@FindBy(css = "button.jsx-4ee11fac50694d5a")
	private WebElement profileBox;

	@FindBy(xpath = "//*[text()='Logout']")
	private WebElement logoutButton;

	@FindBy(css="button.logoutBtn")
	private WebElement logoutConformation;
	
	private WebDriverWait wait;

	public LogoutPage(WebDriver driver) {
		super(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	public void goToProfile() {
		profileBox.click();
	}

	public void logoutProfile() {
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
		wait.until(ExpectedConditions.elementToBeClickable(logoutConformation)).click();

	}

}
