package pages;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    protected WebDriverWait wait;

    BasePage() {
        PageFactory.initElements(BaseTest.getDriver(), this);
        wait = new WebDriverWait(BaseTest.getDriver(), 10);
    }

    void waitForElementsToLoad(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    void waitForSingleElementToLoad(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    void waitForSingleElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
