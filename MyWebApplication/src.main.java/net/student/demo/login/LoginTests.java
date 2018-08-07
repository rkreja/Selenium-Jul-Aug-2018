package net.student.demo.login;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import net.timeandtraining.framework.OurUtil;

public class LoginTests extends TestBase2{

	
	
	@Test	
	@Parameters({"userid","pwd"})	
	public void loginTest(String userid, String password) {
		String converted = OurUtil.decodePassword(password);
		System.out.println("Login with user id: "+userid);
		System.out.println("Login with password: "+converted);
	}
	
		
	@Test
	@Parameters({"userid2","pwd2"})
	public void loginTestTwo(String userid, String password) {		
		System.out.println("Login with user id: "+userid);
		System.out.println("Login with password: "+password);
	}
	
	@Test
	public void loginTestThree() {
		System.out.println("i am test three");
	}
	@Test
	public void loginTestFour() {
		System.out.println("i am test four");
	}
	@Test
	public void loginTestFive() {
		System.out.println("i am test five");
	}
	//candidate of smoke test
	@Test
	public void loginTestSix() {
		System.out.println("i am test six");
	}
	@Test
	public void loginTestSeven() {
		System.out.println("i am test seven");
	}
	@Test
	public void loginTestEight() {
		System.out.println("i am test eight");
	}
	//candidate of smoke test
	@Test
	public void loginTestNine() {
		System.out.println("i am test nine");
	}
	@Test
	public void loginTestTen() {
		System.out.println("i am test ten");
	}
	

}
