package Elements.Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleAutoSuggestDropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bjs.com/");

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("water");
        // Xpath for suggestions
        List<WebElement> allSearchOptions =  driver.findElements(By.xpath("//div[@data-cnstrc-item-section='Search Suggestions']//b"));

        for(WebElement option : allSearchOptions) {
            System.out.println(option.getText());
        }

    }
}
