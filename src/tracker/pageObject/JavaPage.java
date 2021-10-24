package tracker.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaPage {
    WebDriver driver;
    private By link = By.xpath("//table//a[contains(text(), \"oracle.com/java\")]");

    public  JavaPage(WebDriver driver){
        this.driver = driver;
    }
    public String getLink(){
        return driver.findElement(link).getText();
    }


}
