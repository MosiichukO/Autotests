package Pages;

import Core.DriverFactory;
import Interface.IMainPage;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@Getter

public class MainPage implements IMainPage {

    public MainPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    WebDriverWait wait;

    @FindBy(css = "#pre_rand")
    private WebElement randomNameButton;

    @FindBy(css = "#domain")
    private WebElement dropDownButton;

    @FindBy(css = "#pre_form > div > div.dropdown.mb-30.mb-md-0.show > div > button:nth-child(6)")
    private WebElement domainRoverInfo;

    @FindBy(css = "#pre_settings")
    private WebElement settingsButton;

    @FindBy(css = "#pre_button")
    private WebElement emailName;

    @FindBy(css = "#secret-address")
    private WebElement secretAddress;

    @FindBy(css = "#modal-settings > div > form > div.modal-header > div > button")
    private WebElement closeSettingsButton;

    @FindBy(css = "#container-body > div > div.inbox > div > span")
    private WebElement stringWaitingLetters;

    @FindBy(css = "#compose")
    private WebElement writeButton;

    @FindBy(css = "#submit")
    private WebElement sendButton;

    @FindBy(css = "#to")
    private WebElement inputEmailTo;

    @FindBy(css = "#subject")
    private WebElement inputEmailTheme;

    @FindBy(css = "#text")
    private WebElement inputEmailBody;

    @FindBy(css = "#container-body > div > div.inbox > div.mail > div")
    private WebElement newLetterIncome;

    @FindBy(css = "#reply")
    private WebElement replyButton;

    @FindBy(css = "#info > div.row.row-info.no-gutters > div.col.d-flex.mb-10 > span")
    private WebElement senderEmail;

    @FindBy(css = "#info > div.subject.mb-20")
    private WebElement incomeLetterTheme;

    @FindBy(css = "#info > div.overflow-auto.mb-20")
    private WebElement incomeLetterBody;

    @FindBy(css = "#back")
    private WebElement backButton;

    @FindBy(css = "#container-body > div > div.inbox > div:nth-child(2) > div > div.subj.col-12.col-md-7.px-md-3 > span")
    private WebElement themeOfIncomeLetterMainPage;

    @FindBy(css = "#container-body > div > div.inbox > div:nth-child(2) > div > div.subj.col-12.col-md-7.px-md-3")
    private WebElement openLastIncomeLetterMainPage;

    @FindBy(css = "#delete_mail")
    private WebElement deleteLetter;

    @FindBy(css = "#confirm_mail")
    private WebElement confirmDeleteLetter;


    public WebElement waitForVisibility(WebElement element, int timeOfWait, int... timeOfTryOut) {
        WebElement webElement = null;
        int timeOfRevision = timeOfTryOut.length == 0
                ? 100
                : timeOfTryOut[0];
        try {
            webElement = new WebDriverWait(DriverFactory.getDriver(),
                    timeOfWait,
                    timeOfRevision
            ).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webElement;
    }

    public WebElement sendKeysEmail(WebElement writeTo, String to, WebElement writeTheme, String theme, WebElement writeWhat, String body) {
        writeTo.sendKeys(to);
        writeTheme.sendKeys(theme);
        writeWhat.sendKeys(body);
        return writeTo;
    }

    public WebElement checkSenderEmailComponents(WebElement email, String exp1, WebElement theme, String exp2,
                                                 WebElement body, String exp3) {
        String checkEmail = email.getAttribute("textContent");
        Assert.assertEquals(exp1, checkEmail);
        String checkTheme = theme.getAttribute("textContent");
        Assert.assertEquals(exp2, checkTheme);
        String checkBody = body.getAttribute("textContent");
        Assert.assertEquals(exp3, checkBody);
        return email;
    }

    public WebElement sendKeyBodyReplyEmail(WebElement element, String str) {
        element.sendKeys(str);
        return element;
    }

    public WebElement checkLetterWithRe(WebElement element, String theme) {
        String resendEmail = "Re: " + theme;
        String toCheckRe = element.getAttribute("textContent");
        Assert.assertEquals(resendEmail, toCheckRe);
        return element;
    }

    public WebElement deleteLetter(WebElement delete, WebElement confirm) throws InterruptedException {
        delete.click();
        Thread.sleep(500);
        confirm.click();
        return delete;
    }

}
