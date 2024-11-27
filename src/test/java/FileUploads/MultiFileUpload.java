package FileUploads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MultiFileUpload {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");

        // To upload multiple files add these files in variables
        String file1 = "C:\\Users\\Admin\\Downloads\\MIS.pdf";
        String file2 = "C:\\Users\\Admin\\Downloads\\Syllabus.pdf";

        // Pass the variables here
        driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1 + "\n" + file2);

    }
}
