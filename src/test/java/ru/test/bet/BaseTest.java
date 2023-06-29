package ru.test.bet;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import ru.test.bet.BaseActions.BaseActions;
import ru.test.bet.pages.MainPage;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static ru.test.bet.config.SelenideConfiguration.config;

public class BaseTest extends BaseActions {

    MainPage mainPage;

    @BeforeClass(description = "Применить конфигурации, открыть сайт и выбрать коэффицент")
    public void setUp() {
        config();
        mainPage = MainPage.openPage();
        mainPage.acceptCookie();
        mainPage.checkEventIsVisible();
        mainPage.scrollEvent();
        mainPage.checkCoefficientVisible();
        mainPage.clickCoefficient();
    }

    @AfterMethod
    public void addScreenShot(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SKIP) {
            attachScreenshot();
        }
    }

    @AfterClass(description = "Очистить кэш и куки")
    public void tearDown() {
        clearBrowserCookies();
        closeWebDriver();
    }


}
