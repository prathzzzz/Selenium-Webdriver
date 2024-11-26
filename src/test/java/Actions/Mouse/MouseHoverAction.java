package Actions.Mouse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseHoverAction {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com//");

        WebElement pointMe =  driver.findElement(By.xpath("//button[normalize-space()='Point Me']"));

        // Hover on pointMe
        actions.moveToElement(pointMe).perform();

    }
}
