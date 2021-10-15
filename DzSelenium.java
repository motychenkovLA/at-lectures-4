import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DzSelenium {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver94.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.youtube.com/");

        ChangeTheme("Тёмная");
        Thread.sleep(5000);
        ChangeTheme("Светлая");
        Thread.sleep(5000);
        driver.quit();
    }

    private static void ChangeTheme(String theme){
        WebElement buttonGoToSettings = driver.findElement(By.xpath("//yt-icon-button//button[@aria-label = 'Настройки']"));
        buttonGoToSettings.click();
        WebElement buttonChoosingATopic = driver.findElement(By.xpath("//*[@id=\"items\"]/ytd-toggle-theme-compact-link-renderer"));
        buttonChoosingATopic.click();
        driver.findElement(By.xpath("//*[.='" + theme + "']")).click();
    }
}


