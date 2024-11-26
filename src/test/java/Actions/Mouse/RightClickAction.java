package Actions.Mouse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class RightClickAction {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        WebElement btn = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        // Right Click ke leye we use contextClick
        actions.contextClick(btn).perform();

        driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']//span[normalize-space()='Copy']")).click();

        driver.switchTo().alert().accept();
    }
}
