package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;

import static org.testng.Assert.*;

public class ProductCartSteps {

    private ProductPage productPage;
    private CartPage cartPage;

    @Given("I am logged in as a standard user")
    public void i_am_logged_in_as_a_standard_user() {
        LoginPage loginPage = new LoginPage(Hooks.getDriver());
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        // WAIT HERE so you can click "OK" on popup manually
        try {
            Thread.sleep(8000); // 8 seconds, adjust as needed
        } catch (InterruptedException e) {}

        productPage = new ProductPage(Hooks.getDriver());
        assertTrue(productPage.isOnProductsPage(), "Login failed in Given step");
    }


   // @When("I add {string} to the cart")
   // public void i_add_to_the_cart(String productName) {
     //   productPage.addProductToCart(productName);
  //  }
    @When("I add {string} to the cart")
    public void i_add_to_the_cart(String productName) {
        productPage.addProductToCart(productName);

        // quick check: wait for cart badge to show up (indicates the add succeeded)
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shopping_cart_badge")));
        } catch (Exception e) {
            // badge didn't appear — we'll still proceed to openCart and checks, but log for debug
            System.out.println("DEBUG: cart badge did not appear after adding product.");
        }
    }


    @And("I open the cart")
    public void i_open_the_cart() {
        productPage.openCart();
        cartPage = new CartPage(Hooks.getDriver());

        // Wait until cart page is loaded (title "Your Cart") OR cart items container appears
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(15));
        wait.until(driver -> cartPage.isOnCartPage() || !cartPage.getItemNames().isEmpty());
    }

    @Then("the cart should contain {string}")
    public void the_cart_should_contain(String productName) {
        assertTrue(cartPage.isProductInCart(productName),
                "Expected product not found in cart: " + productName);
    }

    @Then("the cart should contain {int} item")
    public void the_cart_should_contain_item(Integer expectedCount) {
        int actual = cartPage.getNumberOfItems();
        assertEquals(actual, expectedCount.intValue(), "Cart item count mismatch");
    }
}

