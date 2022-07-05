package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public ShoppingCartPage() {
        super();
    }

    public CheckOutStepOnePage proceedToCheckout() {
        checkoutButton.click();
        return new CheckOutStepOnePage();
    }
}
