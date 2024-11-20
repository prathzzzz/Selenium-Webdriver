import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindows {
    public static void main(String[] args) throws InterruptedException {
        // Initialize WebDriver for Chrome and maximize the browser window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Set implicit wait to handle elements that may take time to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the login page of OrangeHRM
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Click on the "OrangeHRM, Inc" link which opens a new browser window/tab
        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

        // Get all window handles currently open by the browser
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Window Handles: " + windowHandles);

        // Convert the Set of window handles to a List for easier access by index
        List<String> windowId = new ArrayList<>(windowHandles);

        // Adding a small delay to ensure the new window/tab has loaded
        Thread.sleep(10);

        // Iterate through all open windows/tabs
        for (String id : windowId) {
            System.out.println("Switching to window: " + id);

            // Switch to each window by its handle and get the page title
            String title = driver.switchTo().window(id).getTitle();

            // Print the URL of the current window/tab
            if (title.equals("OrangeHRM")) {
                // If the title matches, it's the new window
                System.out.println("URL of OrangeHRM window: " + driver.getCurrentUrl());
            } else {
                // Otherwise, print the URL of the original window
                System.out.println("URL of the other window: " + driver.getCurrentUrl());
            }
        }




        driver.quit(); // Close all windows and terminate the session
    }
}
