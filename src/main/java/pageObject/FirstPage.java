package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FirstPage {
    WebDriver driver;

    private By searchField = By.xpath("//input[@class=\"input__control input__input mini-suggest__input\"]");

    public FirstPage(WebDriver driver) {
        this.driver = driver;
    }

   public FirstPage search (String searchString) {
        driver.findElement(searchField).sendKeys(searchString);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        return new FirstPage(driver);
   }
}
