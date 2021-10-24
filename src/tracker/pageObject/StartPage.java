package tracker.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class StartPage {
    WebDriver driver;

    private By seachFieald = By.xpath("//input[@title= \"Поиск\"]");

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    public StartPage search(String searchString){
        driver.findElement(seachFieald).sendKeys(searchString);
        driver.findElement(seachFieald).sendKeys(Keys.ENTER);
        return new StartPage(driver);
    }
}
