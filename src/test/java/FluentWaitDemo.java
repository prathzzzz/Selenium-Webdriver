import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class FluentWaitDemo {
    public static void main(String[] args) {
        // Initialize the WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window for better visibility
        driver.manage().window().maximize();

        // 1. Fluent Wait Declaration:
        // Fluent Wait allows you to define:
        // - A maximum amount of time to wait for a condition.
        // - A frequency to check the condition (polling interval).
        // - Exceptions to ignore while waiting (e.g., NoSuchElementException).
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))          // Maximum wait time (30 seconds)
                .pollingEvery(Duration.ofSeconds(5))          // Polling interval (check every 5 seconds)
                .ignoring(NoSuchElementException.class);      // Ignore NoSuchElementException during polling

        // Navigate to the OrangeHRM login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // 2. Wait until the username input field is located:
        // Fluent Wait checks the condition using the `apply` method.
        // Here, it repeatedly searches for the username input field within the timeout and polling intervals.
        WebElement username = wait.until(driver1 -> driver1.findElement(By.xpath("//input[@placeholder='Username']")));

        // Input text into the username field
        username.sendKeys("Admin");

        // 3. Wait until the password input field is located:
        // The same Fluent Wait logic is applied to find the password field.
        WebElement password = wait.until(driver2 -> driver2.findElement(By.xpath("//input[@placeholder='Password']")));

        // Input text into the password field
        password.sendKeys("admin123");

        // Optionally close the browser after the test (good practice)
        driver.quit();
    }
}
