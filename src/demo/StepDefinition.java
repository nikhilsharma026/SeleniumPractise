package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	WebDriver driver;

@Given("^Browser and application is opened$")
public void Browser_and_application_is_opened() throws Throwable {
	
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com");
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    
}

// Data driven without Examples keyword

@When("^User enters valid \"([^\"]*)\" and \"([^\"]*)\"$")
public void User_enters_valid_and(String username,String password){
    WebElement usermail = driver.findElement(By.xpath("//input[@type='email']"));
    usermail.clear();
    usermail.sendKeys(username);
    WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
    pass.sendKeys(password);
    pass.submit();
    System.out.println("Entered the credentials");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
}

@Then("^Navigate to homepage and verify title$")
public void Navigate_to_homepage_and_verify_title() throws Throwable {
    if(driver.getTitle().equalsIgnoreCase("Facebook"))
    	System.out.println("HOmepage verified");
    else
    	System.out.println("Did not login successfully");
}

@Then("^close the browser$")
public void Close_the_browser() throws Throwable {
    driver.quit();
}

@Given("^user enters valid \"([^\"]*)\" and \"([^\"]*)\"$")
public void user_enters_valid_and(String Username,String Password) {
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com");
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	 WebElement usermail = driver.findElement(By.xpath("//input[@type='email']"));
	    usermail.clear();
	    usermail.sendKeys(Username);
	    WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
	    pass.sendKeys(Password);
	    pass.submit();
	    System.out.println("Entered the credentials");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@When("^user scrolls vertically$")
public void user_scrolls_vertically() throws Throwable {
   JavascriptExecutor js= (JavascriptExecutor)driver;
 js.executeScript("scroll(0,1200)");  
 Thread.sleep(5000);
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Then("^exit the browser$")
public void close_the_browser() throws Throwable {
    driver.quit();
    
}




}
