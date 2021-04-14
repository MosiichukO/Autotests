package frontEnd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static frontEnd.Constants.*;

public class Logic {
    public static WebDriver driver = null;

    public static void initialize () {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    public static void quit () {
        driver.quit();
        driver = null;
    }

    public static void LinkFindClick (String link) {
        driver.findElement(By.linkText(link)).click();
    }
}
