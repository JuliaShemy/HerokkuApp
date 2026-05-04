import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest {
    @Test
    public void checkContextMenu() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement box = driver.findElement(By.id("hot-spot"));
        //правый клик
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
        //переходим в алерт
        Alert alert = driver.switchTo().alert();
        //получаем текст
        String alertText = alert.getText();
        //проверяем текст
        Assert.assertEquals(alertText, "You selected a context menu");
        alert.accept();
        driver.quit();
    }
}