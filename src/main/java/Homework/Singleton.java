package Homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static Homework.Attributes.URL_SITE;

public class Singleton {

    public static WebDriver driver = null;
    public static String browserName = "chrome";

    public static void initialize () {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL_SITE);
    }

    public static void quit () {
        driver.quit();
        driver = null;
    }

}
