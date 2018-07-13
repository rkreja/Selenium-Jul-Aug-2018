package net.timeandtraining.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;






public class LoginTests {
	
	

	
	@Test
	public static void login_with_invalid_userid() {
		
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
		
		String errMsg1;
		String errMsg2;
		
		errMsg1 = driver.findElement(By.xpath("//p[contains(text(),'There is 1')]")).getText();
		
		//Verify error message displayed 'Password is required'
		errMsg2 = driver.findElement(By.xpath("//li[contains(text(),'Password is required')]")).getText();


		
		Assert.assertEquals(errMsg1, "There is 2 error");
		Assert.assertEquals(errMsg2, "Password is required.");
		
		driver.quit();
		
		
		
		
		
	}
	
	

}
