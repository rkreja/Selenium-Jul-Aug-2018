package net.timeandtraining.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UI {
	
	private WebDriver driver=null;
	
	
	public UI(WebDriver driver) {
		this.driver=driver;
	}
			
	public void openURL(String url) {
		driver.get(url);
	}
	public void closeBrowser() {
		driver.close();
	}
	public void quitBrowser() {
		driver.quit();
	}
	
	
	//ACTIONS CLASS METHODS
	public void mouseOverToAnElement(WebElement e) {
		Actions actions = new Actions(driver);
		actions.moveToElement(e).build().perform();
	}
	public void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).build().perform();
	}
	
	
	//FIND ELEMENTS METHODS
	
	public WebElement findElementByXpath(String xpath) {
		try {
			return driver.findElement(By.xpath(xpath));
		} catch (Exception e2) {
			return null;
		}
		
	}
	
	public WebElement findElementById(String id) {
		try {
			return driver.findElement(By.id(id));
		} catch (Exception e2) {
			return null;
		}

		
	}
	
	
	public WebElement findElementByName(String name) {
		try {
			return driver.findElement(By.name(name));
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public WebElement findElementByClass(String className) {
		try {
			return driver.findElement(By.className(className));
		} catch (Exception e) {
			return null;
		}
	}
	
	
	//TO HANDLE SELECT ELEMENT
	public void selectByVisibleText(WebElement selectElement, String visibleText) {
		Select select = new Select(selectElement);
		select.selectByVisibleText(visibleText);
	}
	public void selectByVisibleIndex(WebElement selectElement, int index) {
		Select select = new Select(selectElement);
		select.selectByIndex(index);
	}
	public void selectByVisibleValue(WebElement selectElement, String value) {
		Select select = new Select(selectElement);
		select.selectByValue(value);
	}
	
	
	
	
	
	//ALL CLICK METHODS
	
	public void alert_accept() {
		driver.switchTo().alert().accept();
	}
	
	public  void clickElementByClassName(String className) {
		driver.findElement(By.className(className)).click();
	}
	public  void clickElementById(String id) {
		driver.findElement(By.id(id)).click();
	}
	public  void clickElementByXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	public  void clickElementByName(String name) {
		driver.findElement(By.name(name)).click();
	}
	
	
	//ALL SENDKEYS METHODS
	public  void typeElementById(String id, String textToType) {
		driver.findElement(By.id(id)).sendKeys(textToType);
	}
	
	
	//ALL GET TEXT / ATTRIBUTE METHODS
		public  String getTextByClassName(String className) {
			String s=driver.findElement(By.className(className)).getText();
			return s;			
		}
		
		public  String getTextById(String id) {
			String s=driver.findElement(By.id(id)).getText();
			return s;			
		}

		public  String getTextByXpath(String xpath) {
			String s=driver.findElement(By.xpath(xpath)).getText();
			return s;			
		}
		
		//ALL EXPLICIT WAIT METHODS
		public  boolean waitForTextToBePresent(WebElement e, String text) {
			WebDriverWait wait = new WebDriverWait(driver, 70);				
			return wait.until(ExpectedConditions.textToBePresentInElement(e, text));
			
		}
		public  WebElement waitUntilElementIsClickable(WebElement e) {
			WebDriverWait wait = new WebDriverWait(driver, 70);				
			return wait.until(ExpectedConditions.elementToBeClickable(e));
			
		}

}
