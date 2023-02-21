package ru.test.bet;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.test.bet.pages.MainPageSteps;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static ru.test.bet.config.SelenideConfiguration.config;

public class BaseTest {

    MainPageSteps mainPageSteps;

    @BeforeClass(description = "Применить конфигурации")
    public void setUp(){
        config();
    }

    @BeforeMethod(description = "Выбрать событие и коэффициент")
    public void chooseCoefficient() {
        mainPageSteps = MainPageSteps.openPage();
        mainPageSteps.acceptCookie();
        mainPageSteps.checkEventIsVisible();
        mainPageSteps.scrollEvent();
        mainPageSteps.checkCoefficientVisible();
        mainPageSteps.clickCoefficient();
    }

    @AfterMethod(description = "Очистить кэш и куки")
    public void tearDown(){
        clearBrowserCookies();
        closeWebDriver();
    }

}
