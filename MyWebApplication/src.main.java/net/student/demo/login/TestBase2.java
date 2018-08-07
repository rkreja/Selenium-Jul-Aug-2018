package net.student.demo.login;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase2 {
	
	
	@BeforeSuite
	public void init() {
		System.out.println("I run before suite starts");
	}
	
	
	
	@AfterSuite
	public void closeBrowser() {
		System.out.println("I run after suite ends");
	}
	
	
	@BeforeMethod
	public void bm() {
		System.out.println("I run before each test starts");	
	}
	

}
