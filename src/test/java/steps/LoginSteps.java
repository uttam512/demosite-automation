package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductPage;

import static org.testng.Assert.assertTrue;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("I open the application")
    public void i_open_the_application() {
        loginPage = new LoginPage(Hooks.getDriver());
        loginPage.open();
    }

    @When("I login with valid credentials")
    public void i_login_with_valid_credentials() {
        loginPage.login("standard_user", "secret_sauce");
     // WAIT HERE so you can click "OK" on popup manually
        try {
            Thread.sleep(8000); // 8 seconds, adjust as needed
        } catch (InterruptedException e) {}
    }

    @Then("I should see the products page")
    public void i_should_see_the_products_page() {
        ProductPage productPage = new ProductPage(Hooks.getDriver());
        assertTrue(productPage.isOnProductsPage(), "Expected products page after login");
    }
}

