package net.timeandtraining.search;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchTests {
	
	public static void myMethod() {
		
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}
		
	
	@Test
	public static void search_auto_suggetions() {
		
		//setup our driver		
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//setup done
		
		
		//Go to http://www.automationpractice.com
		//Enter 'Chif' in search text box on top
		//Verify 'Summer Dresses > Printed Chifton Dress' option get suggested in search textbox with 'Chif' in bold
		
		
		
	}
	
	
	
	@Test
	public static void goto_google() {

	}
	
	
	

}
