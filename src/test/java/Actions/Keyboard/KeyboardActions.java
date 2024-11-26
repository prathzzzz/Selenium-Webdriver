package Actions.Keyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class KeyboardActions {
    public static void main(String[] args) {
        // Initialize WebDriver and Actions
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);

        // Maximize window and set implicit wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the website
        driver.get("https://text-compare.com/");

        // Locate the first textarea and send some text
        driver.findElement(By.xpath("//*[@id='inputText1']")).sendKeys("Hello World");


        // Perform the keyboard actions: Select All, Copy, Switch Tab, and Paste
        actions.keyDown(Keys.CONTROL)
                .sendKeys("a")   // Select All
                .sendKeys("c")   // Copy
                .keyUp(Keys.CONTROL) // Release the key
                .sendKeys(Keys.TAB)  // Switch tab
                .keyDown(Keys.CONTROL)
                .sendKeys("v")   // Paste
                .keyUp(Keys.CONTROL)
                .perform();
    }
}
