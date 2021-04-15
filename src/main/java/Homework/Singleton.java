package Homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Singleton {

    public static WebDriver driver = null;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void initialize() {
        getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://tempmail.plus/ru/");
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }

}
