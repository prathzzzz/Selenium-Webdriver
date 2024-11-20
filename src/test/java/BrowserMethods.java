import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserMethods {
    public static void main(String[] args) {
        // Set up WebDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window for better visibility
        driver.manage().window().maximize();

        try {
            // Navigate to the nopCommerce demo register page
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            // Set up an explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait for the element with the link text to be clickable and click it
            WebElement orangeHRMLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.linkText("OrangeHRM, Inc") // Corrected the locator
            ));
            orangeHRMLink.click();

            // Perform actions after clicking the link (if any)

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser (all windows)
            driver.quit();
            // Close single instance
            driver.close();
        }
    }
}
