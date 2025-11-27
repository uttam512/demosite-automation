package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static void quitDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }

    // slowdown helper (use -Dslow=true to enable)
    public static void slowDown() {
        String slow = System.getProperty("slow");
        if ("true".equalsIgnoreCase(slow)) {
            try {
                Thread.sleep(2000); // 1 sec default; change if needed
            } catch (InterruptedException ignored) {}
        }
    }
}
