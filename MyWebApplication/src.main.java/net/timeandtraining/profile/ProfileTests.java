package net.timeandtraining.profile;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class ProfileTests extends TestBase{
	
	
	
	public void login(String uid, String pwd) {
		UI.openURL("http://www.automationpractice.com");
//		Click Sign in button from top right corner of the page
		UI.clickElementByClassName("login");
//		Enter valid email address 'abc213@mailinator.com' in email address text field of right side
		UI.typeElementById("email", uid);
//		Enter valid password 'abc1234' in password text field
		UI.typeElementById("passwd", pwd);
//		Click 'Sign in' button
		UI.clickElementById("SubmitLogin");
	}
	
	
	@Test
	public void change_password() {
		
		String uid="abc213@mailinator.com";
		String currentPwd="abc1234";
		String newPwd="xyz1234";
		WebElement succuessMsg=null;
		boolean result;
		boolean isPasswordResetCompleted=false;
		String msgToVerify="Your personal information has been successfully updated.";
		
	
		
	
//			Go to http://www.automationpractice.com
			
			
			login(uid,currentPwd);
			
			
//			UI.openURL("http://www.automationpractice.com");
////			Click Sign in button from top right corner of the page
//			UI.clickElementByClassName("login");
////			Enter valid email address 'abc213@mailinator.com' in email address text field of right side
//			UI.typeElementById("email", uid);
////			Enter valid password 'abc1234' in password text field
//			UI.typeElementById("passwd", currentPwd);
////			Click 'Sign in' button
//			UI.clickElementById("SubmitLogin");
			
//			Click on name 'Misir Ali' from top right corner
			UI.clickElementByClassName("account");
//			Click on button 'MY PERSONAL INFORMATION'
			UI.clickElementByXpath("//a[@title='Information']");
//			Enter current password as 'abc1234'
			UI.typeElementById("old_passwd", currentPwd);
//			Enter new password as 'xyz1234' in new password text field
			UI.typeElementById("passwd", newPwd);
//			Click 'Save' button
			UI.clickElementByName("submitIdentity");
//			Verify error message displayed 'There is 1 error'
			
			WebElement errmsg=null;
				errmsg=UI.findElementByXpath("//p[text()='There is 1 error']");
				Assert.assertNotNull(errmsg);
		
			
			
//			Verify error message displayed 'The password and confirmation do not match.'
			errmsg=UI.findElementByXpath("//li[text()='The password and confirmation do not match.']");
			Assert.assertNotNull(errmsg);
		try {
//			Enter current password as 'abc1234'	
			UI.typeElementById("old_passwd", currentPwd);
//			Enter new password as 'xyz1234' in new password text field
			UI.typeElementById("passwd", newPwd);
//			Enter same password 'xyz1234' in confirmation text field
			UI.typeElementById("confirmation", newPwd);
//			Click 'Save' button
			UI.clickElementByName("submitIdentity");
//			Verify success message displayed 'Your personal information has been successfully updated.'
			
			succuessMsg=UI.findElementByXpath("//p[@class='alert alert-success']");
			result=succuessMsg.getText().contains(msgToVerify);
			Assert.assertEquals(result,true);
			
			isPasswordResetCompleted=true;
			
		} catch (Exception e) {
			Assert.fail("Exception found while changing password\n"+e.getMessage());
			
		}finally {
			
			
		
			
			if(isPasswordResetCompleted==true) {
				if(UI.findElementByClass("account")==null) {
					login(uid,newPwd);
				}				
//				Click on name 'Misir Ali' from top right corner
				UI.clickElementByClassName("account");
//				Click on button 'MY PERSONAL INFORMATION'
				UI.clickElementByXpath("//a[@title='Information']");
//				Enter current password as 'xyz1234'			
				UI.typeElementById("old_passwd", newPwd);
//				Enter new password as 'abc1234' in new password text field
				UI.typeElementById("passwd", currentPwd);
//				Enter same password 'abc1234' in confirmation text field
				UI.typeElementById("confirmation", currentPwd);
//				Click 'Save' button
				UI.clickElementByName("submitIdentity");
//				Verify success message displayed 'Your personal information has been successfully updated.'
				succuessMsg=UI.findElementByXpath("//p[@class='alert alert-success']");
				result=succuessMsg.getText().contains(msgToVerify);
				Assert.assertEquals(result,true);
			}
			
			
			
		}
		
		
		
		
		
		
		
		

		
	}

}
