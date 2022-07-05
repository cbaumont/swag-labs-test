package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutStepTwoPage extends BasePage {

    @FindBy(css = ".cart_quantity")
    WebElement carQuantity;

    @FindBy(css = ".inventory_item_name")
    WebElement itemCartName;

    public CheckOutStepTwoPage() {
        super();
    }

    public int getCartItemsQuantity() {
        return Integer.parseInt(carQuantity.getText());
    }

    public String getCartItemName() {
        return itemCartName.getText();
    }
}
