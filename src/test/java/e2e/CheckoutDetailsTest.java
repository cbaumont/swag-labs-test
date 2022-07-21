package e2e;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
                .typeFirstName(customerData.getFirstName())
                .typeLastName(customerData.getLastName())
                .typePostalCode(customerData.getPostalCode())
                .continueWithCheckout();

        String actualProductName = checkOutStepTwoPage.getCartItemName();

        float actualTotalPrice = checkOutStepTwoPage.getTotalPrice();
        float cartItemPrice = checkOutStepTwoPage.getCartItemPrice();
        float cartItemsQuantity = checkOutStepTwoPage.getCartItemsQuantity();
        float taxPrice = checkOutStepTwoPage.getTaxPrice();

        List<String> actualSummaryInformation = checkOutStepTwoPage.getSummaryInformation();
        List<String> expectedSummaryInformation = Arrays.asList("SauceCard #31337", "FREE PONY EXPRESS DELIVERY!");

        assertEquals(actualProductName, expectedProductName);
        assertEquals(actualTotalPrice, cartItemPrice * cartItemsQuantity + taxPrice);
        assertTrue(actualSummaryInformation.containsAll(expectedSummaryInformation));
        assertTrue(checkOutStepTwoPage.isFinishButtonPresent());
    }
}
