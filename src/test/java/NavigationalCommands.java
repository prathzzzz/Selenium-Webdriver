import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class NavigationalCommands {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // Initialize the ChromeDriver to launch a Chrome browser instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window for better visibility
        driver.manage().window().maximize();

        // Define a URL object pointing to the first website
        URL url = new URL("https://demo.nopcommerce.com/");

        // Navigate to the first URL using the URL object
        // Note: navigate().to() can accept both a URL object and a String
        driver.navigate().to(url);

        // Navigate to the second website using a string URL
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Wait for 3 seconds to observe the navigation (useful for demonstration purposes)
        Thread.sleep(3000);

        // Navigate back to the previous page in browser history
        driver.navigate().back();
        Thread.sleep(3000); // Wait for 3 seconds to observe the change

        // Navigate forward to the next page in browser history
        driver.navigate().forward();
        Thread.sleep(3000); // Wait for 3 seconds to observe the change

        // Refresh the current page to reload its content
        driver.navigate().refresh();

        // Close the browser after operations (optional but recommended)
        driver.quit();
    }
}
