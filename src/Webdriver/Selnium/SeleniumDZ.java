package Webdriver.Selnium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSeleniumDZ {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver95.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get("https://habr.com");
        driver.findElement(By.xpath("//a[contains(text(), \"Как стать автором\")]")).click();
        driver.findElement(By.xpath("//button[@class=\"tm-footer__link\"]")).click();
        driver.findElement(By.xpath("//label[contains(text(), \"English\")]")).click();
        driver.findElement(By.xpath("//button[contains(text(), \"Save preferences\")]")).click();
        driver.findElement(By.xpath("//button[contains(text(), \"Language settings\")]")).click();
        driver.findElement(By.xpath("//label[contains(text(), \"Русский\")]")).click();
        driver.findElement(By.xpath("//button[contains(text(), \"Сохранить настройки\")]")).click();
        driver.quit();
    }
}
