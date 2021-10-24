package tracker.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultSearchPage {
    WebDriver driver;
    private By searchPage = By.xpath("//a[@href=\"https://ru.wikipedia.org/wiki/Java\"]");

    public ResultSearchPage(WebDriver driver){
        this.driver = driver;
    }

    public ResultSearchPage clickSearchPage(){
        driver.findElement(searchPage).click();
        return new ResultSearchPage(driver);
    }
}
