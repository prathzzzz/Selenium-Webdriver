package Elements.Inputs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleCheckboxes {
    public static void main(String[] args) throws InterruptedException {
        // Initialize Chrome WebDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window for better visibility
        driver.manage().window().maximize();

        // Set an implicit wait to handle dynamic loading of elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the test website
        driver.get("https://testautomationpractice.blogspot.com/");

        // Example: Click on a single checkbox (uncomment to test)
        // driver.findElement(By.xpath("//label[@for='sunday']")).click();

        // Fetch all checkbox elements on the page using a common XPath
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

        // Example: Select all checkboxes (uncomment to test)
        // for (WebElement checkbox : checkboxes) {
        //     checkbox.click();
        // }

        // Example: Select the last 3 checkboxes (uncomment to test)
        // for (int i = 4; i < checkboxes.size(); i++) {
        //     checkboxes.get(i).click();
        // }

        // Select the first 3 checkboxes
        for (int i = 0; i < 3; i++) {
            checkboxes.get(i).click();
        }

        // Pause for 10 seconds to observe selected checkboxes
        Thread.sleep(10000);

        // Unselect any checkboxes that are currently selected
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }

        // Close the browser
        driver.quit();
    }
}
