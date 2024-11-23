import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleFrames {
    public static void main(String[] args) {
        // Initialize the WebDriver and launch a Chrome browser instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window for better visibility
        driver.manage().window().maximize();

        // Set an implicit wait to handle element loading delays
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the webpage with frames
        driver.get("https://ui.vision/demo/webtest/frames/");

        // Step 1: Handle Frame 1
        // Locate Frame 1 using its XPath
        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        // Switch to Frame 1 using the WebElement reference
        driver.switchTo().frame(frame1);
        // Locate the input element inside Frame 1 and enter text
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Hello World");

        // Return to the main (default) HTML content after interacting with Frame 1
        driver.switchTo().defaultContent();

        // Step 2: Handle Frame 2
        // Locate Frame 2 using its XPath
        WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        // Switch to Frame 2 using the WebElement reference
        driver.switchTo().frame(frame2);
        // Locate the input element inside Frame 2 and enter text
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Hello World");

        // Return to the main (default) HTML content after interacting with Frame 2
        driver.switchTo().defaultContent();

        // Step 3: Handle Frame 3
        // Locate Frame 3 using its XPath
        WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        // Switch to Frame 3 using the WebElement reference
        driver.switchTo().frame(frame3);
        // Locate the input element inside Frame 3 and enter text
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Hello World");

        // Step 4: Handle the nested (inner) iframe inside Frame 3
        // Switch to the inner iframe of Frame 3 using its index (0 indicates the first iframe)
        driver.switchTo().frame(0);
        // Locate and interact with an element inside the nested iframe
        driver.findElement(By.xpath("//span[@class='aDTYNe snByac OvPDhc']")).click();

        // Return to the main (default) HTML content after interacting with inner frame of frame 3
        driver.switchTo().defaultContent();

        // Optional: Close the browser after the operations
        driver.quit();
    }
}
