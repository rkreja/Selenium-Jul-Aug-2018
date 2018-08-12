package net.timeandtraining.sajib;

import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;

public class ProductsTests extends TestBase {
	
			@Test(testName="Product Review", enabled=true, priority=1)
			public void review_on_product() {
		
//			Step 1	Go to http://www.automationpractice.com
//			driver.get("http://www.automationpractice.com");
			UI.openURL("http://www.automationpractice.com");
			
//			Step 2	Click Sign in button from top right corner of the page
//			driver.findElement(By.xpath("//a[@class='login']")).click();
			UI.clickElementByXpath("//a[@class='login']");
			
//			Step 3	Enter valid email address 'abc213@mailinator.com' in email address text field of right side
//			driver.findElement(By.id("email")).sendKeys("abc213@mailinator.com");
			UI.typeElementById("email", "abc213@mailinator.com");
			
//			Step 4	Enter valid password 'abc1234' in password text field
//			driver.findElement(By.id("passwd")).sendKeys("abc1234");
			UI.typeElementById("passwd", "abc1234");
			
//			Step 5	Click 'Sign in' button
//			driver.findElement(By.id("SubmitLogin")).click();
			UI.clickElementById("SubmitLogin");
			
//			Step 6	Go to http://automationpractice.com/index.php?id_product=7&controller=product
//			driver.navigate().to("http://automationpractice.com/index.php?id_product=7&controller=product");
			UI.openURL("http://automationpractice.com/index.php?id_product=7&controller=product");
			
//			Step 7	Click on Write a review
//			driver.findElement(By.className("open-comment-form")).click();
			UI.clickElementByClassName("open-comment-form");
			
//			Step 8	Click Send button without typing anything
//			driver.findElement(By.id("submitNewMessage")).click();  ///a[contains(text(),' Write a review')]
			UI.clickElementById("submitNewMessage");
			
//			Step 9	Verify 'Title is incorrect' text displayed
//			boolean titleVerify=driver.findElement(By.xpath("//li[contains(text(), 'Title is incorrect')]")).isEnabled();
//			Assert.assertEquals(titleVerify, true);
			UI.verifyElementIsEnabledByXpath("//li[contains(text(), 'Title is incorrect')]");
			
			
//			Step 10	Verify 'Comment is incorrect' text displayed
//			boolean commentVerify=driver.findElement(By.xpath("//li[contains(text(), 'Comment is incorrect')]")).isEnabled();
//			Assert.assertEquals(commentVerify, true);
			UI.verifyElementIsEnabledByXpath("//li[contains(text(), 'Comment is incorrect')]");
			
//			Step 11	Enter 'Awesome dress' in title
//			driver.findElement(By.id("comment_title")).sendKeys("Awesome dress");
			UI.typeElementById("comment_title", "Awesome dress");
			
//			Step 12	Enter 'Best purchase ever!!!' in Comment
//			driver.findElement(By.id("content")).sendKeys("Best purchase ever!!!");
			UI.typeElementById("content", "Best purchase ever!!!");
//			Step 13	Click Send button
//			driver.findElement(By.id("submitNewMessage")).click();
			UI.clickElementById("submitNewMessage");
			
//			Step 14	Verify 'Your comment has been added and will be available once approved by a moderator' text displayed in popup
//			boolean verifyComment= driver.findElement(By.xpath("//p[contains(text(), 'Your comment has been added and will be available once approved by a moderator')]")).isEnabled();
//			Assert.assertEquals(verifyComment, true);
			UI.verifyElementIsEnabledByXpath("//p[contains(text(), 'Your comment has been added and will be available once approved by a moderator')]");
			
//			Step 15	Click OK
//			driver.findElement(By.xpath("//span[contains(text(), 'OK')]")).click();
			UI.clickElementByXpath("//span[contains(text(), 'OK')]");
			
//			Step 16	Verify 'write a review' button gets appeared after few seconds
			
//			WebDriverWait wait60Seconds = new WebDriverWait(driver, 60);
//			wait60Seconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains (text(), 'Write a review')]"))));
			
//			boolean verifyReview= driver.findElement(By.xpath("// a [ contains ( text ( ), 'Write a review' ) ]")).isEnabled();
//			Assert.assertEquals(verifyReview, true);
		
	}

}
