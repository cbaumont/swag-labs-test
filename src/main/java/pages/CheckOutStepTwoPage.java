package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CheckOutStepTwoPage extends BasePage {

    @FindBy(css = ".cart_quantity")
    WebElement carQuantity;

    @FindBy(css = ".inventory_item_name")
    WebElement itemCartName;

    @FindBy(css = ".inventory_item_price")
    WebElement itemPrice;

    @FindBy(css = ".summary_tax_label")
    WebElement taxPrice;

    @FindBy(css = ".summary_total_label")
    WebElement totalPrice;

    @FindBy(css = ".summary_value_label")
    List<WebElement> summaryInformation;

    @FindBy(id = "finish")
    WebElement finishButton;

    public CheckOutStepTwoPage() {
        super();
    }

    public int getCartItemsQuantity() {
        return Integer.parseInt(carQuantity.getText());
    }

    public String getCartItemName() {
        return itemCartName.getText();
    }

    public float getCartItemPrice() {
        return Float.parseFloat(itemPrice.getText().replace("$", ""));
    }

    public float getTaxPrice() {
        return Float.parseFloat(taxPrice.getText().replace("Tax: $", ""));
    }

    public float getTotalPrice() {
        return Float.parseFloat(totalPrice.getText().replace("Total: $", ""));
    }

    public List<String> getSummaryInformation() {
        List<String> summaryTexts = new ArrayList<>();
        summaryInformation.forEach(summary -> summaryTexts.add(summary.getText()));
        return summaryTexts;
    }

    public boolean isFinishButtonPresent() {
        return finishButton.isDisplayed();
    }
}
