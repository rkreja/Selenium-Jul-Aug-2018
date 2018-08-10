package net.timeandtraining.sajib;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;

public class RegistrationTests extends TestBase {

	
		@Test(testName="Registratin", priority=1, enabled=true)
		public void TC001 () {
		
		Random randomGenerator= new Random();
		int randomInt= randomGenerator.nextInt();
		
		
//		Step 1	Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");
		
//		Step 2	Click Sign in button from top right corner of the page
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		
//		Step 3	Enter email address 'abc@mailinator.com' in email address text field of left side
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("abc@mailinator.com");		
		
//		Step 4	Click create an account button
		driver.findElement(By.xpath("//button[@name='SubmitCreate']")).click();
		
//		Step 5	Verify error message displayed 'An account using this email address has already been registered. Please enter a valid password or request a new one.'
//		boolean AccountVerify= driver.findElement(By.xpath("//li[contains(text(), 'An account using this email address')]")).isEnabled();
//		Assert.assertEquals(AccountVerify, 	true);
		
		String accountVerify=driver.findElement(By.xpath("//li[contains(text(), 'An account using this email address')]")).getText();
		Assert.assertEquals(accountVerify, "An account using this email address has already been registered. Please enter a valid password or request a new one.");
		
		
//		Step 6	Enter a valid email address in email address text field. (You can use xxxxxxx@mailinator.com)
		driver.findElement(By.xpath("//input[@id='email_create']")).clear();
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("abcd"+randomInt+"@gmail.com");
		
//		Step 7	Click create an account button
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		
//		Step 8	Click 'Register' button
		
//		Step 9	Verify error message displayed 'You must register at least one phone number.'		
		String phoneVerify= driver.findElement(By.xpath("//p[text()='You must register at least one phone number.']")).getText();
		Assert.assertEquals(phoneVerify, "You must register at least one phone number.");

//		Step 10	Verify error message displayed 'lastname is required.'
		String verifyLastname= driver.findElement(By.xpath("(//label[contains(text(),'Last name ')])[1]")).getText();
		Assert.assertEquals(verifyLastname, "Last name *");
		
//		Step 11	Verify error message displayed 'firstname is required.'
		String verifyFname= driver.findElement(By.xpath("(//label[contains (text(), 'First name ')])[1]")).getText();
		Assert.assertEquals(verifyFname, "First name *");
		
//		Step 12	Verify error message displayed 'passwd is required.'		
		String VerifyPassword = driver.findElement(By.xpath("(//label[contains (text(), 'Password ')])[1]")).getText();
		Assert.assertEquals(VerifyPassword, "Password *");
		
//		Step 13	Verify error message displayed 'address1 is required.'		
		String  verifyAddress1 = driver.findElement(By.xpath("(//label[contains (text(), 'Address ')])[1]")).getText();
		Assert.assertEquals(verifyAddress1, "Address *");
		
//		Step 14	Verify error message displayed 'city is required.'
//		Step 15	Verify error message displayed 'The Zip/Postal code you've entered is invalid. It must follow this format: 00000'
//		Step 16	Verify error message displayed 'This country requires you to choose a State.'
		
//		Step 17	Select 'Mr' radio button
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		
//		Step 18	Enter First name as 'John'
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("John");
		
//		Step 19	Enter Last name as 'Smith'
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Smith");
		
//		Step 20	Verify Email text box has email address defined as used in step 6
		
//		Step 21	Enter password as 'MyStrong_Password'
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("123456");
		
//		Step 22	Select day 15 from day dropdown
		Select dropDown_Day= new Select(driver.findElement(By.id("days")));
		dropDown_Day.selectByValue("28");
		
//		Step 24	Select month September from month dropdown
		Select dropDown_month= new Select(driver.findElement(By.id("months")));
		dropDown_month.selectByValue("4");		
		
//		Step 23	Select year 1984 from year dropdown
		Select dropDown_year= new Select(driver.findElement(By.id("years")));
		dropDown_year.selectByValue("1984");		

//		Step 25	Verify First name text field below has first name defined as used in step 18
		
//		Step 26	Verify First name text field below has last name defined as used in step 19
		
//		Step 27	Enter Company as 'Time and Training' in Company text field
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Time and Training");
		
//		Step 28	Enter address as '123 abc street' in address text field
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("123 Street");
		
//		Step 29	Enter city New York in city text field
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Brooklyn");
		
//		Step 30	Select state New York from state drop down		
		Select dropDown_state= new Select(driver.findElement(By.id("id_state")));
		dropDown_state.selectByValue("32");
		
//		Step 30	Select state New York from state drop down	
		
		
//		Step 31	Enter '10001' in Zip/Postal Code text field
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("10001");
		
//		Step 32	Select country United States from country dropdown
		Select dropDown_country = new Select(driver.findElement(By.id("id_country")));
		dropDown_country.selectByValue("21");
		
//		Step 33	Enter text 'Registering ac account with all fields' in Additional information text area
		driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("Registering ac account with all fields");
		
//		Step 34	Enter '7031234567' in Home Phone text field
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("7031234567");
		
//		Step 35	Enter Enter '7039876543214' in Mobile phone text field
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("7039876543214");
		
//		Step 36	Replace text 'My Address' to 'Home' in Assign an address alias for future reference text field
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("My Address");
		
//		Step 37	Click 'Register' button
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
		
//		Step 38	Verify 'MY ACCOUNT' text displayed
		String myAccount = driver.findElement(By.xpath("//h1[text()='My account']")).getText();
		Assert.assertEquals(myAccount, "MY ACCOUNT");
		
//		Step 39	Verify 'Welcome to your account. Here you can manage all of your personal information and orders.' text displayed
		String WelcomeAccount = driver.findElement(By.xpath("//p[contains(text(),'Welcome to your account.')]")).getText();
		Assert.assertEquals(WelcomeAccount, "Welcome to your account. Here you can manage all of your personal information and orders.");
		
//		Step 40	Verify 'My personal information' text displayed
		String MyPersonal = driver.findElement(By.xpath("//span[contains(text(),'My personal information')]")).getText();
		Assert.assertEquals(MyPersonal, "MY PERSONAL INFORMATION");
		
//		Step 40	Verify 'My personal information' text displayed
		WebElement Mypersonal1= driver.findElement(By.xpath("//span[contains(text(),'My personal information')]"));
		
		
//		Step 41	Click 'Sign out' button from top right corner
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		
	}
	
	
}
