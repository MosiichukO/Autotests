package Steps;

import Core.Config;
import Core.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java8.Th;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPageSteps extends Steps {

    String myRandomEmail;
    String mySecretAddress;

    @Given("^I open Main page$")
    public void iOpenMainPage() {
        log.info("I open Main page");
        DriverFactory.getDriver().get(Config.URL_SITE);
        DriverFactory.initialize();
    }

    @And("^I click random name button$")
    public void iClickRandomNameButton() {
        log.info("I click random name button");
        iMainPage.getRandomNameButton().click();
    }

    @And("^I click dropdown domain button$")
    public void iClickDropdownDomainButton() {
        log.info("I click dropdown domain button");
        iMainPage.getDropDownButton().click();
    }

    @And("^I wait for visibility of (.*) element (\\d+) seconds$")
    public void iWaitVisibilityElementSeconds(String element, Integer seconds) {
        log.info("I wait for visibility of " + element + " element " + seconds + " seconds");
        WebElement webElement = null;
        if (element.equalsIgnoreCase("rover info domain")) {
            webElement = iMainPage.getDomainRoverInfo();
        } else if (element.equalsIgnoreCase("secret address")) {
            webElement = iMainPage.getSecretAddress();
        } else if (element.equalsIgnoreCase("drop down button")) {
            webElement = iMainPage.getDropDownButton();
        } else if (element.equalsIgnoreCase("send button")) {
            webElement = iMainPage.getSendButton();
        } else if (element.equalsIgnoreCase("new letter income")) {
            webElement = iMainPage.getNewLetterIncome();
        } else if (element.equalsIgnoreCase("reply button")) {
            webElement = iMainPage.getReplyButton();
        }
        iMainPage.waitForVisibility(webElement, seconds, 100);
    }

    @And("^I click rover info domain$")
    public void iClickRoverInfoDomain() {
        log.info("I click rover info domain");
        iMainPage.getDomainRoverInfo().click();
    }

    @Then("^I check that choose (.*) domain$")
    public void iCheckThatChooseNeededDomain(String domain) {
        log.info("I check that choose " + domain + " domain");
        Assert.assertEquals(
                "Invalid domain " + domain,
                domain,
                iMainPage.getDropDownButton().getText()
        );
    }

    @And("^I remember the (.*)$")
    public void iRememberTheEmail(String element) {
        log.info("I remember the " + element);
        if (element.equalsIgnoreCase("email")) {
            myRandomEmail = iMainPage.getEmailName().getAttribute("value") + iMainPage.getDropDownButton().getText();
        } else if (element.equalsIgnoreCase("secret address")) {
            mySecretAddress = iMainPage.getSecretAddress().getAttribute("textContent");
        }
    }

    @And("^I click settings button$")
    public void iClickSettingsButton() {
        log.info("I click settings button");
        iMainPage.getSettingsButton().click();
    }

    @And("^I click close settings button$")
    public void iClickCloseSettingsButton() throws InterruptedException {
        log.info("I click close settings button");
        Thread.sleep(300);
        iMainPage.getCloseSettingsButton().click();
    }

    @Then("^I check the settings modal window is closed$")
    public void iCheckTheSettingsModalWindowIsClosed() {
        log.info("I check the settings modal window is closed");
        Assert.assertTrue("Settings modal window is not closed",
                iMainPage.getDropDownButton().isDisplayed());
    }

    @Then("^I check waiting letters string is visible$")
    public void iCheckWaitingLettersStringIsVisible() {
        log.info("I check waiting letters string is visible");
        iMainPage.waitForVisibility(iMainPage.getStringWaitingLetters(), 10);
        Assert.assertEquals("Waiting letters text is incorrect",
                "В ожидании новых писем...",
                iMainPage.getStringWaitingLetters().getAttribute("textContent"));
    }

    @And("^I click write letter button$")
    public void iClickWriteLetterButton() throws InterruptedException {
        log.info("I click write letter button");
        Thread.sleep(300);
        iMainPage.getWriteButton().click();
    }

    @And("^I write the letter to my email with theme - Test and body - my secret address$")
    public void iWriteTheLetterToMyEmailThemeBodyMySecretAddress() {
        log.info("I write the letter to my email with theme - Test and body - my secret address");
        iMainPage.sendKeysEmail(
                iMainPage.getInputEmailTo(), myRandomEmail,
                iMainPage.getInputEmailTheme(), "Test",
                iMainPage.getInputEmailBody(), mySecretAddress);
    }

    @And("^I click send letter button$")
    public void iClickSendLetterButton() {
        log.info("I click send letter button");
        iMainPage.getSendButton().click();
    }

    @And("^I click new letter income$")
    public void iClickNewLetterIncome() {
        log.info("I click new letter income");
        iMainPage.getNewLetterIncome().click();
    }

    @Then("^I check the components of email income$")
    public void iCheckTheComponentsOfEmailIncome() {
        log.info("I check the components of email income");
        iMainPage.checkSenderEmailComponents(
                iMainPage.getSenderEmail(), myRandomEmail,
                iMainPage.getIncomeLetterTheme(), "Test",
                iMainPage.getIncomeLetterBody(), mySecretAddress);
    }

    @And("^I click reply button$")
    public void iClickReplyButton() throws InterruptedException {
        log.info("I click reply button");
        iMainPage.getReplyButton().click();
    }

    @And("^I write to body - TestTwo$")
    public void iWriteToBodyTestTwo() throws InterruptedException {
        log.info("I write to body - TestTwo");
        Thread.sleep(700);
        iMainPage.sendKeyBodyReplyEmail(iMainPage.getInputEmailBody(), "Test2");
    }

    @And("^I wait (\\d+) seconds$")
    public void iWaitSeconds(int seconds) {
        log.info("I wait " + seconds + " seconds");
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    @And("^I click back button$")
    public void iClickBackButton() {
        log.info("I click back button");
        iMainPage.getBackButton().click();
    }

    @Then("^I check letter with Re$")
    public void iCheckLetterWithRe() {
        log.info("I check letter with Re");
        iMainPage.checkLetterWithRe(iMainPage.getThemeOfIncomeLetterMainPage(), "Test");
    }

    @And("^I open last income letter$")
    public void iOpenLastIncomeLetter() {
        log.info("I open last income letter");
        iMainPage.getOpenLastIncomeLetterMainPage().click();
    }

    @Then("^I check the components of letter with Re$")
    public void iCheckTheComponentsOfLetterWithRe() {
        log.info("I check the components of letter with Re");
        iMainPage.checkSenderEmailComponents(
                iMainPage.getSenderEmail(), myRandomEmail,
                iMainPage.getIncomeLetterTheme(), "Re: Test",
                iMainPage.getIncomeLetterBody(), "Test2");
    }

    @And("^I delete the letter$")
    public void iDeleteTheLetter() throws InterruptedException {
        log.info("I delete the letter");
        iMainPage.deleteLetter(iMainPage.getDeleteLetter(), iMainPage.getConfirmDeleteLetter());
    }

    @Then("^I check that Re letter is not exist$")
    public void iCheckThatReLetterIsNotExist() throws InterruptedException {
        log.info("I check that Re letter is not exist");
        Thread.sleep(500);
        Assert.assertFalse(DriverFactory.getDriver().getPageSource().contains("Re: Test"));
        DriverFactory.quit();
    }
}
