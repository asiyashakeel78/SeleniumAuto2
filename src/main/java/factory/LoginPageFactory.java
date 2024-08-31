package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

    private WebDriver driver;

    // Locators using @FindBy
    @FindBy(id = "username")
    private WebElement usernameField;//initializing private webElement

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "submit")
    private WebElement loginButton;

    // Constructor get implicitly invoked and initialize the WebElements
    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        // Initialize elements with PageFactory
        PageFactory.initElements(driver, this);//initialize xpath with driver,driver will never be null or empty
    }

    // Page Actions
    public void enterUsername(String username) { //public method is created using private variable this is getter method
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
