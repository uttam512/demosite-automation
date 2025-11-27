package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Open the application URL
    public void open() {
        driver.get("https://www.saucedemo.com/");
        DriverFactory.slowDown();
    }

    // Enter username into the input field
    public void enterUsername(String username) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        el.clear();
        el.sendKeys(username);
        DriverFactory.slowDown();
    }

    // Enter password into the input field
    public void enterPassword(String password) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        el.clear();
        el.sendKeys(password);
        DriverFactory.slowDown();
    }

    // Click the login button
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        DriverFactory.slowDown();
    }

    // Convenience high-level method for tests
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // Returns true if the login error message is visible (for negative tests)
    public boolean isErrorVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Simple check to confirm we reached the products page
    public boolean isProductsPage() {
        try {
            wait.until(ExpectedConditions.urlContains("/inventory"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

