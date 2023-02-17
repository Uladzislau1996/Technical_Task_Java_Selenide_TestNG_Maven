package ru.test.bet;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BetTest extends BaseTest {

    @Test(description = "Проверка данных в купоне после клика по коэффиценту")
    public void betAppearsInCouponTest(){
        mainPageSteps.checkElementsCouponAreVisible();
        mainPageSteps.checkDropDownMenu();
        assertTrue(mainPageSteps.isCouponLeagueCorrect(), "Некорректное название лиги в купоне");
        assertTrue(mainPageSteps.isCouponNameCorrect(), "Некорректное название команд в купоне");
        assertTrue(mainPageSteps.isCouponCoefficientCorrect(), "Некорректный коэффицент в купоне");
        assertTrue(mainPageSteps.isCouponCoefficientTypeCorrect(), "Некорректный тип коэффицента в купоне");
    }

    @Test(description = "Проверка, что данные не отображаются после удаления ставки, после клика по кнопке очистить")
    public void betDisappearsAfterClickClearButtonTest(){
        mainPageSteps.clickClear();
        mainPageSteps.checkBetIsNotVisible();
    }

    @Test(description = "Проверка, что данные не отображаются после удаления ставки, после клика по крестику")
    public void betDisappearsAfterClickDeleteRateTest(){
        mainPageSteps.clickDeleteRate();
        mainPageSteps.checkBetIsNotVisible();
    }

    @Test(description = "Проверка, что данные не отображаются, после повторноко клика по коэфиценту")
    public void betDisappearsAfterClickOnCoefficientTest(){
        mainPageSteps.clickCoefficient();
        mainPageSteps.checkBetIsNotVisible();
    }
}
