import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class FileUploadTest {
    @Test
    public void checkFileName() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/upload");
        //создаем файл
        File file = new File("src/test/resources/1.txt");
        //загружаем
        driver.findElement(By.cssSelector("[type=file]")).sendKeys(file.getAbsolutePath());
        // нажимаем кнопку загрузить
        driver.findElement(By.id("file-submit")).click();
        //ждем загрузку
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //получаем название файла
        String uploadFileName = driver.findElement(By.id("uploaded-files")).getText();
        //проверяем имя файла
        Assert.assertEquals(uploadFileName, file.getName());
        driver.quit();
    }
}