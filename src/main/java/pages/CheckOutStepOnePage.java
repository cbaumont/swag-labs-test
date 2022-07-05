package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutStepOnePage extends BasePage {

    @FindBy(id = "first-name")
    WebElement firstNameField;

    @FindBy(id = "last-name")
    WebElement lastNameField;

    @FindBy(id = "postal-code")
    WebElement postalCodeField;

    @FindBy(id = "continue")
    WebElement continueButton;

    public CheckOutStepOnePage() {
        super();
    }

    public CheckOutStepOnePage typeFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    public CheckOutStepOnePage typeLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public CheckOutStepOnePage typePostalCode(String postalCode) {
        postalCodeField.sendKeys(postalCode);
        return this;
    }

    public CheckOutStepTwoPage continueWithCheckout() {
        continueButton.click();
        return new CheckOutStepTwoPage();
    }
}
