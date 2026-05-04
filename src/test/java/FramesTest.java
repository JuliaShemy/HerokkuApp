import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FramesTest {
    @Test
    public void checkTextFrame() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/frames");
        // Кликаем iFrame
        driver.findElement(By.linkText("iFrame")).click();
        // Ждём iframe
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mce_0_ifr")));
        // переключаемся в iframe
        driver.switchTo().frame(iframe);
        // Берём текст
        String text = driver.findElement(By.id("tinymce")).getText();
        // Проверяем текст
        Assert.assertEquals(text, "Your content goes here.");
        // Выходим из iframe
        driver.switchTo().defaultContent();

        driver.quit();
    }
}