import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.disappear;

public class BetTest {

    @BeforeMethod(description = "Open web site")
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.browserSize = "3600x3600";
        Selenide.open("https://22bet.co.ke/ru");
        MainPageSteps mainPageSteps = new MainPageSteps();
        mainPageSteps.stepAcceptCookie();
        mainPageSteps.stepScrollToEvent();
        Assert.assertTrue(mainPageSteps.coefficient.isDisplayed(), "Не отображается коэффицент");
        mainPageSteps.stepClickCoefficient();
    }

    @AfterMethod(description = "Clear cache and close browser")
    public void tearDown(){
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }

    @Test(description = "Проверить данные в купоне после клика по коэффиценту")
    public void betAppearsInCouponTest(){
       MainPageSteps mainPageSteps = new MainPageSteps();
       mainPageSteps.stepCheckBetElementsInCouponAreVisible();
       mainPageSteps.stepCheckDropDownMenu();
       Assert.assertTrue(mainPageSteps.stepCheckLeagueNameInCoupon(), "Не корректное название лиги в купоне");
       Assert.assertTrue(mainPageSteps.stepCheckTeamsNameInCoupon(), "Не корректное название команд в купоне");
       Assert.assertTrue(mainPageSteps.stepCheckCoefficientInCoupon(), "Не корректный коэффицент в купоне");
       Assert.assertTrue(mainPageSteps.stepCheckCoefficientTypeInCoupon(),
               "Не корректный тип коэффицента в купоне");
    }

    @Test(description = "Проверить что данные не отображаются после удаления ставки после клика по кнопке очистить")
    public void betDisappearsAfterClickClearButtonTest(){
        MainPageSteps mainPageSteps = new MainPageSteps();
        betAppearsInCouponTest();
        mainPageSteps.stepClearButtonClick();
        Assert.assertTrue(mainPageSteps.coupon.is(disappear), "Отображаетса ставка");
    }

    @Test(description = "Проверить что данные не отображаются после удаления ставки после клика по крестику")
    public void betDisappearsAfterClickDeleteRateTest(){
        MainPageSteps mainPageSteps = new MainPageSteps();
        betAppearsInCouponTest();
        mainPageSteps.stepDeleteRateButtonClick();
        Assert.assertTrue(mainPageSteps.coupon.is(disappear), "Отображаетса ставка");
    }

    @Test(description = "Проверить что данные не отображаются после повторноко клика по коэфиценту")
    public void betDisappearsAfterClickOnCoefficientTest(){
        MainPageSteps mainPageSteps = new MainPageSteps();
        betAppearsInCouponTest();
        mainPageSteps.stepClickCoefficient();
        Assert.assertFalse(mainPageSteps.stepCheckBetElementsInCouponAreNotVisible(), "Отображаетса ставка");
    }
}
