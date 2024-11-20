import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Assignment {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.findElement(By.xpath("//input[@class='wikipedia-search-input']")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Locate all the clickable <a> tags inside the results
        List<WebElement> allResults = driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']/a"));

        // Iterate through each result and click
        for (WebElement result : allResults) {
            wait.until(ExpectedConditions.elementToBeClickable(result)).click();
        }

        Set<String> allHandles = driver.getWindowHandles();
        List<String> allWindows = new ArrayList<>(allHandles);

        for (String window : allWindows) {
            driver.switchTo().window(window);
            if(driver.getTitle().equals("Selenium - Wikipedia")) {
                driver.close();
            }
            System.out.println(window);
        }
    }
}
