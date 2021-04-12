package Homework;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Homework.Attributes.*;

public class PageObject {

    WebDriver driver;
    WebDriverWait wait;

    public static By randomNameButton = By.id(ID_RANDOM_NAME);
    public static By dropDownButton = By.id(ID_DOMAIN);
    public static By domainRoverInfo = By.xpath(XPATH_DOMAIN_ROVERINFO);
    public static By emailName = By.id(ID_EMAIL_NAME);
    public static By settingsButton = By.id(ID_SETTINGS);
    public static By secretAddress = By.id(ID_SECRET_ADDRESS);
    public static By closeSettingsButton = By.xpath(XPATH_CLOSE_SETTINGS_BUTTON);
    public static By stringWaitingLetters = By.xpath(XPATH_WAITING_LETTERS_TEXT);
    public static By writeButton = By.xpath(XPATH_WRITE_BUTTON);
    public static By sendButton = By.xpath(XPATH_SEND_BUTTON);
    public static By inputEmailTo = By.xpath(XPATH_LETTER_TO);
    public static By inputEmailTheme = By.xpath(XPATH_LETTER_THEME);
    public static By inputEmailBody = By.xpath(XPATH_LETTER_BODY);
    public static By newLetterIncome = By.xpath(XPATH_NEW_LETTER_INCOME);
    public static By replyButton = By.xpath(XPATH_REPLY_BUTTON);
    public static By senderEmail = By.xpath(XPATH_SENDER_EMAIL);
    public static By incomeLetterTheme = By.xpath(XPATH_THEME_INCOME_LETTER);
    public static By incomeLetterBody = By.xpath(XPATH_BODY_INCOME_LETTER);
    public static By backButton = By.xpath(XPATH_BACK_BUTTON);
    public static By deleteAllButton = By.xpath(XPATH_DELETE_ALL);
    public static By themeOfIncomeLetterMainPage = By.xpath(XPATH_THEME_INCOME_LETTER_MAINPAGE);
    public static By openIncomeLetterMainPage = By.xpath(XPATH_INCOME_LETTER_MAINPAGE);
    public static By deleteLetter = By.xpath(XPATH_DELETE_LETTER_BUTTON);
    public static By confirmDeleteLetter = By.xpath(XPATH_CONFIRM_DELETE_LETTER_BUTTON);


    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForVisibility(By by) {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }

    public void clickButton(By by) {
        driver.findElement(by).click();
    }

    public void clickButtonWithWaitIt (By by) {
        waitForVisibility(by);
        driver.findElement(by).click();
    }

    public String rememberEmail () {
        return driver.findElement(emailName)
                .getAttribute("value") + EMAIL_DOMAIN;
    }

    public String rememberSecretAddress () {
        waitForVisibility(secretAddress);
        return driver.findElement(secretAddress).getAttribute("textContent");
    }

    public boolean isVisibleOrNo (By by) {
        return driver.findElement(by).isDisplayed();
    }

    public String isWaitingStringIsVisible () {
        return driver.findElement(stringWaitingLetters).getAttribute("textContent");
    }

    public void sendKeysEmail (String to, String theme, String body) {
        driver.findElement(inputEmailTo).sendKeys(to);
        driver.findElement(inputEmailTheme).sendKeys(theme);
        driver.findElement(inputEmailBody).sendKeys(body);
    }

    public void checkSenderEmailComponents (By by, String str) {
        String forCheck = driver.findElement(by).getAttribute("textContent");
        Assert.assertEquals(str, forCheck);
    }

    public void sendKeyBodyReplyEmail (String str) {
        driver.findElement(inputEmailBody).sendKeys(str);
    }

    public void checkLetterWithRe (String theme) {
        String resendEmail = "Re: " + theme;
        waitForVisibility(deleteAllButton);
        String toCheckRe = driver.findElement(themeOfIncomeLetterMainPage).getAttribute("textContent");
        Assert.assertEquals(resendEmail, toCheckRe);
    }

    public void deleteLetter () {
        driver.findElement(deleteLetter).click();
        waitForVisibility(confirmDeleteLetter);
        driver.findElement(confirmDeleteLetter).click();
    }

    public void checkLetterNotExist (String str) {
        waitForVisibility(deleteAllButton);
        Assert.assertFalse(driver.getPageSource().contains("Re: Test"));
    }

}
