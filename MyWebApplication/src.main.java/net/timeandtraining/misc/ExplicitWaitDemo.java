package net.timeandtraining.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class ExplicitWaitDemo extends TestBase{
	
	
	
	@Test
	public void getTodaysQuote() {
		
		String quote="“Dream is not the thing you see in sleep but is that thing that doesn't let you sleep.”";
		
		UI.openURL("http://timeandtraining.net/seleniumdemo/selenium.html");
		
		//Using Direct selenium lib waiting for text to be present
		
		WebDriverWait wait = new WebDriverWait(driver, 70);
		WebElement q= UI.findElementById("explicitWaitTextPresentDemo");		
		wait.until(ExpectedConditions.textToBePresentInElement(q, quote));
		
		
		
		//Using our framework wait for text to be present
		//UI.waitForTextToBePresent(q, quote);
			
		
		
			
				
		
		
		
	}
	
	@Test
	public void clickButton() {
		UI.openURL("http://timeandtraining.net/seleniumdemo/selenium.html");		
		
		//Wait for element to be present using selenium lib
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Now I am present after')]")));
	}
	
	

}
