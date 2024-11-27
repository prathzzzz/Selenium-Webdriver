package Executor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JavascriptExecutorDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement inputBox =  driver.findElement(By.xpath("//input[@id='name']"));

        // Convert driver to Js driver
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Passing the text into inputbox - alternate of sendKeys()
        js.executeScript("arguments[0].setAttribute('value','John')",inputBox);

        WebElement radioBtnMale = driver.findElement(By.xpath("//input[@id='male']"));
        js.executeScript("arguments[0].click();",radioBtnMale);
    }
}
