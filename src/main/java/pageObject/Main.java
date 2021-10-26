package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
   static WebDriver driver;


    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver95.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String expectedLink = "oracle.com/java/";
            driver.get("https://yandex.ru/");
            FirstPage firstPage = new FirstPage(driver);
            firstPage.search("java");
            ResultSearchPage resultSearchPage = new ResultSearchPage(driver);
            resultSearchPage.clickSearchPage();
            WaitHelper.sleep(2);
            WebDriverHelper webDriverHelper = new WebDriverHelper(driver);
            webDriverHelper.switchToTab(2);
            JavaWikiPage javaWikiPage = new JavaWikiPage(driver);
            if (javaWikiPage.getLink().equals(expectedLink))
                System.out.println("Успех. Линка верная!!!");
            else
                System.out.println("Ошибка. Линки некорректная!!!");
        } finally {
            driver.quit();
        }
    }
}
