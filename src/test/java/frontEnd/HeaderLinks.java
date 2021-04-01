package frontEnd;

import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static frontEnd.Constants.*;

public class HeaderLinks {
    WebDriver driver;

    @After
    public void closeDriver() {
        driver.close();
    }

    @Test
    public void test1_questionLink_HomeToQuestion() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(HOME_PAGE_URL);
        driver.findElement(By.linkText(QUESTION_PAGE_LINKTEXT)).click();
        String actual = driver.getTitle();
        Assertions.assertEquals(actual, QUESTION_PAGE_TITLE);
    }

    @Test
    public void test2_aboutLink_HomeToAbout() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(HOME_PAGE_URL);
        driver.findElement(By.linkText(ABOUT_PAGE_LINKTEXT)).click();
        String actual = driver.getTitle();
        Assertions.assertEquals(actual, ABOUT_PAGE_TITLE);
    }

    @Test
    public void test3_aboutLink_QuestionToAbout() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(QUESTION_PAGE_URL);
        driver.findElement(By.linkText(ABOUT_PAGE_LINKTEXT)).click();
        String actual = driver.getTitle();
        Assertions.assertEquals(actual, ABOUT_PAGE_TITLE);
    }

    @Test
    public void test4_homeLink_AboutToHome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(ABOUT_PAGE_URL);
        driver.findElement(By.linkText(HOME_PAGE_LINKTEXT)).click();
        String actual = driver.getTitle();
        Assertions.assertEquals(actual, HOME_PAGE_TITLE);
    }


    @Test
    public void test5_questionLink_AboutToQuestion() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(ABOUT_PAGE_URL);
        driver.findElement(By.linkText(QUESTION_PAGE_LINKTEXT)).click();
        String actual = driver.getTitle();
        Assertions.assertEquals(actual, QUESTION_PAGE_TITLE);
    }

    @Test
    public void test6_homeLink_QuestionToHome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(QUESTION_PAGE_URL);
        driver.findElement(By.linkText(HOME_PAGE_LINKTEXT)).click();
        String actual = driver.getTitle();
        Assertions.assertEquals(actual, HOME_PAGE_TITLE);
    }



}
