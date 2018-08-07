package net.student.demo.registration;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class RegistrationTests extends TestBase{
	
	@Test
	public void RegistrationTestOne() {
		
		UI.openURL("http://automationpractice.com/index.php");
		
		
		
		
		List<WebElement> elements= driver.findElements(By.xpath("//option[parent::select[@id='id_state']]"));
		int total_states=elements.size();
		for (int i = 0; i < total_states; i++) {
		System.out.println(elements.get(i).getText());
		}
		//int total_states=elements.size();
		//Virginia
		
		//District of Columbia
//		for (int i = 0; i < total_states; i++) {
//			
////			if(elements.get(i).getText().equals("Virginia") || elements.get(i).getText().equals("District of Columbia")) {
////				System.out.println(elements.get(i).getText());	
////			}
//			
//			if(elements.get(i).getText().startsWith("A")) {
//				System.out.println(elements.get(i).getText());		
//			}
//			
//			
//			
//		}
		
		
		
		
	}
	@Test
	public void RegistrationTestTwo() {
		
	}
	@Test
	public void RegistrationTestThree() {
		
	}
	@Test
	public void RegistrationTestFour() {
		
	}
	@Test
	public void RegistrationTestFive() {
		
	}
	@Test
	public void RegistrationTestSix() {
		
	}
	@Test
	public void RegistrationTestSeven() {
		
	}
	@Test
	public void RegistrationTestEight() {
		
	}
	@Test
	public void RegistrationTestNine() {
		
	}
	@Test
	public void RegistrationTestTen() {
		
	}
	
}
