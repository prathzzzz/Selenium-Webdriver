import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocatorsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com");

        // Maximize window
        driver.manage().window().maximize();

        // Find element by name which is search and uske andar send value using sendKeys that is Mac here
        driver.findElement(By.name("search")).sendKeys("Mac");

        // Show logo status
        boolean logoDisplayStatus = driver.findElement(By.id("logo")).isDisplayed();
        System.out.println(logoDisplayStatus);
        // Link Text
        driver.findElement(By.linkText("Tablets")).click();

        // Partial Link Text ( Not Prefferable )
        driver.findElement(By.partialLinkText("Tabl")).click();

        // findElements returns multiple links so to store it we use list of type webelement
        List<WebElement> headerLinks = driver.findElements(By.className("list-inline-item"));
        System.out.println(headerLinks.size());

        // find elements using tag name
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        System.out.println(allLinks.size());
    }

}
