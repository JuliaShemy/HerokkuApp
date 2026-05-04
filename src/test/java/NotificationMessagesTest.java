/*
кликнуть на кнопку, дождаться появления
нотификации, проверить соответствие текста ожиданиям
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
public class NotificationMessagesTest {
    @Test
    public void checkMessagesText() {
        //задаем опции для нашего драйвера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        //определяем браузер
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //открывает страницу по url
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.xpath("//a[@href='/notification_message']")).click();
        //находим элемент
        WebElement message = driver.findElement(By.id("flash"));
        //берем текст
        String text = message.getText();
        //выводим сообщенеи с текстом
        System.out.println("Собщение: " + text);
        //создаем переменную, которая содержит то или другое значение
        boolean correct = text.contains("Action successful") ||
                          text.contains("Action unsuccesful");
        //если true тест проходит если нет,падает
        Assert.assertTrue(correct, text);
        driver.quit();
    }
}