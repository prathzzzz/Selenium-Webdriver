package Actions.Keyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class OpenLinkInNewTab {
    public static void main(String[] args) {
        // Initialize WebDriver for Chrome browser
        WebDriver driver = new ChromeDriver();

        // Initialize Actions class to perform complex user interactions
        Actions actions = new Actions(driver);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set implicit wait time to 10 seconds to allow for elements to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the specified URL (nopCommerce demo site)
        driver.get("https://demo.nopcommerce.com/");

        // Locate the 'Register' button element using XPath
        WebElement registerBtn =  driver.findElement(By.xpath("//a[normalize-space()='Register']"));

        // Perform a keyboard interaction to open the 'Register' link in a new tab
        actions.keyDown(Keys.CONTROL).click(registerBtn).keyUp(Keys.CONTROL).perform();

        // Switch to the new window that opened after the link was clicked
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        // Locate the 'FirstName' input field in the new tab and send the text 'Heloo'
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Heloo");
    }
}
