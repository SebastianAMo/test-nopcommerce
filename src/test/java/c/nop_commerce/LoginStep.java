package c.nop_commerce;


import io.cucumber.java.en.*;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

public class LoginStep {

    private WebDriver driver;
    private LoginPage loginPage;
    @Given("the user is on the login page")
    public void aUserNavigatesToTheLoginPage() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue
        options.addArguments("--remote-allow-origins=*");
        try {
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get("https://demo.nopcommerce.com/");
            loginPage = new LoginPage(driver);
            loginPage.clickOnLoginLink();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @When("the user enters email {string} and password {string}")
    public void user_enters_valid_name(String email, String password) {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
    }

    @And("the user clicks the login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLoginButton();
    }

    @Then("the user is redirected to their profile page")
    public void user_is_redirected_to_their_profile_page() {
        loginPage.checkProfilePage();
        driver.close();
    }

    @Then("an error message \"Invalid username or password\" is displayed")
    public void an_error_message_is_displayed() {
        String errorMessage = loginPage.getErrorMessage();

        assertEquals("Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found", errorMessage);
        driver.close();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
