	package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for cart page
    private By cartTitle = By.className("title");              // "Your Cart"
    private By cartItems = By.className("cart_item");          // Each item row in cart
    private By cartItemName = By.className("inventory_item_name");
    private By cartItemPrice = By.className("inventory_item_price");
    private By cartQuantity = By.className("cart_quantity");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Confirm we are actually on the cart page
    public boolean isOnCartPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cartTitle));
            String titleText = driver.findElement(cartTitle).getText().trim();
            return titleText.equalsIgnoreCase("Your Cart");
        } catch (Exception e) {
            return false;
        }
    }

    // How many cart_item rows are there?
    public int getNumberOfItems() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(cartItems));
            List<WebElement> items = driver.findElements(cartItems);
            return items.size();
        } catch (Exception e) {
            return 0;
        }
    }

    // Get list of all product names in the cart
    public List<String> getItemNames() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(cartItems));
            List<WebElement> items = driver.findElements(cartItems);
            List<String> names = new ArrayList<>();
            for (WebElement item : items) {
                names.add(item.findElement(cartItemName).getText().trim());
            }
            return names;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }


    // Check if a specific product is present in the cart by name
    public boolean isProductInCart(String productName) {
        List<String> names = getItemNames();
        for (String name : names) {
            if (name.equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    // (Optional) Get price of a specific product as String
    public String getPriceForProduct(String productName) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(cartItems));
            List<WebElement> items = driver.findElements(cartItems);
            for (WebElement item : items) {
                String name = item.findElement(cartItemName).getText().trim();
                if (name.equalsIgnoreCase(productName)) {
                    return item.findElement(cartItemPrice).getText().trim();
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
       

    // (Optional) Get quantity of a specific product
    public String getQuantityForProduct(String productName) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(cartItems));
            List<WebElement> items = driver.findElements(cartItems);
            for (WebElement item : items) {
                String name = item.findElement(cartItemName).getText().trim();
                if (name.equalsIgnoreCase(productName)) {
                    return item.findElement(cartQuantity).getText().trim();
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}

