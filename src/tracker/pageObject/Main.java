package tracker.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    private static WebDriver driver;

    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver95.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get("https://www.google.com/");
            StartPage startPage = new StartPage(driver);
            startPage.search("java");
            ResultSearchPage resultSearchPage = new ResultSearchPage(driver);
            resultSearchPage.clickSearchPage();
            JavaPage javaPage = new JavaPage(driver);
            String expectedText = "oracle.com/java/";
            if (javaPage.getLink().equals(expectedText))
                System.out.println("Объекты равны");
            else
                System.out.println("Объекты не равны");
        } finally {
            driver.quit();
        }
    }
}
