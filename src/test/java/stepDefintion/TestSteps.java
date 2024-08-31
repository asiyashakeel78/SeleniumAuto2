package stepDefintion;

import org.openqa.selenium.WebDriver;

import factory.LoginPageFactory;
import basePage.BasePage;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ScreenshotUtility;

public class TestSteps {
    
    public WebDriver driver;
    private LoginPageFactory loginPage;  // Reference(object of a class) to the LoginPage or instance of class

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        
        driver = BasePage.getDriver("chrome");
        driver.get("https://practicetestautomation.com/practice-test-login/");
        loginPage = new LoginPageFactory(driver); // Initialize the login page object,i refrence the object to use the methods in pageFactory OR constructor is invoked
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.enterUsername("student");
        loginPage.enterPassword("Password123");
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("user is navigated to the dashboard page")
    public void user_is_navigated_to_the_dashboard_page() {
        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl = loginPage.getCurrentUrl();
        try {//try catch finally block
            Assert.assertEquals(actualUrl, expectedUrl, "User is not on the expected login page URL.");
        } catch (AssertionError e) {
            ScreenshotUtility.takeScreenshot(driver, "screenshots/failure-screenshot.png");
            throw e;  // Rethrow to allow Cucumber to handle the failure
        } finally {
            driver.quit();
        }
    }
}
