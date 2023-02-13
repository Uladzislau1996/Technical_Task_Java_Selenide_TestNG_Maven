import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BetTest {

    @BeforeMethod(description = "Open web site")
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.browserSize = "3600x3600";
        Selenide.open("https://22bet.co.ke/ru");
        MainPageSteps mainPageSteps = new MainPageSteps();
        mainPageSteps.acceptCookie.click();
        mainPageSteps.betCoefficients1.click();
    }

    @AfterMethod(description = "Clear cache and close browser")
    public void tearDown(){
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }

    @Test(description = "Проверить данные в купоне после клика по коэффиценту")
    public void betAppearsInTheCouponTest(){
       MainPageSteps mainPageSteps = new MainPageSteps();
       mainPageSteps.stepCheckBetElementsInCouponAreVisible();
       mainPageSteps.stepCheckDropDownMenu();
       mainPageSteps.stepCheckLeagueNameNameInCoupon();
       mainPageSteps.stepCheckTeamsNameInCoupon();
       mainPageSteps.stepCheckCoefficientInCoupon();
       mainPageSteps.stepCheckTypeOfCoefficientInCoupon();
    }

    @Test(description = "Проверить что данные не отображаются после удаления ставки после клика по кнопке очистить")
    public void betDisappearsInTheCouponAfterDeletionAllRatesTest(){
        MainPageSteps mainPageSteps = new MainPageSteps();
        mainPageSteps.betInfoDeleteRatesButton.click();
        mainPageSteps.stepCheckBetElementsInCouponAreNotVisible();
    }

    @Test(description = "Проверить что данные не отображаются после удаления ставки после клика по крестику")
    public void betDisappearsInTheCouponAfterDeletionAllRateTest(){
        MainPageSteps mainPageSteps = new MainPageSteps();
        mainPageSteps.betInfoDeleteRateButton.click();
        mainPageSteps.stepCheckBetElementsInCouponAreNotVisible();
    }

    @Test(description = "Проверить что данные не отображаются после повторноко клика по коэфиценту")
    public void betDisappearsInTheCouponAfterClickOnCoefficientTest(){
        MainPageSteps mainPageSteps = new MainPageSteps();
        mainPageSteps.betCoefficients1.click();
        mainPageSteps.stepCheckBetElementsInCouponAreNotVisible();
    }



}
