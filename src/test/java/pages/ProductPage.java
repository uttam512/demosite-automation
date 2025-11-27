/*package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;
import java.util.List;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    //private By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private By inventoryContainer = By.id("inventory_container");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");
    private By cartLink = By.cssSelector("a.shopping_cart_link");
    private By inventoryItem = By.className("inventory_item");
    private By inventoryItemName = By.className("inventory_item_name");
    private By inventoryItemButton = By.tagName("button");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Check that we are on the products page
    public boolean isOnProductsPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer));
            return driver.getCurrentUrl().contains("/inventory");
        } catch (Exception e) {
            return false;
        }
    }

 // Add the "Sauce Labs Backpack" product to the cart (simple direct method)
    //public void addBackpackToCart() {
    //    wait.until(ExpectedConditions.elementToBeClickable(addBackpackButton)).click();
     //   DriverFactory.slowDown();
    //}
    
    // Add a product to the cart by its visible name (e.g., "Sauce Labs Backpack")
    public void addProductToCart(String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer));
        List<WebElement> products = driver.findElements(inventoryItem);

        for (WebElement product : products) {
            String name = product.findElement(inventoryItemName).getText().trim();

            if (name.equalsIgnoreCase(productName)) {
                WebElement button = product.findElement(inventoryItemButton);
                button.click();
                DriverFactory.slowDown();
                break;
            }
        }
    } 

    // Get the number shown in the cart badge (top-right)
    public int getCartBadgeCount() {
        try {
            WebElement badge = wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
            String text = badge.getText().trim();
            return Integer.parseInt(text);
        } catch (Exception e) {
            // If no badge (cart empty), return 0
            return 0;
        }
    }

    // Click on cart icon (for future use when we create a CartPage)
    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
        DriverFactory.slowDown();
    }
}*/

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;
import java.util.List;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By inventoryContainer = By.id("inventory_container");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");
    private By cartLink = By.cssSelector("a.shopping_cart_link");
    private By inventoryItem = By.className("inventory_item");
    private By inventoryItemName = By.className("inventory_item_name");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Check that we are on the products page
    public boolean isOnProductsPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer));
            return driver.getCurrentUrl().contains("/inventory");
        } catch (Exception e) {
            return false;
        }
    }

    // Add a product to the cart by its visible name (e.g., "Sauce Labs Backpack")
    public void addProductToCart(String productName) {
        // Wait for product list to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer));

        // Get all products
        List<WebElement> products = driver.findElements(inventoryItem);
        System.out.println("DEBUG: Looking for product -> " + productName);
        for (WebElement product : products) {
            WebElement nameElement = product.findElement(inventoryItemName);
            String nameText = nameElement.getText().trim();
            System.out.println("DEBUG: Found product name: " + nameText);
            // If this product's name matches what we want
            if (nameText.equalsIgnoreCase(productName)) {
                // Find the button inside this same product card
                WebElement addButton = product.findElement(By.tagName("button"));
                addButton.click();
                DriverFactory.slowDown();
                break;
            }
        }
        System.out.println("DEBUG: Product not found on page: " + productName);
    }

    // Get the number shown in the cart badge (top-right)
    public int getCartBadgeCount() {
        try {
            WebElement badge = wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
            String text = badge.getText().trim();
            return Integer.parseInt(text);
        } catch (Exception e) {
            // If no badge (cart empty), return 0
            return 0;
        }
    }

    // Click on cart icon (for future use when we create a CartPage)
    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
        DriverFactory.slowDown();
    }
}


