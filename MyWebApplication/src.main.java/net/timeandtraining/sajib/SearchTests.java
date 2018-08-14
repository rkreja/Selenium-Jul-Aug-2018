package net.timeandtraining.sajib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;

public class SearchTests extends TestBase {

	@Test
	public void TC001_Price_Range_Search() {

		// Step 1 Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");

		// Step 2 Click on DRESSES button
		driver.findElement(By.xpath("(//a[@title='Dresses'])[2]")).click();

		// Step 3 slide the price range between $20.00 to $40.00
		WebElement leftSideButton = driver.findElement(By.xpath("(//a[parent::div[@id='layered_price_slider']])[1]"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(leftSideButton, 30, 0).build().perform();

		WebElement RighSideButton = driver.findElement(By.xpath("(//a[parent::div[@id='layered_price_slider']])[2]"));
		action.dragAndDropBy(RighSideButton, -70, 0).build().perform();

		// Step 4 Verify product listed on right side with price ranges are between $20
		// to $40 only

	}

	@Test(testName = "Product Image View", priority = 1, enabled = false)
	public void TC003_Product_img_view2() {

		// Go to http://automationpractice.com/index.php?id_product=7&controller=product
		driver.get("http://automationpractice.com/index.php?id_product=7&controller=product");

		// Verify there are 4 thumbnail on the page
	
		
		for(int i=0;i<4;i++) {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'p/2/"+i+"')]")));
			WebElement thumbnails = driver.findElements(By.xpath("//a[contains(@href,'p/2/')]")).get(i);			
			thumbnails.click();
			
			
			driver.findElement(By.xpath("//a[@title='Close']")).click();
			
			if(i==2) {
				driver.findElement(By.id("view_scroll_right")).click();
			}
		}

//		
//		List<WebElement> tuhumnails = driver.findElements(By.xpath("//a[contains(@href,'p/2/')]"));
//		for(int i=0;i<tuhumnails.size();i++) {			
//			if(i==2) {
//				driver.findElement(By.id("view_scroll_right")).click();
//			}
//			WebDriverWait wait = new WebDriverWait(driver, 5);
//			wait.until(ExpectedConditions.elementToBeClickable(tuhumnails.get(i)));
//			new Actions(driver).moveToElement(tuhumnails.get(i)).click(tuhumnails.get(i)).build().perform();
////			tuhumnails.get(i).click();			
//			driver.findElement(By.xpath("//a[@title='Close']")).click();
//			
//			////a[contains(@href,'p/2/"+i+"')]
//		}

		// tuhumnails.get(0).click();
		// tuhumnails.get(1).click();
		// tuhumnails.get(2).click();
		// tuhumnails.get(3).click();
		
/*		for (int i = 0; i < tuhumnails.size(); i++) {
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.)
//			Actions actions = new Actions(driver);
			tuhumnails.get(i).click();
			
			if(i==2) {
				driver.findElement(By.id("view_scroll_right")).click();
			}
//			actions.moveToElement(tuhumnails.get(i).findElements(By.xpath(".//a")).get(i)).click().build().perform();
//			tuhumnails.get(i).click();
			driver.findElement(By.xpath("//a[@title='Close']")).click();
			
		}*/
		
		System.err.println("DONE");

/*
		for (int i = 0; i < tuhumnails.size(); i++) {

			tuhumnails.get(i).click();

			switch (i) {
			case 0:
				// verify big image with 20

				WebDriverWait wait60Seconds = new WebDriverWait(driver, 30);
				wait60Seconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[contains(@src,'/20')]"))));
				
				boolean verifyReview= driver.findElement(By.xpath("//img[contains(@src,'/20')]")).isDisplayed();
				Assert.assertEquals(verifyReview, true);

				break;

			case 1:
				// verify big image with 21
				WebDriverWait wait60Seconds1 = new WebDriverWait(driver, 30);
				wait60Seconds1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[contains(@src,'/21')]"))));
						

				break;
			case 2:
				// verify big image with 22
				WebDriverWait wait60Seconds2 = new WebDriverWait(driver, 30);
				wait60Seconds2.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[contains(@src,'/22')]"))));
						

				break;
			case 3:
				// verify big image with 23
				WebDriverWait wait60Seconds3 = new WebDriverWait(driver, 30);
				wait60Seconds3.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[contains(@src,'/23')]"))));
						
				break;

			}

			driver.findElement(By.xpath("//a[@title='Close']")).click();

		}*/

	}

}
