package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductPage;
import pages.CartPage;
import utils.DriverFactory;

public class CartTest extends BaseTest {

    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeMethod
    public void setUp() {

        // 1. Create page objects
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);

        // 2. Open login page and perform login
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        // 3. (Optional) if popup appears, you can pause and click OK manually
        //    If needed, you can temporarily add a Thread.sleep here.
        try {
            Thread.sleep(5000);  // 5 seconds – adjust if you need more/less
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 4. Verify products page loaded
        Assert.assertTrue(productPage.isOnProductsPage(),
                "Not on products page after login in CartTest setup!");

        // 5. Add backpack to cart using generic method
        String productName = "Sauce Labs Backpack";
        productPage.addProductToCart(productName);

        // 6. Open cart page
        productPage.openCart();

        // 7. Verify we are on cart page
        Assert.assertTrue(cartPage.isOnCartPage(), "Not on cart page after clicking cart icon!");
    }

    @Test(description = "Verify backpack is present in cart with correct count")
    public void verifyBackpackInCartTest() {

        String expectedProduct = "Sauce Labs Backpack";

        // 1. Check backpack is present
        boolean isPresent = cartPage.isProductInCart(expectedProduct);
        Assert.assertTrue(isPresent, "Expected product not found in cart: " + expectedProduct);

        // 2. Check cart has exactly 1 item
        int itemCount = cartPage.getNumberOfItems();
        System.out.println("Number of items in cart: " + itemCount);
        Assert.assertEquals(itemCount, 1, "Cart should contain exactly 1 item.");

        // 3. (Optional) Check price or quantity
        String price = cartPage.getPriceForProduct(expectedProduct);
        String quantity = cartPage.getQuantityForProduct(expectedProduct);
        System.out.println("Product price in cart: " + price);
        System.out.println("Product quantity in cart: " + quantity);
    }

}
