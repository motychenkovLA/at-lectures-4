package tracker.pageObject;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitTest {
    private static WebDriver driver;
    @Rule
    public org.junit.rules.Timeout timeout = org.junit.rules.Timeout.seconds(30);

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver95.exe");
        driver = new ChromeDriver();
    }

    @After
    public void afterMethod() {
        if (driver != null) driver.quit();
    }

    @Test
    public void test() {
        driver.get("https://www.google.com/");
        StartPage startPage = new StartPage(driver);
        startPage.search("java");
        ResultSearchPage resultSearchPage = new ResultSearchPage(driver);
        resultSearchPage.clickSearchPage();
        JavaPage javaPage = new JavaPage(driver);
        String expectedText = "oracle.com/java/";
        Assert.assertEquals("Объекты не равны", expectedText, javaPage.getLink());
    }
}
