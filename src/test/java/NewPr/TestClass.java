package NewPr;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClass {
    private WebDriver driver;
    private Pom pom;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.softwaretestingmaterial.com/sample-webpage-to-automate/");
        pom = new Pom(driver);
    }

    @Test(priority = 1)
    public void testTextField() {
        pom.TextField();
    }

    @Test(priority = 2)
    public void testPasswordField() {
        pom.PasswordField();
    }

    @Test(priority = 3)
    public void testTextArea() {
        pom.TextArea();
    }

    @Test(priority = 4)
    public void testCheckbox() {
        pom.Checkbox();
    }

    @Test(priority = 5)
    public void testRadioButton() {
        pom.RadioButton();
    }

    @Test(priority = 6)
    public void testMultipleSelect() {
        pom.MultipleSelect();
    }

    @Test(priority = 7)
    public void testDropdown() {
        pom.Dropdown();
    }

    @Test(priority = 8)
    public void testDateField() {
        pom.DateField();
    }

    @Test(priority = 9)
    public void testFileUpload() {
        pom.FileUpload();
    }

    @Test(priority = 10)
    public void testDownloadLinks() {
        pom.DownloadLinks();
    }

    @Test(priority = 11)
    public void testTable() {
        pom.Table();
    }

    @Test(priority = 12)
    public void testButton() {
        pom.Button();
    }

    @AfterClass
    public void tearDown() {
        Assert.assertTrue(pom.allAssertionsPassed(), "Some assertions failed.");

        if (driver != null) {
            driver.quit();
        }
    }
}

