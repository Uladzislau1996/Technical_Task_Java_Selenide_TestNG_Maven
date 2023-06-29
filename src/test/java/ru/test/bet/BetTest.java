package ru.test.bet;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class BetTest extends BaseTest {


    @Test(priority = 1, description = "Проверка, данных в купоне после клика по коэффиценту и что данные удалаются")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка данных в купоне и удаление ставки")
    public void OpenAndDeleteCouponTest(){
        List<SelenideElement> couponElements = mainPage.checkElementsCouponAreVisible();

        for (SelenideElement couponElement : couponElements) {
            couponElement.shouldBe(Condition.visible);
        }

        Assert.assertEquals(couponElements.size(), 14, "Incorrect bla bla");
        mainPage.checkElementsCouponAreVisible();
        mainPage.checkDropDownMenu();
        assertTrue(mainPage.isCouponLeagueCorrect(), "Некорректное название лиги в купоне");
        assertTrue(mainPage.isCouponNameCorrect(), "Некорректное название команд в купоне");
        assertTrue(mainPage.isCouponCoefficientCorrect(), "Некорректный коэффицент в купоне");
        assertTrue(mainPage.isCouponCoefficientTypeCorrect(), "Некорректный тип коэффицента в купоне");
        mainPage.clickClear();
        mainPage.IsCouponNotVisible();
    }


    @Test(priority = 1, description = "Проверка, что данные не отображаются после удаления ставки, после клика по кнопке очистить")
    @Severity(SeverityLevel.NORMAL)
    @Description("Удаление данных кликом по кнопке очистить")
    public void betDisappearsAfterClickClearButtonTest(){
        mainPage.clickCoefficient();
        mainPage.clickClear();
        mainPage.IsCouponNotVisible();
    }

    @Test(priority = 1, description = "Проверка, что данные не отображаются после удаления ставки, после клика по крестику")
    @Severity(SeverityLevel.NORMAL)
    @Description("Удаление данных кликом по крестику")
    public void betDisappearsAfterClickDeleteRateTest(){
        mainPage.clickCoefficient();
        mainPage.clickDeleteRate();
        mainPage.IsCouponNotVisible();
    }

    @Test(priority = 1, description = "Проверка, что данные не отображаются, после повторноко клика по коэфиценту")
    @Severity(SeverityLevel.NORMAL)
    @Description("Удаление данных дабл кликоп по кэфу")
    public void betDisappearsAfterClickOnCoefficientTest(){
        mainPage.clickCoefficient();
        mainPage.clickCoefficient();
        mainPage.IsCouponNotVisible();
    }

    @Test(priority = 2, description = "Проверка текста кнопок в купоне")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка текста кнопок в купоне")
    public void textInCouponTest(){
        mainPage.clickCoefficient();
        String clearButton = mainPage.getClearButtonText();
        assertEquals(clearButton, "Очистить", "Не корректный текст кнопка очистить");
        String stakeAmount = mainPage.getStakeAmountText();
        assertEquals(stakeAmount, "СУММА СТАВКИ (\n" +
                "KES\n" +
                "):", "Не корректный текст кнопка очистить");
        String maximumBet = mainPage.getMaximumBetText();
        assertEquals(maximumBet, "Максимальная ставка:", "Не корректный текст поля максимальная ставка");
        String possibleWin = mainPage.getPossibleWinText();
        assertEquals(possibleWin, "Возможный выигрыш:", "Не корректный текст кнопка очистить");
    }

    @Test(priority = 3, description = "Тест фейлится")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест фейлится")
    public void additionalTest(){
        List<SelenideElement> couponElements = mainPage.checkElementsCouponAreVisible();
        Assert.assertEquals(couponElements.size(), 3, "Incorrect text");
    }

}
