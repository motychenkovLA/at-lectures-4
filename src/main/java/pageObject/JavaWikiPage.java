package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaWikiPage {
    WebDriver driver;
    private By link = By.xpath("//table//a[.='oracle.com/java/']");

    public JavaWikiPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLink() {
        return driver.findElement(link).getText();
    }
}
