package prabhash.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    @FindBy(id = "profileDropdown")
    private WebElement profileDropdown;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        profileDropdown.click();
        logoutButton.click();
    }
}
