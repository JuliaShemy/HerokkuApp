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

public class DynamicControlsTest {

    @Test
    public void checkDynamicControls() {
        //задаем опции для нашего драйвера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        //определяем браузер
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //открывает страницу по url
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[text() = 'Remove']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        wait.until((ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox"))));
        //находим input
        WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
        //проверяем что input disabled
        Assert.assertFalse(input.isEnabled());
        //нажимаем кнопку Enable
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        //ждем пока появится надпись It's enabled!
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"),"It's enabled!"));
        //проверяем что input Enabled
        Assert.assertTrue(input.isEnabled());

        driver.quit();
    }
}