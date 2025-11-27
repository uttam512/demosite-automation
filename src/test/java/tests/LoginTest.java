package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.DriverFactory;
import org.openqa.selenium.WebDriver;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

     @Test(description = "Valid login should navigate to products page")
    public void validLoginTest() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isProductsPage(), "Expected to be on products page after valid login");
    }

    @Test(dataProvider = "invalidCreds", description = "Invalid login attempts show error")
    public void invalidLoginTest(String user, String pass) {
        loginPage.login(user, pass);
        Assert.assertTrue(loginPage.isErrorVisible(), "Expected error message for invalid login");
    }

    @DataProvider(name = "invalidCreds")
    public Object[][] invalidCreds() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce"},
                {"standard_user", "wrong_password"},
                {"", "secret_sauce"},
                {"standard_user", ""}
        };
    } 

    
}

