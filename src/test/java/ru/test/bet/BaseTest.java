package ru.test.bet;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static config.SelenideConfig.config;
import static org.testng.Assert.assertTrue;

public class BaseTest {

    MainPageSteps mainPageSteps;

    @BeforeMethod(description = "Open web site")
    public void setUp() {
        config();
        mainPageSteps = MainPageSteps.openPage();
        mainPageSteps.acceptCookie();
        mainPageSteps.isEventVisible();
        mainPageSteps.scrollEvent();
        mainPageSteps.isCoefficientVisible();
        mainPageSteps.clickCoefficient();
    }

    @AfterMethod(description = "Clear cache and close browser")
    public void tearDown(){
        clearBrowserCookies();
        closeWebDriver();
    }

}
