package Homework;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Homework.Attributes.*;


public class AutoTests_HW {

    @Before
    public void setUp() {
        Singleton.initialize();
    }


    @Test
    public void test_checkFunctional() {

        WebElement randomName = Singleton.driver.findElement(By.id(ID_RANDOM_NAME));      // 3.2
        randomName.click();

        Singleton.driver.findElement(By.id(ID_DOMAIN)).click();           // 3.3
        WebDriverWait wait = new WebDriverWait(Singleton.driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.
                xpath(XPATH_DOMAIN_ROVERINFO)))
                .click();

        String nameOfEmail = Singleton.driver.findElement(By.id(ID_EMAIL_NAME))  // 3.4
                .getAttribute("value") + EMAIL_DOMAIN;

        WebElement settings = Singleton.driver.findElement(By.id(ID_SETTINGS)); // 3.5
        settings.click();


//        wait.until(ExpectedConditions.elementToBeClickable(By.
//                xpath(XPATH_TEN_MINUTES_BUTTON))).click();
//        Singleton.driver.findElement(By.xpath(SAVE_BUTTON)).click();
//
//        settings.click();
//
//        String checkActive = Singleton.driver.findElement((By.
//                xpath(XPATH_TEN_MINUTES_BUTTON))).getAttribute("class");
//       Assert.assertTrue(checkActive.contains("active"));


        String secretAddress = wait.until(ExpectedConditions                                               // 3.6
                .visibilityOfElementLocated(By.id(ID_SECRET_ADDRESS))).getAttribute("textContent");
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath(XPATH_CLOSE_SETTINGS_BUTTON))).click();

        wait.until(ExpectedConditions.visibilityOf(randomName));  // 3.7
        Assert.assertTrue(randomName.isDisplayed());


        WebElement waitingLetters = Singleton.driver.findElement(By.xpath(XPATH_WAITING_LETTERS_TEXT));     // 3.8
        String waitingLettersString = Singleton.driver.findElement(By.xpath(XPATH_WAITING_LETTERS_TEXT)).getAttribute("textContent");
        Assert.assertEquals("В ожидании новых писем...", waitingLettersString);
        Assert.assertTrue(waitingLetters.isDisplayed());


        Singleton.driver.findElement(By.xpath(XPATH_WRITE_BUTTON)).click(); // 3.9

        WebElement sendButton = Singleton.driver.findElement(By.xpath(XPATH_SEND_BUTTON)); // 3.10
        wait.until(ExpectedConditions.visibilityOf(sendButton));
        Assert.assertTrue(sendButton.isDisplayed());
        Singleton.driver.findElement(By.xpath(XPATH_LETTER_TO))
                .sendKeys(nameOfEmail);
        Singleton.driver.findElement(By.xpath(XPATH_LETTER_THEME))
                .sendKeys("Test");
        Singleton.driver.findElement(By.xpath(XPATH_LETTER_BODY))
                .sendKeys(secretAddress);


        sendButton.click();      // 3.11


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_NEW_LETTER_INCOME))).click(); // 3.12

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_REPLY_BUTTON))); // 3.13
        WebElement replyButton = Singleton.driver.findElement(By.xpath(XPATH_REPLY_BUTTON));

        String senderName = Singleton.driver.findElement(By.xpath(XPATH_SENDER_EMAIL))
                .getAttribute("textContent");
        Assert.assertEquals(nameOfEmail, senderName);

        String themeOfEmail = Singleton.driver.findElement(By.xpath(XPATH_THEME_INCOME_LETTER))
                .getAttribute("textContent");
        Assert.assertEquals("Test", themeOfEmail);

        String textOfEmail = Singleton.driver.findElement(By.xpath(XPATH_BODY_INCOME_LETTER))
                .getAttribute("textContent");
        Assert.assertEquals(secretAddress, textOfEmail);


        replyButton.click();                                                    // 3.14
        wait.until(ExpectedConditions.visibilityOf(sendButton));
        Singleton.driver.findElement(By.xpath(XPATH_LETTER_BODY)).sendKeys("Test2");
        sendButton.click();


        wait.until(ExpectedConditions.                                          // 3.15
                elementToBeClickable(By.xpath(XPATH_BACK_BUTTON))).click();


        String resendEmail = "Re: " + themeOfEmail;  // 3.16
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_DELETE_ALL)));

        String toCheckRe = Singleton.driver.findElement(By.xpath(XPATH_THEME_INCOME_LETTER_MAINPAGE))
                .getAttribute("textContent");
        Assert.assertEquals(resendEmail, toCheckRe);

        Singleton.driver.findElement(By.xpath(XPATH_INCOME_LETTER_MAINPAGE)).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_BODY_INCOME_LETTER)));  // 3.17

        String textOfEmailRe = Singleton.driver.findElement(By.xpath(XPATH_BODY_INCOME_LETTER)).getAttribute("textContent");
        Assert.assertEquals("Test2", textOfEmailRe);


        Singleton.driver.findElement(By.xpath(XPATH_DELETE_LETTER_BUTTON)).click(); // 3.18
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath(XPATH_CONFIRM_DELETE_LETTER_BUTTON))).click();


        wait.until(ExpectedConditions                                      // 3.19
                .visibilityOfElementLocated(By.xpath(XPATH_DELETE_ALL)));
        Assert.assertFalse(Singleton.driver.getPageSource().contains("Re: Test"));
    }

    @After
    public void finish() {
        Singleton.quit();
    }
}
