package prabhash.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BasePage {

    @FindBy(xpath = "//div[@class='order-id']")
    private WebElement orderId;

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public String getOrderId() {
        return orderId.getText();
    }
}
