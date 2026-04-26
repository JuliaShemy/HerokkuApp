import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class TyposTest {
    @Test
    public void checkTypos() {
        //задаем опции для нашего драйвера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        //определяем браузер
        WebDriver driver = new ChromeDriver(options);
        SoftAssert softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //открывает страницу по url
        driver.get("https://the-internet.herokuapp.com/typos");

        String correctText = "Sometimes you'll see a typo, other times you won't.";
        for (int i = 1; i <= 10; i++) {
            driver.navigate().refresh();
            String text = driver.findElement(By.xpath("(//p)[2]")).getText();
            softAssert.assertEquals(text, correctText);
            System.out.println(text);
        }
        driver.quit();
        softAssert.assertAll();
    }
}