import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        // Tag + id combination, tag is optional here (tag#id)
        driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Iphone");

        // Finding By Id
        driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Iphone");

        // Finding By Tag and class name
        driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Searching something");

        // Finding By class name
        driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Searching something");

        // Finding By Tag and Attribute Value
        driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("Kya bolti bantai");

        // Finding By Attribute value
        driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("Kya bolti bantai ki public");

        // Finding By Tag, Class, and Attribute
        driver.findElement(By.cssSelector("input.search-box-text[placeholder='Search store']")).sendKeys("Mamama");
    }
}
