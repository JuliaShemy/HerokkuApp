/*
Проверить на возможность ввести различные цифровые и
нецифровые значения, используя Keys.ARROW_UP И
Keys.ARROW_DOWN
 */
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class InputsTest {
    @Test
    public void checkInput() {
        //задаем опции для нашего драйвера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        //определяем браузер
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //открывает страницу по url
        driver.get("https://the-internet.herokuapp.com/inputs");

        WebElement input = driver.findElement(By.tagName("input"));
        // вводим буквы
        input.sendKeys("e");
        String valueLetters = input.getAttribute("value");
        System.out.println("Значение поля после ввода букв: " + valueLetters);
        Assert.assertEquals(valueLetters, "");//буквы не вводятся

        //вводим цифры
        input.sendKeys("10");
        String valueNumbers = input.getAttribute("value");
        System.out.println("Значение поля после ввода цифр: " + valueNumbers);
        Assert.assertEquals(valueNumbers, "10");//ввелось 10
        //увеличение
        input.sendKeys(Keys.ARROW_UP);
        String valueUp = input.getAttribute("value");
        System.out.println("Значение поля после увеличения: " + valueUp);
        Assert.assertEquals(valueUp, "11");
        //уменьшение
        input.sendKeys(Keys.ARROW_DOWN);
        String valueDown = input.getAttribute("value");
        System.out.println("Значение поля после уменьшения: " + valueDown);
        Assert.assertEquals(valueDown, "10");

        driver.quit();
    }
}