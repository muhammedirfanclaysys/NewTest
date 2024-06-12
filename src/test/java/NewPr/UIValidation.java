package NewPr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class UIValidation {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\muhammed.irfan\\OneDrive - ClaySys.CO\\Desktop\\Automation\\chromedriver.exe");


        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.softwaretestingmaterial.com/sample-webpage-to-automate/");
        driver.manage().window().maximize();

    }

    @Test(priority=1)
    public void testUIElementsPresence() {
        WebElement textField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']")));
        Assert.assertTrue(textField.isDisplayed(), "Textfield is not displayed.");
        System.out.println("Textfield field is displayed.");



        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
        Assert.assertTrue(passwordField.isDisplayed(), "password field is not displayed.");
        System.out.println("Password field is displayed.");

        WebElement textArea = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@name='comments']")));
        Assert.assertTrue(textArea.isDisplayed(), "textarea field is not displayed.");
        System.out.println("Textarea field is displayed.");

    }

    @Test(priority=2)
    public void Checkbox() {



        WebElement checkbox1 = driver.findElement(By.xpath("//p[contains(text(),'Checkbox:')]"));
        String checkboxx=  checkbox1.getText();
        System.out.println("Checkbox field contains"+checkboxx);

        WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@value,'cbselenium')]")));
        Assert.assertTrue(checkbox.isDisplayed(), "selenium field is not displayed.");
        System.out.println("selenium field is displayed.");






    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
