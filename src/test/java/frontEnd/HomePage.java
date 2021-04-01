package frontEnd;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static frontEnd.Constants.*;

public class HomePage {
    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(HomePageURL);
    }

    @After
    public void close() {
        driver.close();
    }

    @Test
    public void test_questionsLink() {
        driver.findElement(By.linkText("Question")).click();
        String actual = driver.getTitle();
        String expected = "Questions";
        Assertions.assertEquals(actual, expected);
    }
}
