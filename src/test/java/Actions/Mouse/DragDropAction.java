package Actions.Mouse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragDropAction {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        WebElement box1 =  driver.findElement(By.xpath("//div[@id='box1']"));
        WebElement box106 = driver.findElement(By.xpath("//div[@id='box106']"));
        // Drag and drop takes source and destination for drag and drop
        actions.dragAndDrop(box1, box106).perform();

    }
}
