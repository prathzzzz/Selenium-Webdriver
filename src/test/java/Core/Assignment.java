package Core;

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

    public static class ConditionalMethods {
        public static void main(String[] args) {

            // Initialize the WebDriver instance
            WebDriver driver = new ChromeDriver();

            // Navigate to the nopCommerce demo register page
            driver.get("https://demo.nopcommerce.com/register");

            // Maximize the browser window for better visibility
            driver.manage().window().maximize();

            // 1. isDisplayed():
            // This method is used to verify whether a web element is visible on the webpage.
            // It returns true if the element is visible, otherwise false.
            System.out.println("Is logo displayed? " +
                    driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed());

            // 2. isSelected():
            // This method is used to check whether a checkbox, radio button, or drop-down option is selected.
            // It returns true if the element is selected, otherwise false.
            System.out.println("Is 'Female' radio button selected? " +
                    driver.findElement(By.xpath("//input[@id='gender-female']")).isSelected());

            // Click on the 'Male' radio button to select it
            driver.findElement(By.xpath("//input[@id='gender-male']")).click();

            // Verify if the 'Male' radio button is now selected
            System.out.println("Is 'Male' radio button selected? " +
                    driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected());

            // 3. isEnabled():
            // This method is used to verify whether a web element is enabled (clickable or interactable).
            // It returns true if the element is enabled, otherwise false.
            System.out.println("Is 'Register' button enabled? " +
                    driver.findElement(By.xpath("//button[@name='register-button']")).isEnabled());


            driver.quit();
        }
    }
}
