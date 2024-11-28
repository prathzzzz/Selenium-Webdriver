package Screenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

public class CaptureScreenshot {
    public static void main(String[] args) {
        // Step 1: Initialize the ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Step 2: Maximize the browser window
        driver.manage().window().maximize();

        // Step 3: Set an implicit wait timeout for locating web elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Step 4: Open the OrangeHRM login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


        /*
        Full Page Screenshot
        Cast the driver instance to TakesScreenshot for capturing full page
        TakesScreenshot ts = (TakesScreenshot) driver;

        Capture the screenshot as a File object
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        Define the target file path for saving the screenshot
        File targetFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\Screenshots\\Images\\Fullpage.png");

        Move the screenshot file from source to target location
        sourceFile.renameTo(targetFile);
        */

        // Step 5: Locate the specific section for capturing a partial screenshot
        WebElement loginPagePath = driver.findElement(By.xpath("//div[@class='orangehrm-login-slot']"));

        // Step 6: Capture a screenshot of the specific section
        File loginPageImage = loginPagePath.getScreenshotAs(OutputType.FILE);

        // Step 7: Define the target file path for saving the partial screenshot
        File targetFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\Screenshots\\Images\\LoginPage.png");

        // Step 8: Move the screenshot file to the target location
        loginPageImage.renameTo(targetFile);

    }
}
