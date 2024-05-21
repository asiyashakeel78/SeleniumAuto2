package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WebDriverUtility {

    private WebDriver driver;
    private WebDriverWait wait;

    public WebDriverUtility(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Using Duration for Selenium 4 and above
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void clickElement(WebElement element) {
        highlightElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void enterText(WebElement element, String text) {
        highlightElement(element);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public void waitForElementVisible(WebElement element) {
        highlightElement(element);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    // Method to highlight an element
    private void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        try {
            Thread.sleep(500); // Pause to allow the highlight to be visible for a short time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupt status
        }
        js.executeScript("arguments[0].setAttribute('style', '');", element);
    }
}
