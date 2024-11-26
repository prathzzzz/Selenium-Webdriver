package Actions.Keyboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TabsAndWindows {
    public static void main(String[] args) {
        // Initialize the WebDriver for Chrome browser
        WebDriver driver = new ChromeDriver();

        // Initialize Actions class to perform complex user gestures
        Actions actions = new Actions(driver);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set an implicit wait of 10 seconds for finding elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the first URL (nopCommerce demo site)
        driver.get("https://demo.nopcommerce.com/");

        // Open a new browser tab
        // driver.switchTo().newWindow(WindowType.TAB);

        // Open a new browser window (this will open a new window)
        driver.switchTo().newWindow(WindowType.WINDOW);

        // Navigate to the second URL (OrangeHRM login page)
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // You can now perform any actions on the second window if needed
    }
}
