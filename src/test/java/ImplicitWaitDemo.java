import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicitWaitDemo {
    public static void main(String[] args) {

        // Initialize the WebDriver instance
        WebDriver driver = new ChromeDriver();
        // 1. Implicit Wait:
        // Implicit wait is used to define a default waiting time for the WebDriver instance.
        // It instructs WebDriver to wait for the specified duration for an element to appear in the DOM
        // (Document Object Model) before throwing a "NoSuchElementException."
        // If the element is found before the timeout, WebDriver proceeds immediately.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Maximize the browser window for better visibility
        driver.manage().window().maximize();

        // Navigate to the OrangeHRM login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Attempt to find the username input field and input "admin"
        // If the element isn't immediately available, WebDriver will keep checking
        // until the specified wait time (5 seconds) elapses.
        driver.findElement(By.xpath("//input[@placeholder='username']")).sendKeys("admin");

        // Close the browser (optional, but good practice)
        driver.quit();
    }
}
