package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenSauceDemoTest {

	@Test
	public void openSauceDemoHomePage() throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();	
		
		driver.navigate().to("https://www.saucedemo.com/");
		
		String actualTitle= driver.getTitle();
		System.out.println("The actual titel is: "+ actualTitle);
		
		Assert.assertTrue(actualTitle.contains("Swag Labs"),
				"Title not match with actual title");
		
		Thread.sleep(2000);
		
		driver.quit();
	}
	
}
