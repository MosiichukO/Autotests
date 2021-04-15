package Homework;

import org.junit.*;
import org.openqa.selenium.WebElement;


public class AutoTests_HW {

    @Before
    public void setUp() {
        Singleton.initialize();
    }


    @Test
    public void test_checkFunctional() throws InterruptedException {

        PageObject po = new PageObject();

        po.getRandomNameButton().click();                                                                       // 3.2

        po.getDropDownButton().click();                                                                         // 3.3
        po.clickButtonWithWaitIt(po.getDomainRoverInfo());

        String textOfEmail = po.rememberEmail(po.getEmailName());                                               // 3.4

        po.getSettingsButton().click();                                                                         // 3.5

        Thread.sleep(500);                                                                                // 3.6
        String secretAddress = po.rememberSecretAddress(po.getSecretAddress());
        po.clickButtonWithWaitIt(po.getCloseSettingsButton());

        WebElement element = po.waitForVisibility(po.getDropDownButton(), 10);                         // 3.7
        Assert.assertTrue(
                "Incorrect element displaying",
                element.isDisplayed()
        );

        po.waitForVisibility(po.getStringWaitingLetters(), 10);         // 3.8
        Assert.assertEquals("Waiting letters text is incorrect",
                "В ожидании новых писем...", po.getStringWaitingLetters().getAttribute("textContent"));

        po.getWriteButton().click();                                                                             // 3.9

        po.waitForVisibility(po.getSendButton(), 10);                                                                       // 3.10
        Assert.assertTrue(po.getSendButton().isDisplayed());
        po.sendKeysEmail(
                po.getInputEmailTo(), textOfEmail,
                po.getInputEmailTheme(), "Test",
                po.getInputEmailBody(), secretAddress);

        po.getSendButton().click();                                                                             // 3.11

        po.clickButtonWithWaitIt(po.getNewLetterIncome());                                                      // 3.12

        po.waitForVisibility(po.getReplyButton(), 10);                                                // 3.13
        po.checkSenderEmailComponents(
                po.getSenderEmail(), textOfEmail,
                po.getIncomeLetterTheme(), "Test",
                po.getIncomeLetterBody(), secretAddress);

        po.getReplyButton().click();                                                                            // 3.14
        po.waitForVisibility(po.getSendButton(), 10);
        po.sendKeyBodyReplyEmail(po.getInputEmailBody(), "Test2");
        Thread.sleep(500);
        po.getSendButton().click();

        Thread.sleep(500);                                                                               // 3.15
        po.getBackButton().click();

        Thread.sleep(500);                                                                               // 3.16
        po.checkLetterWithRe(po.getThemeOfIncomeLetterMainPage(), "Test");
        po.clickButtonWithWaitIt(po.getOpenLastIncomeLetterMainPage());

        po.waitForVisibility(po.getIncomeLetterBody(), 10);                                          // 3.17
        po.checkSenderEmailComponents(
                po.getSenderEmail(), textOfEmail,
                po.getIncomeLetterTheme(), "Re: Test",
                po.getIncomeLetterBody(), "Test2");

        po.deleteLetter(po.getDeleteLetter(), po.getConfirmDeleteLetter());                                    // 3.18

        Thread.sleep(500);                                                                                // 3.19
        Assert.assertFalse(Singleton.getDriver().getPageSource().contains("Re: Test"));
    }

    @After
    public void finish() {
        Singleton.quit();
    }
}
