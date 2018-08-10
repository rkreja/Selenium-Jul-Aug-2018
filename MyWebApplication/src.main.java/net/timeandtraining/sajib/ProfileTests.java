package net.timeandtraining.sajib;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;

public class ProfileTests extends TestBase {
	
	@Test(testName="Update name in User Profile", priority=1, enabled=true)
	public void TC001_Update_Name_In_User_Profile () {
		
//			Step 1	Go to http://www.automationpractice.com
			driver.get("http://www.automationpractice.com");
		
//			Step 2	Click Sign in button from top right corner of the page
			driver.findElement(By.xpath("//a[@class='login']")).click();
		
//			Step 3	Enter valid email address 'abc213@mailinator.com' in email address text field of right side
			driver.findElement(By.id("email")).sendKeys("abc213@mailinator.com");
			
//			Step 4	Enter valid password 'abc1234' in password text field
			driver.findElement(By.id("passwd")).sendKeys("abc1234");
		
//			Step 5	Click 'Sign in' button
			driver.findElement(By.id("SubmitLogin")).click();
		
//			Step 6	Click on name 'Misir Ali' from top right corner
			driver.findElement(By.xpath("(//span)[1]")).click();
		
//			Step 7	Click on button 'MY PERSONAL INFORMATION'
			driver.findElement(By.xpath("//span[contains(text(), 'My personal information')]")).click();
			
//			Step 8	Verify text displayed 'Please be sure to update your personal information if it has changed.'
			boolean verifyText= driver.findElement(By.xpath("//p[contains(text(), 'Please be sure to update your personal information if it has changed.')]")).isEnabled();
			Assert.assertEquals(verifyText, true);
		
//			Step 9	Enter new first name as 'Hanif'
			driver.findElement(By.id("//input[@id='firstname']")).sendKeys("Hanif");
		
//			Step 10	Enter new last name as 'Shanket'
			driver.findElement(By.id("//input[@id='lastname']")).sendKeys("Shanket");
		
//			Step 11	Click 'Save' button
			driver.findElement(By.xpath("//span[contains(text(), 'Save')]")).click();
		
//			Step 12	Verify error message displayed 'There is 1 error'
			String verifyMessage1= driver.findElement(By.xpath("//p[contains(text(), 'There is 1 error')]")).getText();
			Assert.assertEquals(verifyMessage1, true);
		
//			Step 13	Verify error message displayed 'The password you entered is incorrect'
			boolean verifyMessage3= driver.findElement(By.xpath("//li[contains(text(), 'The password you entered is incorrect.')]")).isEnabled();
			Assert.assertEquals(verifyMessage3, true);
		
//			Step 14	Enter current password 'abc1234' in password text field
			driver.findElement(By.xpath("//input[@name='old_passwd']")).sendKeys("abc1234");
		
//			Step 15	Click 'Save' button
			driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		
//			Step 16	Verify success message displayed 'Your personal information has been successfully updated.'
			boolean verifyMessage4= driver.findElement(By.xpath("//li[contains(text(), 'The password you entered is incorrect.')]")).isEnabled();
			Assert.assertEquals(verifyMessage4, true);
		
//			Step 17	Click on name 'Hanif Shanket' from top right corner
		
//			Step 18	Click on button 'MY PERSONAL INFORMATION'
		
//			Step 19	Verify text displayed 'Please be sure to update your personal information if it has changed.'
		
//			Step 20	Enter first name back as 'Misir'
		
//			Step 21	Enter last name back as 'Ali'
		
//			Step 22	Click 'Save' button
		
//			Step 23	Enter current password 'abc1234' in password text field
		
//			Step 24	Click 'Save' button
		
//			Step 25	Verify success message displayed 'Your personal information has been successfully updated.'

		
	}

}
