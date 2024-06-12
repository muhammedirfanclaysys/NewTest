package NewPr;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class UI {


    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.softwaretestingmaterial.com/sample-webpage-to-automate/");
    }

    @Test
    public void testUIElementsPresence() {
        // Wait for the Full Name field to be present and check if it is displayed
        WebElement fullNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']")));
        Assert.assertTrue(fullNameField.isDisplayed(), "Full Name field is not displayed.");
        System.out.println("Full Name field is displayed.");

        // Wait for the Email field to be present and check if it is displayed
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
        Assert.assertTrue(emailField.isDisplayed(), "Email field is not displayed.");
        System.out.println("Email field is displayed.");

        // Wait for the Password field to be present and check if it is displayed
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@name='comments']")));
        Assert.assertTrue(passwordField.isDisplayed(), "Password field is not displayed.");
        System.out.println("Password field is displayed.");

        // Wait for the Confirm Password field to be present and check if it is displayed
        WebElement confirmPasswordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@value,'cbselenium')]")));
        Assert.assertTrue(confirmPasswordField.isDisplayed(), "Confirm Password field is not displayed.");
        System.out.println("Confirm Password field is displayed.");
    }

  /*  @Test
    public void testFormSubmission() {
        // Wait for the Full Name field to be present and fill it out
        WebElement fullNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
        fullNameField.sendKeys("John Doe");

        // Wait for the Email field to be present and fill it out
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
        emailField.sendKeys("johndoe@example.com");

        // Wait for the Password field to be present and fill it out
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        passwordField.sendKeys("Password123");

        // Wait for the Confirm Password field to be present and fill it out
        WebElement confirmPasswordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpassword")));
        confirmPasswordField.sendKeys("Password123");

        // Wait for the Submit button to be present and click it
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("submit")));
        submitButton.click();

        // Wait for the success message to be present and check if it is displayed
        WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".success-message")));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message is not displayed.");
    } */

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
