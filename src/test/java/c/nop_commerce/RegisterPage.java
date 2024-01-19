package c.nop_commerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RegisterPage {
    private  WebDriver driver;

    //Locators
    private By nameField = By.id("FirstName");
    private By lastNameField = By.id("LastName");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By confirmPasswordField = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");

    private By errorMessageLocator = By.cssSelector("div.message-error.validation-summary-errors ul li");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnRegisterLink() {
        WebElement registerLink = driver.findElement(By.xpath("//a[@class='ico-register']"));
        registerLink.click();
    }
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void clickOnRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public String getConfirmationMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.result")));
        return driver.findElement(By.cssSelector("div.result")).getText();

    }

    public String getErrorMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        return driver.findElement(errorMessageLocator).getText();
    }




}