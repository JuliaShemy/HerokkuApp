/*
Dropdown - Взять все элементы дроп-дауна и проверить их наличие.
Выбрать первый, проверить, что он выбран, выбрать второй, проверить, что
он выбран
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class DropdownTest {
    @Test
    public void checkDropdown() {
        //задаем опции для нашего драйвера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        //определяем браузер
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //открывает страницу по url
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        //проверяем что есть все элементы дропдауна
        List<WebElement> option = select.getOptions();
        Assert.assertEquals(option.get(0).getText(), "Please select an option");
        Assert.assertEquals(option.get(1).getText(), "Option 1");
        Assert.assertEquals(option.get(2).getText(), "Option 2");
        //выбираем первый и проверяем что он правильный
        select.selectByIndex(1);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), ("Option 1"));
        //выбираем первый и проверяем что он правильный
        select.selectByIndex(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), ("Option 2"));
    }
}