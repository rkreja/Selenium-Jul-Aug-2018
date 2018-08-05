package net.timeandtraining.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UI extends TestBase{
	
	
	
	
	public static void openURL(String url) {
		driver.get(url);
	}
	public static void closeBrowser() {
		driver.close();
	}
	public static void quitBrowser() {
		driver.quit();
	}
	
	
	//ACTIONS CLASS METHODS
	public static void mouseOverToAnElement(WebElement e) {
		Actions actions = new Actions(driver);
		actions.moveToElement(e).build().perform();
	}
	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).build().perform();
	}
	
	
	//FIND ELEMENTS METHODS
	
	public static WebElement findElementByXpath(String xpath) {
		try {
			return driver.findElement(By.xpath(xpath));
		} catch (Exception e2) {
			return null;
		}
		
	}
	
	public static WebElement findElementById(String id) {
		try {
			return driver.findElement(By.id(id));
		} catch (Exception e2) {
			return null;
		}

		
	}
	
	
	public static WebElement findElementByName(String name) {
		try {
			return driver.findElement(By.name(name));
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public static WebElement findElementByClass(String className) {
		try {
			return driver.findElement(By.className(className));
		} catch (Exception e) {
			return null;
		}
	}
	
	
	//TO HANDLE SELECT ELEMENT
	public static void selectByVisibleText(WebElement selectElement, String visibleText) {
		Select select = new Select(selectElement);
		select.selectByVisibleText(visibleText);
	}
	public static void selectByVisibleIndex(WebElement selectElement, int index) {
		Select select = new Select(selectElement);
		select.selectByIndex(index);
	}
	public static void selectByVisibleValue(WebElement selectElement, String value) {
		Select select = new Select(selectElement);
		select.selectByValue(value);
	}
	
	
	
	
	
	//ALL CLICK METHODS
	
	public static void alert_accept() {
		driver.switchTo().alert().accept();
	}
	
	public static void clickElementByClassName(String className) {
		driver.findElement(By.className(className)).click();
	}
	public static void clickElementById(String id) {
		driver.findElement(By.id(id)).click();
	}
	public static void clickElementByXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	public static void clickElementByName(String name) {
		driver.findElement(By.name(name)).click();
	}
	
	
	//ALL SENDKEYS METHODS
	public static void typeElementById(String id, String textToType) {
		driver.findElement(By.id(id)).sendKeys(textToType);
	}
	
	
	//ALL GET TEXT / ATTRIBUTE METHODS
		public static String getTextByClassName(String className) {
			String s=driver.findElement(By.className(className)).getText();
			return s;			
		}
		
		public static String getTextById(String id) {
			String s=driver.findElement(By.id(id)).getText();
			return s;			
		}

		public static String getTextByXpath(String xpath) {
			String s=driver.findElement(By.xpath(xpath)).getText();
			return s;			
		}
		
		//ALL EXPLICIT WAIT METHODS
		public static boolean waitForTextToBePresent(WebElement e, String text) {
			WebDriverWait wait = new WebDriverWait(driver, 70);				
			return wait.until(ExpectedConditions.textToBePresentInElement(e, text));
			
		}
		public static WebElement waitUntilElementIsClickable(WebElement e) {
			WebDriverWait wait = new WebDriverWait(driver, 70);				
			return wait.until(ExpectedConditions.elementToBeClickable(e));
			
		}

}
