package frontEnd;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    public void test1_teamNameInHeader() {
        String actual = driver.findElement(By.className("header")).findElement(By.className("header__team-name")).getText();
        Assert.assertEquals(actual, TEAM_NAME);
    }

    @Test
    public void test2_logoInHeader() {
        driver.findElement(By.className("header")).findElement(By.className("header__logo"));
    }

    @Test
    public void test3_infoBlock_FirstMember() {
        driver.findElement(By.className("information__name"));
        driver.findElement(By.className("information__edit"));
        boolean actual1 = driver.getPageSource().contains(INFOBLOCK_HEIGHT);
        Assert.assertTrue(actual1);
        boolean actual2 = driver.getPageSource().contains(INFOBLOCK_WEIGHT);
        Assert.assertTrue(actual2);
        boolean actual3 = driver.getPageSource().contains(INFOBLOCK_AGE);
        Assert.assertTrue(actual3);
        boolean actual4 = driver.getPageSource().contains(INFOBLOCK_BIRTHDATE);
        Assert.assertTrue(actual4);
        boolean actual5 = driver.getPageSource().contains(INFOBLOCK_HOBBIES);
        Assert.assertTrue(actual5);
    }
}

