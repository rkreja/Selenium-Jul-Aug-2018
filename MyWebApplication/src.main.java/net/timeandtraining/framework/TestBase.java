package net.timeandtraining.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

	protected static WebDriver driver=null;
	
	
	protected UI UI=null;
	
	@BeforeTest
	@Parameters("browser")
	public void init(@Optional("ch") String browser) {
		
		// setup our driver
		switch (browser) {
		
		case "ie":
			System.setProperty("webdriver.ie.driver", "lib//internetexplorerdriver-windows-32bit.exe");
			driver = new InternetExplorerDriver();
			break;
			
		case "ch":
			System.setProperty("webdriver.chrome.driver", "lib//chromedriver-windows-32bit.exe");
			driver = new ChromeDriver();
			break;
			
		case "ff":
			System.setProperty("webdriver.gecko.driver", "lib//geckodriver-windows-64bit.exe");
			driver = new FirefoxDriver();
			break;

		default:
			System.err.println("Invalid browser initial were given");
			System.exit(1);
			break;
		}
		
//		if (browser.equals("ch")) {
//			System.setProperty("webdriver.chrome.driver", "lib//chromedriver-windows-32bit.exe");
//			driver = new ChromeDriver();
//			
//		}else if(browser.equals("ie")) {
//			System.setProperty("webdriver.ie.driver", "lib//internetexplorerdriver-windows-32bit.exe");
//			driver = new InternetExplorerDriver();
//			
//		}else if(browser.equals("ff")) {
//			
//			System.setProperty("webdriver.gecko.driver", "lib//geckodriver-windows-64bit.exe");
//			driver = new FirefoxDriver();
//			
//		}else {
//			
//			System.err.println("Invalid browser initial were given");
//			System.exit(1);
//		}

		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		UI=new UI(driver);
		
		// setup done
	}
	
	@AfterTest
	public void closeDriver() {
		UI.closeBrowser();
	}

}
