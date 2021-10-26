package pageObject;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class WebDriverHelper {
    WebDriver driver;

    public WebDriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToTab(int tabNum) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNum-1));

    }
}
