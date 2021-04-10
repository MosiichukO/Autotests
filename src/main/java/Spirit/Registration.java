package Spirit;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

import static Spirit.TestData.*;

public class Registration {
    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://18.225.7.107/registration.html");
    }

    @After
    public void close() {
        driver.close();
    }

    @Test
    public void test1_notValidLoginLength_Registration_MSD78() {
        driver.findElement(By.id("login-registration")).sendKeys(LOGIN_TEST_3SYMBOLS);
        driver.findElement(By.id("email")).sendKeys(VALID_EMAIL);
        driver.findElement(By.id("phone-number")).sendKeys(VALID_NUMBER);
        driver.findElement(By.id("company")).sendKeys(VALID_COMPANY);
        driver.findElement(By.id("secret-word")).sendKeys(VALID_SECRET_WORD);
        driver.findElement(By.id("password")).sendKeys(VALID_PASSWORD);
        driver.findElement(By.id("confirmPassword")).sendKeys(VALID_PASSWORD);
        driver.findElement(By.id("inv-btn")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actual = driver.getTitle();
        Assert.assertEquals (actual, EXPECTED_TITLE_REGISTRATION);
    }

    @Test
    public void test2_notValidPasswordOnlyLetters_Registration_MSD94() {
        driver.findElement(By.id("login-registration")).sendKeys(VALID_LOGIN);
        driver.findElement(By.id("email")).sendKeys(VALID_EMAIL);
        driver.findElement(By.id("phone-number")).sendKeys(VALID_NUMBER);
        driver.findElement(By.id("company")).sendKeys(VALID_COMPANY);
        driver.findElement(By.id("secret-word")).sendKeys(VALID_SECRET_WORD);
        driver.findElement(By.id("password")).sendKeys(PASSWORD_ONLY_LETTERS);
        driver.findElement(By.id("confirmPassword")).sendKeys(PASSWORD_ONLY_LETTERS);
        driver.findElement(By.id("inv-btn")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actual = driver.getTitle();
        Assert.assertEquals(actual, EXPECTED_TITLE_REGISTRATION);
    }

    @Test
    public void test3_emptyLogin_Registration_MSD33() {
        driver.findElement(By.id("login-registration")).sendKeys("");
        driver.findElement(By.id("email")).sendKeys(VALID_EMAIL);
        driver.findElement(By.id("phone-number")).sendKeys(VALID_NUMBER);
        driver.findElement(By.id("company")).sendKeys(VALID_COMPANY);
        driver.findElement(By.id("secret-word")).sendKeys(VALID_SECRET_WORD);
        driver.findElement(By.id("password")).sendKeys(VALID_PASSWORD);
        driver.findElement(By.id("confirmPassword")).sendKeys(VALID_PASSWORD);
        driver.findElement(By.id("inv-btn")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actual = driver.getTitle();
        Assert.assertEquals(actual, EXPECTED_TITLE_REGISTRATION);
    }

    @Test
    public void test4_maxLengthLogin_Registration_MSD77() {
        driver.findElement(By.id("login-registration")).sendKeys(MAX_LENGTH_LOGIN);
        String expected = "qwertyAAAAqwertyAAAA";
        String actual = driver.findElement(By.id("login-registration")).getAttribute("value");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test5_maxLengthCompany_Registration_MSD86() {
        driver.findElement(By.id("company")).sendKeys(MAX_LENGTH_COMPANY);
        String expected = "TestingDevelopingCom";
        String actual = driver.findElement(By.id("company")).getAttribute("value");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test6_maxLengthPassword_Registration_MSD88() {
        driver.findElement(By.id("password")).sendKeys(MAX_LENGTH_PASSWORD);
        String expected = "DevEducationPro";
        String actual = driver.findElement(By.id("password")).getAttribute("value");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test7_maxLengthNumber_Registration_MSD84() {
        driver.findElement(By.id("phone-number")).sendKeys(MAX_LENGTH_PHONE);
        String expected = "1234567890";
        String actual = driver.findElement(By.id("phone-number")).getAttribute("value");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test8_notEqualPasswordAndConfirm_Registration_MSD95() {
        driver.findElement(By.id("login-registration")).sendKeys(VALID_LOGIN);
        driver.findElement(By.id("email")).sendKeys(VALID_EMAIL);
        driver.findElement(By.id("phone-number")).sendKeys(VALID_NUMBER);
        driver.findElement(By.id("company")).sendKeys(VALID_COMPANY);
        driver.findElement(By.id("secret-word")).sendKeys(VALID_SECRET_WORD);
        driver.findElement(By.id("password")).sendKeys(VALID_PASSWORD);
        driver.findElement(By.id("confirmPassword")).sendKeys("PasswordTest1");
        driver.findElement(By.id("inv-btn")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actual = driver.getTitle();
        Assert.assertEquals(actual, EXPECTED_TITLE_REGISTRATION);
    }

    @Test
    public void test9_maxLengthConfirmPassword_Registration_MSD89() {
        driver.findElement(By.id("confirmPassword")).sendKeys(MAX_LENGTH_PASSWORD);
        String expected = "DevEducationPro";
        String actual = driver.findElement(By.id("confirmPassword")).getAttribute("value");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test10_emptyConfirmPassword_Registration_MSD91() {
        driver.findElement(By.id("login-registration")).sendKeys(VALID_LOGIN);
        driver.findElement(By.id("email")).sendKeys(VALID_EMAIL);
        driver.findElement(By.id("phone-number")).sendKeys(VALID_NUMBER);
        driver.findElement(By.id("company")).sendKeys(VALID_COMPANY);
        driver.findElement(By.id("secret-word")).sendKeys(VALID_SECRET_WORD);
        driver.findElement(By.id("password")).sendKeys(VALID_PASSWORD);
        driver.findElement(By.id("confirmPassword")).sendKeys("");
        driver.findElement(By.id("inv-btn")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actual = driver.getTitle();
        Assert.assertEquals(actual, EXPECTED_TITLE_REGISTRATION);
    }

    @Test
    public void test11_notValidLoginCyrillic_Registration_MSD83() {
        driver.findElement(By.id("login-registration")).sendKeys(LOGIN_TEST_CYRILLIC);
        driver.findElement(By.id("email")).sendKeys(VALID_EMAIL);
        driver.findElement(By.id("phone-number")).sendKeys(VALID_NUMBER);
        driver.findElement(By.id("company")).sendKeys(VALID_COMPANY);
        driver.findElement(By.id("secret-word")).sendKeys(VALID_SECRET_WORD);
        driver.findElement(By.id("password")).sendKeys(VALID_PASSWORD);
        driver.findElement(By.id("confirmPassword")).sendKeys(VALID_PASSWORD);
        driver.findElement(By.id("inv-btn")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actual = driver.getTitle();
        Assert.assertEquals(actual, EXPECTED_TITLE_REGISTRATION);
    }

    @Test
    public void test12_notValidPasswordLength_Registration_MSD92() {
        driver.findElement(By.id("login-registration")).sendKeys(VALID_LOGIN);
        driver.findElement(By.id("email")).sendKeys(VALID_EMAIL);
        driver.findElement(By.id("phone-number")).sendKeys(VALID_NUMBER);
        driver.findElement(By.id("company")).sendKeys(VALID_COMPANY);
        driver.findElement(By.id("secret-word")).sendKeys(VALID_SECRET_WORD);
        driver.findElement(By.id("password")).sendKeys(PASSWORD_TEST_7SYMBOLS);
        driver.findElement(By.id("confirmPassword")).sendKeys(PASSWORD_TEST_7SYMBOLS);
        driver.findElement(By.id("inv-btn")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actual = driver.getTitle();
        Assert.assertEquals(actual, EXPECTED_TITLE_REGISTRATION);
    }

    @Test
    public void test13_notValidLoginSpecSymbols_Registration_MSD79() {
        driver.findElement(By.id("login-registration")).sendKeys(PASSWORD_TEST_SPECSYMBOLS);
        driver.findElement(By.id("email")).sendKeys(VALID_EMAIL);
        driver.findElement(By.id("phone-number")).sendKeys(VALID_NUMBER);
        driver.findElement(By.id("company")).sendKeys(VALID_COMPANY);
        driver.findElement(By.id("secret-word")).sendKeys(VALID_SECRET_WORD);
        driver.findElement(By.id("password")).sendKeys(VALID_PASSWORD);
        driver.findElement(By.id("confirmPassword")).sendKeys(VALID_PASSWORD);
        driver.findElement(By.id("inv-btn")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actual = driver.getTitle();
        Assert.assertEquals(actual, EXPECTED_TITLE_REGISTRATION);
    }

    @Test
    public void test14_emptyPassword_Registration_MSD90() {
        driver.findElement(By.id("login-registration")).sendKeys(VALID_LOGIN);
        driver.findElement(By.id("email")).sendKeys(VALID_EMAIL);
        driver.findElement(By.id("phone-number")).sendKeys(VALID_NUMBER);
        driver.findElement(By.id("company")).sendKeys(VALID_COMPANY);
        driver.findElement(By.id("secret-word")).sendKeys(VALID_SECRET_WORD);
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("confirmPassword")).sendKeys(VALID_PASSWORD);
        driver.findElement(By.id("inv-btn")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actual = driver.getTitle();
        Assert.assertEquals(actual, EXPECTED_TITLE_REGISTRATION);
    }

    @Test
    public void test15_checkPasswordRegisterSensitivity_Registration_MSD93() {
        driver.findElement(By.id("login-registration")).sendKeys(VALID_LOGIN);
        driver.findElement(By.id("email")).sendKeys(VALID_EMAIL);
        driver.findElement(By.id("phone-number")).sendKeys(VALID_NUMBER);
        driver.findElement(By.id("company")).sendKeys(VALID_COMPANY);
        driver.findElement(By.id("secret-word")).sendKeys(VALID_SECRET_WORD);
        driver.findElement(By.id("password")).sendKeys(PASSWORD_TEST_LOWERCASE);
        driver.findElement(By.id("confirmPassword")).sendKeys(PASSWORD_TEST_LOWERCASE);
        driver.findElement(By.id("inv-btn")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actual = driver.getTitle();
        Assert.assertEquals(actual, EXPECTED_TITLE_REGISTRATION);
    }

    @Test
    public void test16_emptySecretWord_Registration_MSD158() {
        driver.findElement(By.id("login-registration")).sendKeys(VALID_LOGIN);
        driver.findElement(By.id("email")).sendKeys(VALID_EMAIL);
        driver.findElement(By.id("phone-number")).sendKeys(VALID_NUMBER);
        driver.findElement(By.id("company")).sendKeys(VALID_COMPANY);
        driver.findElement(By.id("secret-word")).sendKeys(SECRET_WORD_EMPTY);
        driver.findElement(By.id("password")).sendKeys(VALID_PASSWORD);
        driver.findElement(By.id("confirmPassword")).sendKeys(VALID_PASSWORD);
        driver.findElement(By.id("inv-btn")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actual = driver.getTitle();
        Assert.assertEquals(actual, EXPECTED_TITLE_REGISTRATION);
    }

    @Test
    public void test17_notValidLengthSecretWord_Registration_MSD158() {
        driver.findElement(By.id("login-registration")).sendKeys(VALID_LOGIN);
        driver.findElement(By.id("email")).sendKeys(VALID_EMAIL);
        driver.findElement(By.id("phone-number")).sendKeys(VALID_NUMBER);
        driver.findElement(By.id("company")).sendKeys(VALID_COMPANY);
        driver.findElement(By.id("secret-word")).sendKeys(SECRET_WORD_2SYMBOLS);
        driver.findElement(By.id("password")).sendKeys(VALID_PASSWORD);
        driver.findElement(By.id("confirmPassword")).sendKeys(VALID_PASSWORD);
        driver.findElement(By.id("inv-btn")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actual = driver.getTitle();
        Assert.assertEquals(actual, EXPECTED_TITLE_REGISTRATION);
    }

    @Test
    public void test18_link_AlreadyHaveAnAccount_Registration_MSD97 ()  {
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/a")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actual = driver.getTitle();
        Assert.assertEquals(actual, EXPECTED_TITLE_AUTHORIZATION);
    }
}


