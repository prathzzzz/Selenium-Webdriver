package Tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

class DynamicPaginationTable {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        List<WebElement> columns =  driver.findElements(By.xpath("//table[@id='productTable']//th"));

        for(int i=0; i<columns.size(); i++){
            if(i==columns.size()-1){
                break;
            }
            System.out.print(columns.get(i).getText()+"\t");
        }

        for (int i = 1; i <= columns.size(); i++) {
            // Click on the pagination link if it's not the first page
            if (i > 1) {
                driver.findElement(By.xpath("//ul[@class='pagination']//li[" + i + "]")).click();
            }

            // Wait for table data to load (add appropriate wait condition if needed)
            List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr"));

            // Iterate through rows and extract data from the 1st to 3rd columns
            for (WebElement row : allRows) {
                List<WebElement> columns2 = row.findElements(By.xpath("./td[position() >= 1 and position() <= 3]"));
                for (WebElement column : columns2) {
                    System.out.print(column.getText() + "\t"); // Print column data
                }
                System.out.println(); // Move to the next line after printing all columns of a row
            }
        }

        // Print the headers first
        System.out.println("ID\tName\tPrice");

        for (int i = 1; i <= columns.size(); i++) {
            // Click on the pagination link if it's not the first page
            if (i > 1) {
                driver.findElement(By.xpath("//ul[@class='pagination']//li[" + i + "]")).click();
            }

            List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr"));

            // Iterate through rows and extract data from the 1st to 3rd columns
            for (WebElement row : allRows) {
                List<WebElement> columns2 = row.findElements(By.xpath("./td[position() >= 1 and position() <= 3]"));
                for (WebElement column : columns2) {
                    System.out.print(column.getText() + "\t"); // Print each column value with tab separation
                }
                System.out.println(); // New line after each row's data
            }
        }



    }
}