import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitDemo {
    public static void main(String[] args) {

        // Initialize the WebDriver instance
        WebDriver driver = new ChromeDriver();

        // 1. Explicit Wait:
        // Explicit wait allows you to specify a condition to wait for a particular web element.
        // It pauses the execution until the specified condition is met or the timeout duration is exceeded.
        // Explicit wait is applied only to specific elements, making it more flexible than implicit wait.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to the OrangeHRM login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // 2. Wait until the username input field is visible:
        // The 'visibilityOfElementLocated' condition waits until the element is visible on the page.
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Username']")));
        usernameInput.sendKeys("Admin"); // Input the username once the field is visible

        // 3. Wait until the password input field is visible:
        // This ensures the password field is present and visible before interacting with it.
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Password']")));
        passwordInput.sendKeys("admin123"); // Input the password

        // 4. Wait until the 'Login' button is clickable:
        // The 'elementToBeClickable' condition ensures the button is enabled and ready for interaction.
        WebElement isClickable = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Login']")));
        isClickable.click(); // Click the button once it becomes clickable

        // Close the browser (optional, but good practice)
//        driver.quit();
    }
}
