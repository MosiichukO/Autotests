package frontEnd;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static frontEnd.Constants.*;

public class HeaderLinks {

    @Before
    public void setUp() {
        Logic.initialize();
    }


    @Test
    public void test1_questionLink_HomeToQuestion() {
        Logic.driver.get(HOME_PAGE_URL);
        Logic.LinkFindClick(QUESTION_PAGE_LINKTEXT);
        String actual = Logic.driver.getTitle();
        Assert.assertEquals(QUESTION_PAGE_TITLE, actual);
    }

    @Test
    public void test2_aboutLink_HomeToAbout() {
        Logic.driver.get(HOME_PAGE_URL);
        Logic.LinkFindClick(ABOUT_PAGE_LINKTEXT);
        String actual = Logic.driver.getTitle();
        Assert.assertEquals(actual, ABOUT_PAGE_TITLE);
    }

    @Test
    public void test3_aboutLink_QuestionToAbout() {
        Logic.driver.get(QUESTION_PAGE_URL);
        Logic.LinkFindClick(ABOUT_PAGE_LINKTEXT);
        String actual = Logic.driver.getTitle();
        Assert.assertEquals(actual, ABOUT_PAGE_TITLE);
    }

    @Test
    public void test4_homeLink_AboutToHome() {
        Logic.driver.get(ABOUT_PAGE_URL);
        Logic.LinkFindClick(HOME_PAGE_LINKTEXT);
        String actual = Logic.driver.getTitle();
        Assert.assertEquals(actual, HOME_PAGE_TITLE);
    }


    @Test
    public void test5_questionLink_AboutToQuestion() {
        Logic.driver.get(ABOUT_PAGE_URL);
        Logic.LinkFindClick(QUESTION_PAGE_LINKTEXT);
        String actual = Logic.driver.getTitle();
        Assert.assertEquals(actual, QUESTION_PAGE_TITLE);
    }

    @Test
    public void test6_homeLink_QuestionToHome() {
        Logic.driver.get(QUESTION_PAGE_URL);
        Logic.LinkFindClick(HOME_PAGE_LINKTEXT);
        String actual = Logic.driver.getTitle();
        Assert.assertEquals(actual, HOME_PAGE_TITLE);
    }

    @After
    public void finish() {
        Logic.quit();
    }
}

