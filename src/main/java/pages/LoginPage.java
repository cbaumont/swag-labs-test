package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginField;

    public LoginPage() {
        super();
    }

    public ProductsPage loginAs(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginField.click();
        return new ProductsPage();
    }
}
