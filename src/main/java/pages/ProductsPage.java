package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage {

    @FindBy(css = ".product_sort_container")
    WebElement productSortType;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addToCartButton;

    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCartLink;

    @FindBy(id = "item_1_title_link")
    WebElement productLink;

    public ProductsPage() {
        super();
    }

    public ProductsPage orderProductsBy(OrderType orderType) {
        new Select(productSortType).selectByValue(orderType.getValue());
        return this;
    }

    public ProductsPage addProductToCart() {
        addToCartButton.click();
        return this;
    }

    public ShoppingCartPage goToShoppingCart() {
        shoppingCartLink.click();
        return new ShoppingCartPage();
    }

    public String getProductName() {
        WebElement itemName = productLink.findElement(By.xpath("./child::*"));
        return itemName.getText();
    }
}
