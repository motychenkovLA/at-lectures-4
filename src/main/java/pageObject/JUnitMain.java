package pageObject;

import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JUnitMain {
    static WebDriver driver;

    @Before
    public void beforeMet(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver95.exe");
        driver = new ChromeDriver();
    }

    @Rule
    public Timeout timeout = Timeout.seconds(30);

    @After
    public void afterMet() {
        if (driver != null) driver.quit();
    }


    @Test
    public void java() {
        driver.get("https://yandex.ru/");
        FirstPage firstPage = new FirstPage(driver);
        firstPage.search("java");
        ResultSearchPage resultSearchPage = new ResultSearchPage(driver);
        resultSearchPage.clickSearchPage();
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='https://ru.wikipedia.org/wiki/Java']")));
        WebDriverHelper webDriverHelper = new WebDriverHelper(driver);
        webDriverHelper.switchToTab(2);
        JavaWikiPage javaWikiPage = new JavaWikiPage(driver);
        String expectedLink = "oracle.com/java/";
        Assert.assertEquals("Объекты не равны", expectedLink,javaWikiPage.getLink());
    }


}
