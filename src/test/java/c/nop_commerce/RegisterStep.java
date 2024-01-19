package c.nop_commerce;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class RegisterStep {

    private WebDriver driver;

    private RegisterPage registerPage;
    @Given("A user navigates to the registration page")
    public void aUserNavigatesToTheRegistrationPage() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue

        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        registerPage = new RegisterPage(driver);
        registerPage.clickOnRegisterLink();
    }

    @When("User enters valid name {string}")
    public void user_enters_valid_name(String name) {
        registerPage.setName(name);
    }

    @And("User enters valid last name {string}")
    public void user_enters_valid_last_name(String lastName) {
        registerPage.setLastName(lastName);
    }

    @And("User enters valid email {string}")
    public void user_enters_valid_email(String email) {
        registerPage.setEmail(email);
    }

    @And("User enters valid password {string}")
    public void user_enters_valid_password(String password) {
        registerPage.setPassword(password);
    }

    @And("User enters valid confirm password {string}")
    public void user_enters_valid_confirm_password(String confirmPassword) {
        registerPage.setConfirmPassword(confirmPassword);
    }

    @When("User clicks on the register button")
    public void user_clicks_on_register_button() {
        registerPage.clickOnRegisterButton();
    }

    @Then("User should be taken to the successful registration page")
    public void user_should_be_taken_to_the_successful_registration_page() {
        String expectedMessage = "Your registration completed";
        String actualMessage = registerPage.getConfirmationMessage();
        assertEquals(expectedMessage, actualMessage);
        driver.close();
        driver.quit();
    }

    @Then("User should be see the message \"The specified email already exists\"")
    public void user_should_be_see_the_message_the_specified_email_already_exists() {
        String expectedMessage = "The specified email already exists";
        String actualMessage = registerPage.getErrorMessage();
        assertEquals(expectedMessage, actualMessage);
        driver.close();
        driver.quit();
    }







}
