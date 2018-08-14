package net.timeandtraining.sajib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.TestReporter;

	public class LoginTests extends TestBase {

	@Test
	public void DemoTest2() {
		
		String s="selenium";
		
		UI.openURL("https://www.amazon.com");
		
		if(s.equals("java")) {
			TestReporter.getReporter().pass("Text found: "+s);
		}else {
			
			TakesScreenshot sc = ((TakesScreenshot) driver);			
			File capture=sc.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(capture, new File("captured.png"));
				TestReporter.getReporter().fail("Text "+s+" not found").addScreenCaptureFromPath("../captured.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			
			
			
			
		}
		

	}

	@Test
	public void TC001_login_With_Invalid_Id() {

//				Step 1	Go to http://www.automationpractice.com
//				driver.get("http://www.automationpractice.com");
		UI.openURL("http://www.automationpractice.com");

//				Step 2	Click Sign in button from top right corner of the page
//				driver.findElement(By.xpath("//a[@class='login' and @title='Log in to your customer account']")).click();
		UI.clickElementByXpath("//a[@class='login' and @title='Log in to your customer account']");

//				Step 3	Enter invalid email address 'myunknowxaad@mailinator.com' in email address text field of right side
//				driver.findElement(By.xpath("//input[@id='email']")).sendKeys("myunknowxaad@mailinator.com");
		UI.typeElementByXpath("//input[@id='email']", "myunknowxaad@mailinator.com");

//				Step 4	Click Sign in button		
//				driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		UI.clickElementByXpath("//button[@id='SubmitLogin']");

//				Step 5	Verify error message displayed 'There is 1 error'
//				String verifyMessage= driver.findElement(By.xpath("//p[contains(text(), 'There is 1 error')]")).getText();
//				Assert.assertEquals(verifyMessage, "There is 1 error");
//				System.out.println(verifyMessage);
		UI.verifyTextByXpath("//p[contains(text(), 'There is 1 error')]", "There is 1 errorx");

//				Step 6	Verify error message displayed 'Authentication failed.'
//				String verifyAuthentication = driver.findElement(By.xpath("//h1[contains(text(), 'Authentication')]")).getText();
//				Assert.assertEquals(verifyAuthentication, "AUTHENTICATION");
		UI.verifyTextByXpath("//h1[contains(text(), 'Authentication')]", "AUTHENTICATION");

	}

	@Test(testName = "Login with invalid id", priority = 1, enabled = true)

	public void TC001_login_with_invalid_id_Valid_Password() {

//					Step 1 Go to http://www.automationpractice.com		
//					driver.get("http://www.automationpractice.com");
		UI.openURL("http://www.automationpractice.com");

//					Step 2 Click Sign in button from top right corner of the page		
//					driver.findElement(By.xpath("//a[@class='login' and @title='Log in to your customer account']")).click();
		UI.clickElementByXpath("//a[@class='login' and @title='Log in to your customer account']");

//					Step 3 Enter invalid email address 'myunknowxaad@mailinator.com' in email address text field of right side
//					driver.findElement(By.xpath("//input[@id='email']")).sendKeys("myunknowxaad@mailinator.com");
		UI.typeElementByXpath("//input[@id='email']", "myunknowxaad@mailinator.com");

//					Step 4 Click Sign in button
//					driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		UI.clickElementByXpath("//button[@id='SubmitLogin']");

//					Step 5 Verify error message displayed 'There is 1 error'
//					String verifyDisplayed=driver.findElement(By.xpath("//p[contains(text(), 'There is 1 error')]")).getText();
//					Assert.assertEquals(verifyDisplayed, "There is 1 error");
		UI.verifyTextByXpath("//p[contains(text(), 'There is 1 error')]", "There is 1 error");

//					Step 6 Verify error message displayed 'Password is required.'
//					boolean result=driver.findElement(By.xpath("//li[contains(text(), 'Password is required.')]")).isEnabled();
		// System.out.println(result);
//					Assert.assertEquals(result, true);
		UI.verifyElementIsEnabledByXpath("//p[contains(text(), 'There is 1 error')]");

	}

	@Test(testName = "Login with valid user id and password", priority = 3, enabled = true)
	public void TC003_login_with_valid_userid_password() {

//			Step 1 Go to http://www.automationpractice.com
//			driver.get("http://www.automationpractice.com");
		UI.openURL("http://www.automationpractice.com");

//			Step 2 Click Sign in button from top right corner of the page
//			driver.findElement(By.xpath("//a[@class='login' and @title='Log in to your customer account']")).click();
		UI.clickElementByXpath("//a[@class='login' and @title='Log in to your customer account']");

//			Step 3 Enter valid email address 'abc213@mailinator.com' in email address text field of right side
//			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc213@mailinator.com");
		UI.typeElementByXpath("//input[@id='email']", "abc213@mailinator.com");

//			Step 4 Enter valid password 'abc1234' in password text field
//			driver.findElement(By.id("passwd")).sendKeys("abc1234");
		UI.typeElementById("passwd", "abc1234");

//			Step 5 Click 'Sign in' button
//			driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		UI.clickElementByXpath("//button[@id='SubmitLogin']");

//			Step 6 Verify 'MY ACCOUNT' text displayed
//			boolean myAccount=driver.findElement(By.xpath("//h1[contains(text(), 'My account')]")).isEnabled();
//			Assert.assertEquals(myAccount, true);		
		UI.verifyElementIsEnabledByXpath("//h1[contains(text(), 'My account')]");

//			Step 7 Verify 'Welcome to your account. Here you can manage all of your personal
//			boolean informationForOrder =driver.findElement(By.xpath("//p[contains(text(), 'Welcome to your account. Here you can manage all of your personal information and orders.')]")).isEnabled();
//			Assert.assertEquals(informationForOrder, true);
		UI.verifyElementIsEnabledByXpath(
				"//p[contains(text(), 'Welcome to your account. Here you can manage all of your personal information and orders.')]");

//			Step 8 Verify 'My personal information' text displayed
//			String MyAccount =driver.findElement(By.xpath("//span[contains(text(), 'My personal information')]")).getText();
//			System.out.println(MyAccount);
		UI.verifyTextByXpath("//span[contains(text(), 'My personal information')]", "MY PERSONAL INFORMATION");
//			Step 9 Click 'Sign out' button from top right corner
//			driver.findElement(By.xpath("//a[@class='logout']")).click();
		UI.clickElementByXpath("//a[@class='logout']");
	}

}
