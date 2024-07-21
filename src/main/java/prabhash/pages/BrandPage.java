package prabhash.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrandPage extends BasePage {

	@FindBy(xpath = "//*[text()='Brands']")
	private WebElement brandSelect;
	@FindBy(css = "a[href='/store/Emani/652ec33ad12e5c37a1839ea2'][target='_self'].jsx-2446998146")
	private WebElement emaniBrand;

	public BrandPage(WebDriver driver) {
		super(driver);
	}

	public void navigateToEmaniBrand() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(brandSelect)).click();
		wait.until(ExpectedConditions.elementToBeClickable(emaniBrand)).click();

	}
}
