package net.timeandtraining.misc;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class ActionsClassDemo extends TestBase{
	
	@Test
	public void mouseOverOnElement() {
		
		UI.openURL("http://timeandtraining.net/seleniumdemo/selenium.html");
		
		WebElement redElement = UI.findElementByXpath("(//li[text()='Mouse over on me '])[1]");
		WebElement greenElement = UI.findElementByXpath("(//li[text()='Mouse over on me '])[2]");
		WebElement blueElement = UI.findElementByXpath("(//li[text()='Mouse over on me '])[3]");
		
		
		
		Actions actions = new Actions(driver);
		actions.moveToElement(redElement).build().perform();
		System.out.println(UI.getTextById("mouseovertext"));
		actions.moveToElement(greenElement).build().perform();
		System.out.println(UI.getTextById("mouseovertext"));
		actions.moveToElement(blueElement).build().perform();
		System.out.println(UI.getTextById("mouseovertext"));
		
		
	}
	@Test
	public void dragAndDrop() {
		
		UI.openURL("http://timeandtraining.net/seleniumdemo/selenium.html");
		
		WebElement logo = UI.findElementById("drag");
		WebElement drop_element = UI.findElementById("drop");
		
//		Actions actions = new Actions(driver);
//		actions.dragAndDrop(logo, drop_element).build().perform();
		
		UI.dragAndDrop(logo, drop_element);
		
		
	}
}
