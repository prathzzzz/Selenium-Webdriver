package Elements.Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleAlerts {
    public static void main(String[] args) throws InterruptedException {
        // Initialize Chrome WebDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set an implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the webpage containing JavaScript alerts
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Handle simple alert with OK button
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click(); // Locate and click the button
        Thread.sleep(3000); // Wait to observe the alert (for demonstration)
        driver.switchTo().alert().accept(); // Switch to the alert and accept it (OK button)

        // Handle alert with OK and Cancel buttons
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click(); // Locate and click the button
        Thread.sleep(3000); // Wait to observe the alert (for demonstration)
        driver.switchTo().alert().dismiss(); // Switch to the alert and dismiss it (Cancel button)

        // Handle alert with input box
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click(); // Locate and click the button
        Thread.sleep(3000); // Wait to observe the alert (for demonstration)
        Alert inputAlert = driver.switchTo().alert(); // Switch to the alert
        inputAlert.sendKeys("Crazyyyyyyyyyyy"); // Send input to the alert
        Thread.sleep(3000); // Wait to observe the input
        inputAlert.accept(); // Accept the alert (OK button)

        // Optional: Close the browser after execution
        driver.quit();
    }
}
