/*
Checkboxes - проверить, что первый чекбокс unchecked, отметить
первый чекбокс, проверить что он checked. Проверить, что второй чекбокс
checked, сделать unheck, проверить, что он unchecked
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class CheckBoxTest {
    @Test
    public void checkCheckBox() {
        //задаем опции для нашего драйвера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        //определяем браузер
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //открывает страницу по url
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //нашли все чекбоксы,берем первый,проверяем наличие галочки
        boolean isCheck = driver.findElements(By.cssSelector("[type=checkbox]")).get(0).isSelected();
        Assert.assertFalse(isCheck);
        //жмем первый
        driver.findElements(By.cssSelector("[type=checkbox]")).get(0).click();
        //проверяем
        isCheck = driver.findElements(By.cssSelector("[type=checkbox]")).get(0).isSelected();
        Assert.assertTrue(isCheck);
        //проверяем второй чекбокс
        boolean isCheck2 = driver.findElements(By.cssSelector("[type=checkbox]")).get(1).isSelected();
        Assert.assertTrue(isCheck2);
        //снимаем галочку
        driver.findElements(By.cssSelector("[type=checkbox]")).get(1).click();
        //проверяем
        isCheck2 = driver.findElements(By.cssSelector("[type=checkbox]")).get(1).isSelected();
        Assert.assertFalse(isCheck2);

        driver.quit();
    }
}