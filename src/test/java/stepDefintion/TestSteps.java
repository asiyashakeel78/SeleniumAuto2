package stepDefintion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSteps {
	
	WebDriver driver;

	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
        // Setup the ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
            
        driver.get("https://practicetestautomation.com/practice-test-login/");

	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() {
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("student");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Password123");
		
		
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {

		driver.findElement(By.xpath("//*[@id='submit']")).click();
	}

	@Then("user is navigated to the dashboard page")
	public void user_is_navigated_to_the_dashboard_page() {
	    String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/"; 
	    String actualUrl = driver.getCurrentUrl();
	    Assert.assertEquals(actualUrl, expectedUrl, "User is not on the expected login page URL.");
	    
	    driver.quit();
	}

}
