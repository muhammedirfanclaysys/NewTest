package NewPr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Pom {
    private WebDriver driver;
    private WebDriverWait wait;
    private boolean allAssertionsPassed = true;

    public Pom(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void TextField() {
        WebElement field = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']")));
        allAssertionsPassed &= field.isDisplayed();
        System.out.println("Textfield field is displayed with default value: " + field.getAttribute("value"));
    }

    public void PasswordField() {
        WebElement field = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
        allAssertionsPassed &= field.isDisplayed();
        System.out.println("Password field is displayed with default value: " + field.getAttribute("value"));
    }

    public void TextArea() {
        WebElement field = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@name='comments']")));
        allAssertionsPassed &= field.isDisplayed();
        System.out.println("Textarea field is displayed with default value: " + field.getAttribute("value")+"\n");
    }

    public void Checkbox() {
        WebElement seleniumCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@value,'cbselenium')]")));
        allAssertionsPassed &= seleniumCheckbox.isDisplayed();
        System.out.println("Selenium checkbox field is displayed.");
        System.out.println("Selenium checkbox is selected: " + seleniumCheckbox.isSelected());

        WebElement qtpCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@value,'cbqtp')]")));
        allAssertionsPassed &= qtpCheckbox.isDisplayed();
        System.out.println("QTP checkbox field is displayed.");
        System.out.println("QTP checkbox is selected: " + qtpCheckbox.isSelected());

        WebElement loadRunnerCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@value,'cbloadrunner')]")));
        allAssertionsPassed &= loadRunnerCheckbox.isDisplayed();
        System.out.println("LoadRunner checkbox field is displayed.");
        System.out.println("LoadRunner checkbox is selected: " + loadRunnerCheckbox.isSelected()+"\n");
    }

    public void RadioButton() {
        WebElement seleniumRadio = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@value,'cbselenium')]")));
        allAssertionsPassed &= seleniumRadio.isDisplayed();
        System.out.println("Selenium radio button field is displayed.");
        System.out.println("Selenium radio button is selected: " + seleniumRadio.isSelected());

        WebElement qtpRadio = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@value,'cbqtp')]")));
        allAssertionsPassed &= qtpRadio.isDisplayed();
        System.out.println("QTP radio button field is displayed.");
        System.out.println("QTP radio button is selected: " + qtpRadio.isSelected());

        WebElement loadRunnerRadio = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@value,'cbloadrunner')]")));
        allAssertionsPassed &= loadRunnerRadio.isDisplayed();
        System.out.println("LoadRunner radio button field is displayed.");
        System.out.println("LoadRunner radio button is selected: " + loadRunnerRadio.isSelected()+"\n");
    }

    public void MultipleSelect() {
        WebElement multipleSelect = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[contains(@name,'multipleselect[]')]")));
        allAssertionsPassed &= multipleSelect.isDisplayed();
        Select select = new Select(multipleSelect);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println("Selected option: " + option.getText());
        }

        System.out.println("\n");


    }

    public void Dropdown() {
        WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[contains(@name,'dropdown')]")));
        allAssertionsPassed &= dropdown.isDisplayed();
        Select selectDropdown = new Select(dropdown);
        WebElement defaultSelectedOption = selectDropdown.getFirstSelectedOption();
        System.out.println("Default selected option in the dropdown: " + defaultSelectedOption.getText());
        List<WebElement> options = selectDropdown.getOptions();
        System.out.println("Options in the dropdown:");
        for (WebElement option : options) {
            System.out.println("- " + option.getText());
        }

        System.out.println("\n");
    }

    public void DateField() {
        WebElement dobField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@name,'bday')]")));
        allAssertionsPassed &= dobField.isDisplayed();
        String defaultValue = dobField.getAttribute("value");
        System.out.println("Date field default value is: " + defaultValue+"\n");
    }

    public void FileUpload() {
        WebElement fileUpload = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@name,'file')]")));
        allAssertionsPassed &= fileUpload.isDisplayed();
        allAssertionsPassed &= fileUpload.isEnabled();
        System.out.println("File Upload field is displayed and clickable."+"\n");
    }

    public void DownloadLinks() {
        String[] fileTypes = {"Text File", "Doc File", "PDF File", "Excel File", "CSV File"};
        for (String fileType : fileTypes) {
            WebElement downloadLink = driver.findElement(By.xpath("//a[contains(text(),'Download " + fileType + "')]"));
            allAssertionsPassed &= downloadLink.isDisplayed();
            System.out.println("Download link for " + fileType + ": " + downloadLink.getAttribute("href"));
        }

        System.out.println("\n");
    }

    public void Table() {
        WebElement table = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table")));
        allAssertionsPassed &= table.isDisplayed();
        System.out.println("Table field is displayed.");

        List<WebElement> headers = table.findElements(By.xpath(".//th"));
        System.out.println("Table Headers:");
        for (WebElement header : headers) {
            System.out.println(header.getText()+"\n");
        }

        List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        System.out.println("Table Rows:");
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.xpath(".//td"));
            for (WebElement column : columns) {
                System.out.print(column.getText() + "\t");
            }
            System.out.println("\n");
        }
    }

    public void Button() {
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@value,'Button')]")));
        allAssertionsPassed &= button.isDisplayed();
        allAssertionsPassed &= button.isEnabled();
        System.out.println("Button is displayed and clickable."+"\n");
    }

    public boolean allAssertionsPassed() {
        return allAssertionsPassed;
    }
}
