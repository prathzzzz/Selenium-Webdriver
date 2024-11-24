package Core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(50000);
        // Get title of web page
        System.out.println(driver.getTitle());

        //Get current URL
        System.out.println(driver.getCurrentUrl());

        // Get Page Source
        System.out.println(driver.getPageSource());
        // Get Window Handle
        System.out.println(driver.getWindowHandle());
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();


        // All window Handles
        for (String windowHandle : driver.getWindowHandles()) {
            System.out.println(windowHandle);
        }

    }
}
