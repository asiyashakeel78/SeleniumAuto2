package config;

import org.openqa.selenium.WebDriver;
import utilities.LoggerUtility;
import utilities.ScreenshotUtility;
import basePage.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Initialize WebDriver using a factory method
        LoggerUtility.info("Starting a new test scenario.");
        driver = BasePage.getDriver("edge");
        if (driver != null) {
            LoggerUtility.info("WebDriver has been initialized successfully.");
        } else {
            LoggerUtility.error("WebDriver initialization failed.");
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Log the failure
            LoggerUtility.error("Scenario failed: " + scenario.getName());

            // Take a screenshot and save it to a file
            String screenshotPath = "logs/screenshots/" + scenario.getName().replaceAll(" ", "_") + ".png";
            ScreenshotUtility.takeScreenshot(driver, screenshotPath);
            LoggerUtility.info("Screenshot saved to " + screenshotPath);
        }

        // Close the WebDriver
        if (driver != null) {
            driver.quit();
            LoggerUtility.info("WebDriver has been closed.");
        }
    }
}
