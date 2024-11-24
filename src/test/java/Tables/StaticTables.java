package Tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class StaticTables {

    public static void main(String[] args) {
        // Initialize WebDriver and configure browser settings
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the target URL
        driver.get("https://testautomationpractice.blogspot.com/");

        // Retrieve and print the total number of rows in the table
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@name='BookTable']//tbody/tr"));
        System.out.println("Total number of rows: " + allRows.size());

        // Retrieve and print the total number of columns in the header
        List<WebElement> allColumnsHeader = driver.findElements(By.xpath("//table[@name='BookTable']//tbody/tr/th"));
        System.out.println("Total number of columns: " + allColumnsHeader.size());

        // Loop through each row and print the full table contents
        printFullTable(allRows);

        // Close the browser
        driver.quit();
    }

    // Method to print the full table by iterating through each row and column
    private static void printFullTable(List<WebElement> allRows) {
        for (WebElement row : allRows) {
            // For each row, find the columns (data cells)
            List<WebElement> allColumns = row.findElements(By.xpath("td"));

            // Loop through each column and print the text content
            for (WebElement column : allColumns) {
                System.out.print(column.getText() + "\t"); // Print each cell value, separated by a tab
            }
            System.out.println(); // Print a new line after each row
        }
    }
}
