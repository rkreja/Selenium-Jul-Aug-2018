package net.timeandtraining.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class WebDriverOperations extends TestBase{
	
	
	
	
	@Test
	public void handlingAlertDemo() {
		
		UI.openURL("http://timeandtraining.net/seleniumdemo/selenium.html");		
		UI.clickElementByXpath("//button[contains(@class,'btn-primary')]");
		UI.alert_accept();
	
	}
	@Test
	public void selectObjectDemo() {
		UI.openURL("http://timeandtraining.net/seleniumdemo/selenium.html");			
		//Using our UI class
		//WebElement e=UI.findElementByXpath("(//select[@class='custom-select'])[2]");
		//UI.selectByVisibleText(e, "Python");

		
		//Using driver directly
		WebElement e=driver.findElement(By.xpath("(//select[@class='custom-select'])[1]"));
		Select dropdown = new Select(e);
		dropdown.selectByVisibleText("Java");

		
		
	}
	@Test
	public void clickingCheckOboxAndRadioButton() {
		UI.openURL("http://timeandtraining.net/seleniumdemo/selenium.html");			

		//radio
		//driver.findElement(By.xpath("(//*[@id='exampleRadios3'])[1]")).click();
		UI.clickElementByXpath("(//*[@id='exampleRadios3'])[1]");
		
		
		//checknox
		//driver.findElement(By.xpath("(//*[@id='exampleRadios3'])[3]")).click();				
		UI.clickElementByXpath("(//*[@id='exampleRadios3'])[3]");
		
		
	}
	@Test
	public void fileUpload() {
		
		UI.openURL("http://timeandtraining.net/seleniumdemo/selenium.html");	
		UI.typeElementById("demoFileUpload", "F:\\Time And Training\\transparent_logo.png");
//		driver.findElement(By.id("demoFileUpload")).sendKeys("F:\\\\Time And Training\\\\transparent_logo.png");
	
	}
	
}
