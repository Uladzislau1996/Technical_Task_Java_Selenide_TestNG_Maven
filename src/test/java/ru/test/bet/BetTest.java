package ru.test.bet;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BetTest extends BaseTest {

    @Test(description = "Проверить данные в купоне после клика по коэффиценту")
    public void betAppearsInCouponTest(){
        mainPageSteps.elementsCouponAreVisible();
        mainPageSteps.dropDownMenu();
        assertTrue(mainPageSteps.isCouponLeagueCorrect(), "Некорректное название лиги в купоне");
        assertTrue(mainPageSteps.isCouponNameCorrect(), "Некорректное название команд в купоне");
        assertTrue(mainPageSteps.isCouponCoefficientCorrect(), "Не орректный коэффицент в купоне");
        assertTrue(mainPageSteps.isCouponCoefficientTypeCorrect(), "Некорректный тип коэффицента в купоне");
    }

    @Test(description = "Проверить что данные не отображаются после удаления ставки после клика по кнопке очистить")
    public void betDisappearsAfterClickClearButtonTest(){
        betAppearsInCouponTest();
        mainPageSteps.clickClear();
        mainPageSteps.betIsNotVisible();
    }

    @Test(description = "Проверить что данные не отображаются после удаления ставки после клика по крестику")
    public void betDisappearsAfterClickDeleteRateTest(){
        betAppearsInCouponTest();
        mainPageSteps.clickDeleteRate();;
        mainPageSteps.betIsNotVisible();
    }

    @Test(description = "Проверить что данные не отображаются после повторноко клика по коэфиценту")
    public void betDisappearsAfterClickOnCoefficientTest(){
        betAppearsInCouponTest();
        mainPageSteps.clickCoefficient();;
        mainPageSteps.betIsNotVisible();
    }
}
