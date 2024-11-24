package Elements.Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SelectDropdown {
    public static void main(String[] args) {
        // Initialize WebDriver and navigate to the webpage
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        // Capture reference to the dropdown element
        WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='country']"));

        // Create a Select object to work with dropdown options
        Select dropdown = new Select(countryDropdown);

        // Get all options in the dropdown and print them
        List<WebElement> allOptions = dropdown.getOptions();
        System.out.println("Available options in the dropdown:");
        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }

        // Select options using different methods
        dropdown.selectByVisibleText("China");
        dropdown.selectByValue("india");
        dropdown.selectByIndex(7);

        // Close the browser
        driver.quit();
    }
}
