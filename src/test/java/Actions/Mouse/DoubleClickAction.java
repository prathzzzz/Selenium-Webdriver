package Actions.Mouse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DoubleClickAction {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");
        WebElement resultFrame = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
        driver.switchTo().frame(resultFrame);
        WebElement doubleClickItem = driver.findElement(By.xpath("//p[@ondblclick='myFunction()']"));
        // Double click
        actions.doubleClick(doubleClickItem).perform();
    }
}
