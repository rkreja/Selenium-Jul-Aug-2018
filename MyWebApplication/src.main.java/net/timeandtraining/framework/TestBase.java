package net.timeandtraining.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	protected static WebDriver driver = new ChromeDriver();
	
	@BeforeSuite
	public void init() {

		// setup our driver
		System.setProperty("webdriver.chrome.driver", "lib//chromedriver-windows-32bit.exe");		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// setup done
	}
	
	@AfterSuite
	public void closeDriver() {
		UI.closeBrowser();
	}

}
