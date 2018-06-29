package net.timeandtraining.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTests {

	public static void main(String[] args) {

		//setup our driver		
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//setup done		
				
		//Go to http://www.automationpractice.com		
		driver.get("http://www.automationpractice.com");	

		//Click Sign in button from top right corner of the page
		driver.findElement(By.className("login")).click();
		
		//Enter invalid email address 'myunknowxaad@mailinator.com' in email address text field of right side
		driver.findElement(By.id("email")).sendKeys("myunknowxaad@mailinator.com");
				
		//Click Sign in button
		driver.findElement(By.id("SubmitLogin")).click();
		
		//Verify error message displayed 'There is 1 error'
		
		//Verify error message displayed 'Authentication failed.'
		

	}

}
