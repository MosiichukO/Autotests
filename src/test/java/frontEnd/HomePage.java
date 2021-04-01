package frontEnd;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static frontEnd.Constants.*;

public class HomePage {
    WebDriver driver;

    @Before
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(HOME_PAGE_URL);
    }

    @After
    public void closeDriver() {
        driver.close();
    }

    @Test
    public void test1_teamNameInHeader () {
        String actual = driver.findElement(By.className("header")).findElement(By.className("header__team-name")).getText();
        Assertions.assertEquals(actual, TEAM_NAME);
    }

    @Test
    public void test2_logoInHeader () {
    driver.findElement(By.className("header")).findElement(By.className("header__logo"));
    }
}
