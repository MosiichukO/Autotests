package Interface;

import org.openqa.selenium.WebElement;

public interface IMainPage extends IPage {
    WebElement getRandomNameButton();

    WebElement getDropDownButton();

    WebElement getDomainRoverInfo();

    WebElement waitForVisibility(WebElement element, int timeOfWait, int... timeOfTryOut);

    WebElement getEmailName();

    WebElement getSettingsButton();

    WebElement getSecretAddress();

    WebElement getCloseSettingsButton();

    WebElement getStringWaitingLetters();

    WebElement getWriteButton();

    WebElement getSendButton();

    WebElement getInputEmailTo();

    WebElement getInputEmailTheme();

    WebElement getInputEmailBody();

    WebElement sendKeysEmail(WebElement writeTo, String to, WebElement writeTheme, String theme,
                             WebElement writeWhat, String body);

    WebElement getNewLetterIncome();

    WebElement getReplyButton();

    WebElement checkSenderEmailComponents(WebElement email, String exp1, WebElement theme, String exp2,
                                          WebElement body, String exp3);

    WebElement getSenderEmail();

    WebElement getIncomeLetterTheme();

    WebElement getIncomeLetterBody();

    WebElement sendKeyBodyReplyEmail(WebElement element, String str);

    WebElement getBackButton();

    WebElement checkLetterWithRe(WebElement element, String theme);

    WebElement getThemeOfIncomeLetterMainPage();

    WebElement getOpenLastIncomeLetterMainPage();

    WebElement deleteLetter(WebElement delete, WebElement confirm) throws InterruptedException;

    WebElement getDeleteLetter ();

    WebElement getConfirmDeleteLetter();
}
