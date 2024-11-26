package Datepickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DatePickerDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jqueryui.com/datepicker/");

        driver.switchTo().frame(0);

        driver.findElement(By.id("datepicker")).click();

        String targetDate = "22";
        String targetMonth = "August";
        String targetYear = "2023";

//        selectFutureDate(driver, targetDate, targetMonth, targetYear);
        selectPastDate(driver, targetDate, targetMonth, targetYear);

//        driver.quit();
    }

    public static void selectFutureDate(WebDriver driver, String targetDate, String targetMonth, String targetYear) {
        selectDateBasedOnMonthAndYear(driver, targetDate, targetMonth, targetYear, true);
    }

    public static void selectPastDate(WebDriver driver, String targetDate, String targetMonth, String targetYear) {
        selectDateBasedOnMonthAndYear(driver, targetDate, targetMonth, targetYear, false);
    }

    public static void selectDateBasedOnMonthAndYear(WebDriver driver, String targetDate, String targetMonth, String targetYear, boolean isFuture) {
        selectMonthAndYear(driver, targetMonth, targetYear, isFuture);
        selectDate(driver, targetDate);
    }

    public static void selectMonthAndYear(WebDriver driver, String targetMonth, String targetYear, boolean isFuture) {
        while (true) {
            String currentYear = driver.findElement(By.className("ui-datepicker-year")).getText();
            String currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();

            if (currentYear.equals(targetYear) && currentMonth.equals(targetMonth)) {
                break;
            }

            if (isFuture) {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
            } else {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
            }
        }
    }

    public static void selectDate(WebDriver driver, String targetDate) {
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td/a"));
        for (WebElement element : allDates) {
            if (element.getText().equals(targetDate)) {
                element.click();
                break;
            }
        }
    }
}
