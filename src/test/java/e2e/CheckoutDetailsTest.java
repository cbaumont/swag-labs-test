package e2e;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;
import static utils.CustomerData.*;

public class CheckoutDetailsTest extends BaseTest {

    @Test
    public void shouldValidateCheckoutDetails() {
        LoginPage loginPage = new LoginPage();
        ProductsPage productsPage = loginPage.loginAs(username, password);

        String expectedProductName = productsPage
                .orderProductsBy(OrderType.PRICE_LOW_TO_HIGH)
                .getProductName();

        ShoppingCartPage shoppingCartPage = productsPage
                .addProductToCart()
                .goToShoppingCart();

        CheckOutStepTwoPage checkOutStepTwoPage = shoppingCartPage
                .proceedToCheckout()
                .typeFirstName(getFirstName())
                .typeLastName(getLastName())
                .typePostalCode(getPostalCode())
                .continueWithCheckout();

        String actualProductName = checkOutStepTwoPage.getCartItemName();

        assertEquals(actualProductName, expectedProductName);
    }
}
