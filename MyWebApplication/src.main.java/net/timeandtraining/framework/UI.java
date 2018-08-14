package net.timeandtraining.framework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UI {
	
	private WebDriver driver=null;
	
	
	public UI(WebDriver driver) {
		this.driver=driver;
	}
			
	public void openURL(String url) {
		driver.get(url);
		TestReporter.getReporter().info("Navigated to: "+ url);
	}
	public void closeBrowser() {
		driver.close();
		TestReporter.getReporter().info("successfully closed the broswer");
	}
	public void quitBrowser() {		
		driver.quit();
		TestReporter.getReporter().info("successfully quit the broswer");
	}
	
	
	//ACTIONS CLASS METHODS
	public void mouseOverToAnElement(WebElement e) {
		Actions actions = new Actions(driver);
		actions.moveToElement(e).build().perform();
		TestReporter.getReporter().info("successfully hover over the element");
	}
	public void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).build().perform();
		TestReporter.getReporter().info("successfully dragged and dropped the element");
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
		TestReporter.getReporter().info("successfully clicked on an element by class: "+ className);
	}
	public  void clickElementById(String id) {
		driver.findElement(By.id(id)).click();
		TestReporter.getReporter().info("successfully clicked on an element by id: "+ id);
	}
	public  void clickElementByXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
		TestReporter.getReporter().info("successfully clicked on an element by xpath: "+ xpath);
	}
	public  void clickElementByName(String name) {
		driver.findElement(By.name(name)).click();
		TestReporter.getReporter().info("successfully clicked on an element by name: "+ name);
	}
	
	
	//ALL SENDKEYS METHODS
	public  void typeElementById(String id, String textToType) {
		driver.findElement(By.id(id)).sendKeys(textToType);
		TestReporter.getReporter().info("Typed "+textToType+" on element by id: "+id);
	}
	public  void typeElementByXpath(String xpath, String textToType) {
		driver.findElement(By.xpath(xpath)).sendKeys(textToType);
		TestReporter.getReporter().info("Typed "+textToType+" on element by xpath: "+xpath);
	}
	
	
	//ALL VERIFICATION METHOD
	
	
	private void reportFailure(String msg) {

		
		long currentMilisecond = System.currentTimeMillis();
		File capturedFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try {
		FileUtils.copyFile(capturedFile, new File("test-output/screenshots/"+currentMilisecond+".png"));
		TestReporter.getReporter().addScreenCaptureFromPath("screenshots/"+currentMilisecond+".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void verifyTextById(String id, String textToverify) {
		String actual=driver.findElement(By.id(id)).getText();
		if(actual.equals(textToverify)) {
			TestReporter.getReporter().pass("Text ["+textToverify+"] verfication was successfull");
		}else {
			reportFailure("Failed to verify Text ["+textToverify+"]");
		}
		//Assert.assertEquals(actual, textToverify);
	}
	public void verifyTextByClassName(String className, String textToverify) {
		String actual=driver.findElement(By.xpath(className)).getText();
		if(actual.equals(textToverify)) {
			TestReporter.getReporter().pass("Text ["+textToverify+"] verficcation was successfull");
		}else {
			reportFailure("Failed to verify Text ["+textToverify+"]");
		}
//		Assert.assertEquals(actual, textToverify);
	}
	public void verifyTextByXpath(String xpath, String textToverify) {
		String actual=driver.findElement(By.xpath(xpath)).getText();
		if(actual.equals(textToverify)) {
			TestReporter.getReporter().pass("Text ["+textToverify+"] verfication was successfull");
		}else {
			reportFailure("Failed to verify Text ["+textToverify+"]");
		}
		//Assert.assertEquals(actual, text);
	}
	public void verifyTextByCssSelector(String css, String textToverify) {
		String actual=driver.findElement(By.cssSelector(css)).getText();
		if(actual.equals(textToverify)) {
			TestReporter.getReporter().pass("Text ["+textToverify+"] verficcation was successfull");
		}else {
			reportFailure("Failed to verify Text ["+textToverify+"]");
		}
//		Assert.assertEquals(actual, textToverify);
	}
	public void verifyTextByName(String name, String textToverify) {
		String actual=driver.findElement(By.name(name)).getText();
		if(actual.equals(textToverify)) {
			TestReporter.getReporter().pass("Text ["+textToverify+"] verficcation was successfull");
		}else {
			reportFailure("Failed to verify Text ["+textToverify+"]");
		}
//		Assert.assertEquals(actual, textToverify);
	}
	
	
	public void verifyElementIsEnabledById(String id) {
		Assert.assertEquals(driver.findElement(By.id(id)).isEnabled(), true);
	}
	public void verifyElementIsEnabledByName(String name) {
		Assert.assertEquals(driver.findElement(By.name(name)).isEnabled(), true);
	}
	public void verifyElementIsEnabledByXpath(String xpath) {
		Assert.assertEquals(driver.findElement(By.xpath(xpath)).isEnabled(), true);
	}
	public void verifyElementIsEnabledByClassName(String className) {
		Assert.assertEquals(driver.findElement(By.className(className)).isEnabled(), true);
	}
	public void verifyElementIsEnabledBycssSelector(String css) {
		Assert.assertEquals(driver.findElement(By.cssSelector(css)).isEnabled(), true);
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
