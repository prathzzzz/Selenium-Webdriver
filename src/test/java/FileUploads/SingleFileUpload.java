package FileUploads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SingleFileUpload {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
        // Upload files using send keys by mentioning path of that file
        driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Users\\Admin\\Downloads\\MIS.pdf");

        // Verify if file is uploaded or not
        if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("MIS.pdf")) {
            System.out.println("Upload Success");
        } else {
            System.out.println("Upload Failed");
        }


    }
}
