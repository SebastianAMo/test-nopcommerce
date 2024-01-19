package c.nop_commerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    private WebDriver driver;

    private By emailField = By.id("Email");

    private By passwordField = By.id("Password");

    private By loginButton = By.xpath("//button[@type='submit']  [@class='button-1 login-button']");

    private By errorMessageLocator = By.xpath("//div[@class='message-error validation-summary-errors']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLoginLink() {
        driver.findElement(By.linkText("Log in")).click();
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void checkProfilePage() {
        driver.findElement(By.linkText("My account")).click();
    }

    public String getErrorMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        return driver.findElement(errorMessageLocator).getText();
    }




}