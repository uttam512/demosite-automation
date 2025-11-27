package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class Hooks {

    // Simple static driver for now (no parallel)
    private static WebDriver driver;

    @Before
    public void beforeScenario() {
        driver = DriverFactory.getDriver();
    }

    @After
    public void afterScenario() {
        if (driver != null) {
            DriverFactory.quitDriver(driver);
            driver = null;
        }
    }

    // Simple helper for steps to get current driver
    public static WebDriver getDriver() {
        return driver;
    }
}

