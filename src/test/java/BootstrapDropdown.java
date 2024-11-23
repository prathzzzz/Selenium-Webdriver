import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class BootstrapDropdown {
    public static void main(String[] args) {
        // Initialize the WebDriver instance for Chrome browser
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window for better visibility
        driver.manage().window().maximize();

        // Set an implicit wait timeout to handle dynamic loading elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the Bootstrap dropdown demo webpage
        driver.get("https://jquery-az.com/boots/demo.php?ex=63.0_2");

        // Locate and click the multiselect dropdown button to display options
        driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();

        // Locate and select the checkbox corresponding to the "Java" option
        driver.findElement(By.xpath("//input[@value='Java']")).click();

        // Fetch all checkbox elements inside the dropdown
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        // Iterate through each checkbox
        for (WebElement checkbox : checkboxes) {
            // If a checkbox is selected, deselect it
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }

        // Close the browser session after operations (optional but recommended for cleanup)
        driver.quit();
    }
}
