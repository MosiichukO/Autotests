package Homework;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Homework.Attributes.*;
import static Homework.PageObject.*;


public class AutoTests_HW {

    @Before
    public void setUp() {
        Singleton.initialize();
    }


    @Test
    public void test_checkFunctional() {

        PageObject po = new PageObject(Singleton.driver);

        po.clickButton(randomNameButton);                                                                       // 3.2

        po.clickButton(dropDownButton);                                                                         // 3.3
        po.clickButtonWithWaitIt(domainRoverInfo);

        String textOfEmail = po.rememberEmail();                                                                // 3.4

        po.clickButton(settingsButton);                                                                         // 3.5

//        wait.until(ExpectedConditions.elementToBeClickable(By.
//                xpath(XPATH_TEN_MINUTES_BUTTON))).click();
//        Singleton.driver.findElement(By.xpath(SAVE_BUTTON)).click();
//
//        settings.click();
//
//        String checkActive = Singleton.driver.findElement((By.
//                xpath(XPATH_TEN_MINUTES_BUTTON))).getAttribute("class");
//       Assert.assertTrue(checkActive.contains("active"));

        String secretAddress = po.rememberSecretAddress();                                                      // 3.6
        po.clickButtonWithWaitIt(closeSettingsButton);

        po.waitForVisibility(randomNameButton);                                                                 // 3.7
        Assert.assertTrue(po.isVisibleOrNo(randomNameButton));

        String waitingForLetters = po.isWaitingStringIsVisible();                                               // 3.8
        Assert.assertEquals("В ожидании новых писем...", waitingForLetters);

        po.clickButton(writeButton);                                                                            // 3.9

        po.waitForVisibility(sendButton);                                                                       // 3.10
        Assert.assertTrue(po.isVisibleOrNo(sendButton));
        po.sendKeysEmail(textOfEmail, "Test", secretAddress);

        po.clickButton(sendButton);                                                                             // 3.11

        po.clickButtonWithWaitIt(newLetterIncome);                                                              // 3.12

        po.waitForVisibility(replyButton);                                                                      // 3.13
        po.checkSenderEmailComponents(senderEmail, textOfEmail);
        po.checkSenderEmailComponents(incomeLetterTheme, "Test");
        po.checkSenderEmailComponents(incomeLetterBody, secretAddress);

        po.clickButton(replyButton);                                                                            // 3.14
        po.waitForVisibility(sendButton);
        po.sendKeyBodyReplyEmail("Test2");
        po.clickButton(sendButton);

        po.clickButtonWithWaitIt(backButton);                                                                   // 3.15


        po.checkLetterWithRe("Test");                                                                     // 3.16
        po.clickButtonWithWaitIt(openIncomeLetterMainPage);

        po.waitForVisibility(incomeLetterBody);                                                                 // 3.17
        po.checkSenderEmailComponents(incomeLetterBody, "Test2");

        po.deleteLetter();                                                                                      // 3.18

        po.checkLetterNotExist("Re: Test");                                                                 // 3.19
    }

    @After
    public void finish() {
        Singleton.quit();
    }
}
