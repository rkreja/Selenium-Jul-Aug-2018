package net.timeandtraining.misc;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class JavaScriptExecutorDemo extends TestBase{
	
	
	@Test
	public void javaScriptExecution() {
		
		
		UI.openURL("http://automationpractice.com/index.php");
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.getElementById('search_query_top').value='Hello';");
		
		
		
	}
}
