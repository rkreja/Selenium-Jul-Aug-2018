package net.timeandtraining;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AbdusAzad {
	static WebDriver driver;
	
	
	@BeforeSuite
	public static void init() {
		//setup our driver		
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//setup done
	}
	
	@Test
	public void Login03() {
		
		
		

		
	
		//Step 1	Go to http://www.automationpractice.com
		driver.get("http://automationpractice.com/index.php?");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step 2	Click Sign in button from top right corner of the page
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step 3	Enter valid email address 'abc213@mailinator.com' in email address text field of right side
		driver.findElement(By.id("email")).sendKeys("abc213@mailinator.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step 4	Enter valid password 'abc1234' in password text field
		driver.findElement(By.id("passwd")).sendKeys("abc1234");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step 5	Click 'Sign in' button
		driver.findElement(By.id("SubmitLogin")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step 6 Verify 'MY ACCOUNT' text displayed
		String account_text = driver.findElement(By.xpath("//SPAN[@class='navigation_page'][text()='My account']")).getText();
		System.out.println(account_text);
		Assert.assertEquals(account_text, "My account");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step 7	Verify 'Welcome to your account. Here you can manage all of your personal information and orders.' text displayed
		String welcome_text = driver.findElement(By.xpath("//p[@class='info-account']")).getText();
		System.out.println(welcome_text);
		Assert.assertEquals(welcome_text, "Welcome to your account. Here you can manage all of your personal information and orders.");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step 8	Verify 'My personal information' text displayed
		String personal_info_text = driver.findElement(By.xpath("//SPAN[text()='My personal information']")).getText();
		System.out.println(personal_info_text);
		Assert.assertEquals(personal_info_text, "MY PERSONAL INFORMATION");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step 9	Click 'Sign out' button from top right corner
		driver.findElement(By.xpath("//a[@title='Log me out']")).click();
		
		driver.quit();
		


		
		
		
		
		
		
		
		
	}

	
	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(99);
	String randomUserId=randomInt+"autoUser@mailinator.com";
		
		@Test
		
		public void RegistrationNewAccount() {
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//Step 1	Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");
			
		//Step 2	Click Sign in button from top right corner of the page
		driver.findElement(By.xpath("//a[@class='login']")).click(); 
			
		//Step 3	Enter email address 'abc@mailinator.com' in email address text field of left side above "Create an account" button.
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("abc@mailinator.com");

		//Step 4	Click create an account button
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
			
		//Step 5: Verify error message displayed 'An account using this email address has already been registered. Please enter a valid password or request a new one.'
		String registered_error = driver.findElement(By.xpath("//LI[text()='An account using this email address has already been registered. Please enter a valid password or request a new one. ']")).getText();
		System.out.println("Finding registered error is: " +registered_error);
		Assert.assertEquals(registered_error, "An account using this email address has already been registered. Please enter a valid password or request a new one.");
				
		//Step#6--Enter a valid email address (auto) in email address text field. (You can use xxxxxxx@mailinator.com)
		//driver.findElement(By.xpath("//input[@id='email_create']")).clear();
		//driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("aza012" + randomInt + "abd@gmail.com");
		
		//Step 6	Enter a valid email address (manual) in email address text field. (You can use 10*-Sharp@mailinator.com)
		driver.findElement(By.xpath("//input[@id='email_create']")).clear();
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(randomUserId);
		
		//Step 7	Click create an account button
	    driver.findElement(By.id("SubmitCreate")).click();
	       
	    //Step 8	Click 'Register' button
	    driver.findElement(By.xpath("//button[@id='submitAccount']")).click();

	    
	    
	 
		  //Step 9	Verify error message displayed 'You must register at least one phone number.'
		  //Step 10	Verify error message displayed 'lastname is required.'
		  //Step 11	Verify error message displayed 'firstname is required.'
		  //Step 12	Verify error message displayed 'passwd is required.'
		  //Step 13	Verify error message displayed 'address1 is required.'
		  //Step 14	Verify error message displayed 'city is required.'
		  //Step 15	Verify error message displayed 'The Zip/Postal code you've entered is invalid. It must follow this format: 00000'
		  //Step 16	Verify error message displayed 'This country requires you to choose a State.'
	    
	    //to verify all the message at once we can loop, store all the msgs in array and verify each using for loop
	    String errorMsgs=driver.findElement(By.xpath("//ol[preceding-sibling::p[contains(text(),'There are 8 errors')]]")).getText();
	   
	    String[] msgsToVerify= {
	    		"You must register at least one phone number.",
	    		"lastname is required.",
	    		"firstname is required.",
	    		"passwd is required.",
	    		"address1 is required.",
	    		"city is required.",
	    		"The Zip/Postal code you've entered is invalid. It must follow this format: 00000",
	    		"This country requires you to choose a State."
	    };
	    
	    
	    for(int i=0;i<msgsToVerify.length;i++) {
	    	Assert.assertEquals(errorMsgs.contains(msgsToVerify[i]), true, "Check error message contains text: "+ msgsToVerify[i]);
	    }
	    
	    
	    
	    //Step 17	Select 'Mr' radio button
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
	    
		//Step 18	Enter First name as 'John'
	    driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("John");
	       
	    //Step 19	Enter Last name as 'Smith'
	    driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Smith");
	      
	    //Step 20	Verify Email text box has email address defined as used in step 6
	    String emailaddress_text = driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value");
	    System.out.println("The email id is: " + emailaddress_text);
	    Assert.assertEquals(emailaddress_text, randomUserId);
	    
	    //OR repeat Step 20	Verify Email text box has email address defined as used in step 6 
	    boolean displayed = driver.findElement(By.xpath("//input[@id='email']")).isDisplayed();
	    boolean enabled = driver.findElement(By.xpath("//input[@id='email']")).isEnabled();
	    
	    if (displayed) {
	    System.out.println("Email address text is displayed");		
	    } else {
	    System.out.println("Email addrress text not displayed");
	    }
	    if (enabled) {
	    System.out.println("Email address text is enabled");		
	    } else {
	    System.out.println("Email addrress text not enadled");
	    }
	    
	    //OR repeat Step 20	Verify Email text box has email address defined as used in step 6     
	   
	    try {
	    	driver.findElement(By.xpath("//input[@id='email']"));
	    	System.out.println("Email ID text found");
	    }
	    catch(NoSuchElementException e) {
	    	System.out.println("Email ID text not found");
	    }
	          
	    //Step 21	Enter password as 'MyStrong_Password'
	    driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("MyStrong_Password");
	       
	    //Step 22	Select day 15 from day drop down
	    Select day = new Select (driver.findElement(By.id("days")));
		day.selectByIndex(15);
			
		//Step 23	Select month September from month drop down
		Select month = new Select (driver.findElement(By.xpath("//select[@id='months']")));
		month.selectByIndex(9);
			
		//Step 24	Select year 1984 from year dropdown
		Select year = new Select (driver.findElement(By.id("years")));
		year.selectByValue("1984");
		
		//Step 25	Verify First name text field below has first name defined as used in step 18
		String firstname_text = driver.findElement(By.xpath("//input[@id='firstname']")).getAttribute("value");
		System.out.println("The first name text is: " + firstname_text);
		Assert.assertEquals(firstname_text, "John");

		//OR
		//Step 25	Verify First name text field below has first name defined as used in step 18
		try {
			driver.findElement(By.xpath("//input[@id='firstname']"));
	    	System.out.println("First name text found");
	    }
	    catch(NoSuchElementException e) {
	    	System.out.println("First name text not found");
	    }	
		
		//Step 26	Verify Last name text field below has last name defined as used in step 19
		String lastname_text = driver.findElement(By.xpath("//input[@id='lastname']")).getAttribute("value");
		Assert.assertEquals(lastname_text, "Smith");
		System.out.println("The first name text is: " + lastname_text);

		//OR
		//Step 26	Verify Last name text field below has last name defined as used in step 19
		try {
			driver.findElement(By.xpath("//input[@id='lastname']"));
	    	System.out.println("Last name text found");
	    }
	    catch(NoSuchElementException e) {
	    	System.out.println("Last name text not found");
	    }
		
		//Step 27	Enter Company as 'Time and Training' in Company text field
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Time and Training");
		
		//Step 28	Enter address as '123 abc street' in address text field
		driver.findElement(By.id("address1")).sendKeys("123 abc street");
		
		//Step 29	Enter city New York in city text field
		driver.findElement(By.id("city")).sendKeys("New York");
		
		//Step 30	Select state New York from state drop down
		Select state = new Select (driver.findElement(By.id("id_state")));
		state.selectByVisibleText("New York");
		
		//Step 31	Enter '10001' in Zip/Postal Code text field
		driver.findElement(By.id("postcode")).sendKeys("10001");
		
		//Step 32	Select country United States from country dropdown
		Select country = new Select (driver.findElement(By.id("id_country")));
	    country.selectByVisibleText("United States");

		//Step 33	Enter text 'Registering an account with all fields' in Additional information text area
	    driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("Registering an account with all fields");
	    
	    //Step 34	Enter '7031234567' in Home Phone text field
	    driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("7031234567");
	    
	    //Step 35	Enter Enter '7039876543214' in Mobile phone text field
	    driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("7039876543214");
	    
	    //Step 36	Replace text 'My Address' to 'Home' in Assign an address alias for future reference text field
	    driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("My Address to Home");
	    
	    //Step 37	Click 'Register' button
	    driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
	    
	    //Step 38	Verify 'MY ACCOUNT' text displayed
	    String my_account_header = driver.findElement(By.xpath("//H1[@class='page-heading'][text()='My account']")).getText();
	    System.out.println("The account header text is: " + my_account_header);
	    Assert.assertEquals(my_account_header, "MY ACCOUNT");
	   
	   
	   //Step 39	Verify 'Welcome to your account. Here you can manage all of your personal information and orders.' text displayed
	    String welcome_header = driver.findElement(By.xpath("//P[@class='info-account'][text()='Welcome to your account. Here you can manage all of your personal information and orders.']")).getText();
	    System.out.println("The Welcome header text is: " + welcome_header);
	    Assert.assertEquals(welcome_header, "Welcome to your account. Here you can manage all of your personal information and orders.");
	   
	      
	   //Step 40	Verify 'My personal information' text displayed
	    String my_personasl_info = driver.findElement(By.xpath("//SPAN[text()='My personal information']")).getText();
	    System.out.println("My personal info text is: " + my_personasl_info);
	    Assert.assertEquals(my_personasl_info, "MY PERSONAL INFORMATION");
	       
	   //Step 41	Click 'Sign out' button from top right corner
	    driver.findElement(By.xpath("//a[@class='logout']")).click();
	        
	    driver.quit();
	   
		}



}
