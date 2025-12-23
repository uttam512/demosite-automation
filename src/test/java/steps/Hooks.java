package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class Hooks {

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

    public static WebDriver getDriver() {
        return driver;
    }
}

