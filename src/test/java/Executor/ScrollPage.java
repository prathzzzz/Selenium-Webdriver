package Executor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ScrollPage {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        // Scroll down by pixel number
        js.executeScript("window.scrollBy(0,1300)","");

        // Scroll to certain element
        WebElement element =  driver.findElement(By.xpath("//h2[normalize-space()='Dynamic Web Table']"));

        js.executeScript("arguments[0].scrollIntoView();",element);

        // Scroll till end of page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        Thread.sleep(3000);
        // Scroll from end to initial
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
    }
}
