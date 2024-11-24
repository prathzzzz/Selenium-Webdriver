package Elements.Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HiddenDropdown {
    public static void main(String[] args) {
        // Initialize ChromeDriver and maximize the window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Set implicit wait time for locating elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Initialize WebDriverWait for explicit waits
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to the login page of the application
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Locate and input the username
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

        // Locate and input the password
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

        // Click on the Login button
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        // Click on the PIM section after login
        driver.findElement(By.xpath("//span[normalize-space()='PIM']/parent::a")).click();

        // Locate and click on the dropdown element that you want to interact with
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[1]/div[1]")).click();

        // Retrieve all the options available in the dropdown
        List<WebElement> allOptions = driver.findElements(By.xpath("//div[@role='listbox']/child::div/span"));

        // Print the number of options available in the dropdown
        System.out.println(allOptions.size());

        // Iterate through each option and print the text value
        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }

        // Close the browser after operations are complete (optional)
        driver.quit();
    }
}
