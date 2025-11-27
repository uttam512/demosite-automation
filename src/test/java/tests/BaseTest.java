package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUpBase() {
        // Create a new browser instance before each test
        driver = DriverFactory.getDriver();
    }

    @AfterMethod
    public void tearDownBase() {
        // Close the browser after each test
        DriverFactory.quitDriver(driver);
    }
}

