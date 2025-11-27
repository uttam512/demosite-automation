package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductPage;
import utils.DriverFactory;

public class ProductTest extends BaseTest {

    private LoginPage loginPage;
    private ProductPage productPage;

    @BeforeMethod
    public void setUp() {

        // 1. Create page objects
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);

        // 2. Open login page and perform login
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        // 3. Give yourself time to manually click OK on the popup
        try {
            Thread.sleep(5000);  // 5 seconds – adjust if you need more/less
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 4. Verify we reached products page (basic safety check)
        Assert.assertTrue(productPage.isOnProductsPage(),
                "Not on products page after login in ProductTest setup!");
    }

    @Test(description = "Add single product to cart and verify cart badge")
    public void addSingleProductToCartTest() {
        // Step 1: Add one specific product
        String productName = "Sauce Labs Backpack";
        productPage.addProductToCart(productName);
    	
    	//productPage.addBackpackToCart();

        // Step 2: Verify cart badge count is 1
        int cartCount = productPage.getCartBadgeCount();
        System.out.println("Cart badge count: " + cartCount);
        Assert.assertEquals(cartCount, 1, "Cart badge count should be 1 after adding one product.");
    }

}

