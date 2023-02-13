import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;

public class MainPageSteps extends MainPageLocators {

    public void stepAcceptCookie(){
        step("Кликаю на первый коэффицент", () -> {
            acceptCookie.click();
        });
    }

    public void stepClickOnTheCoefficient(){
        step("Кликаю на первый коэффицент", () -> {
            betCoefficients1.shouldBe(visible, Duration.ofSeconds(120));
            Assert.assertTrue(betCoefficients1.isDisplayed(), "Не отображается кнопка коэфицента");
            betCoefficients1.scrollTo();
            betCoefficients1.click();
        });
    }

    public void stepCheckBetElementsInCouponAreVisible(){
        step("Проверяю наличие элементов в куппоне", () -> {
            betInfo.shouldBe(visible, Duration.ofSeconds(30));
            Assert.assertTrue(betInfo.isDisplayed(), "Не отображается инфо о ставке");
            Assert.assertTrue(betInfoLeagueName.isDisplayed(), "Не отображается название лиги");
            Assert.assertTrue(betInfoTeamsName.isDisplayed(), "Не отображается название команд");
            Assert.assertTrue(betInfoCoefficient.isDisplayed(), "Не отображается коэффицент");
            Assert.assertTrue(betInfoStakeAmount.isDisplayed(), "Не отображается поле сумма ставки");
            Assert.assertTrue(betInfoCounter.isDisplayed(), "Не отображается счетчки с кнопакми и каунтером");
            Assert.assertTrue(betInfoMaximumBet.isDisplayed(), "Не отображается поле максимальная ставки");
            Assert.assertTrue(betInfoMaximumBetMeaning.isDisplayed(), "Не отображается значение максимальное ставки");
            Assert.assertTrue(betInfoPossibleWin.isDisplayed(), "Не отображается поле возможный выйгриш");
            Assert.assertTrue(betInfoPossibleWinMeaning.isDisplayed(), "Не отображается значение поля возможный выйгрыш");
            Assert.assertTrue(betInfoChangingCoefficient.isDisplayed(), "Не отображается поле при изменении коэффицента");
            Assert.assertTrue(betInfoDropDownMenu.isDisplayed(), "Не отображается кнопка для открытия выпадающего списка Подтверждать");
            Assert.assertTrue(betInfoPromoCode.isDisplayed(), "Не отображается поле Промокод");
            Assert.assertTrue(betInfoPromoCodeTextField.isDisplayed(), "Не отображается текстовое поле Промокод");
        });
    }

    public void stepCheckDropDownMenu(){
        step("Проверить пункты меню в дроп даун меню", () -> {
            betInfoDropDownMenu.click();
            betInfoDropDownMenuAcceptWhenRise.shouldBe(visible, Duration.ofSeconds(30));
            Assert.assertTrue(betInfoDropDownMenuAcceptWhenRise.isDisplayed(), "Не отображается кнопка выпадающего списка Принять при повышении");
            Assert.assertTrue(betInfoDropDownMenuConfirm.isDisplayed(), "Не отображается кнопка выпадающего списка Подтверждать");
            Assert.assertTrue(betInfoDropDownAcceptAnyChanges.isDisplayed(), "Не отображается кнопка выпадающего списка Принять любые изменения");
        });
    }

    public void stepCheckLeagueNameNameInCoupon(){
        step("Проверить поле название лиги в купоне", () -> {
            betInfoLeagueName.shouldHave(text(leagueName.getText()));
        });
    }

    public void stepCheckTeamsNameInCoupon(){
        step("Проверить поле название команд в купоне", () -> {
            String fullTeamsName = firstTeamsName.getText() + " - " + secondTeamsName.getText();
            betInfoTeamsName.shouldHave(text(fullTeamsName));
            Assert.assertTrue(betInfoTeamsName.getText().contains(fullTeamsName), "Не корректный текст в названиях команд");
        });
    }

    public void stepCheckCoefficientInCoupon(){
        step("Проверить коэффицент в купоне", () -> {
            Assert.assertTrue(betInfoCoefficient.getText().contains(betCoefficients1.getText()), "Не корректный коэффицент");
        });
    }

    public void stepCheckTypeOfCoefficientInCoupon(){
        step("Проверить тип коэффицента в купоне", () -> {
            Assert.assertTrue(betInfoCoefficientType.getText().contains("1Х2 П1"), "Не корректный тип коэффицента");
        });
    }

    public void stepCheckTextInButtonsAndFields(){
        step("Проверить текст в полях и кнопках", () -> {
            Assert.assertTrue(betInfoStakeAmount.getText().contains("СУММА СТАВКИ (KES):"), "Не корректный текст в поле Сумма ставки");
            Assert.assertTrue(betInfoMaximumBet.getText().contains("Максимальная ставка:"), "Не корректный текст в поле Максимальная ставка");
            Assert.assertTrue(betInfoMaximumBetMeaning.getText().contains("0"), "Не корректное дефолтное значение в поле Максимальная ставка");
            Assert.assertTrue(betInfoPossibleWin.getText().contains("Возможный выигрыш:"), "Не корректный текст в поле Возможный выйгрыш");
            Assert.assertTrue(betInfoPossibleWinMeaning.getText().contains("0"), "Не корректное дефолтное значение в поле Возможный выйгрыш");
            Assert.assertTrue(betInfoChangingCoefficient.getText().contains("При изменении коэффициента:"), "Не корректный текст в поле При изменении коэффициента:");
            Assert.assertTrue(betInfoDropDownMenu.getText().contains("Подтверждать"), "Не корректное название кнопки в поле Подтверждать");
            Assert.assertTrue(betInfoPromoCode.getText().contains("Промо-код:"), "Не корректный текст в поле Промо-код");
            Assert.assertTrue(betInfoDeleteRatesButton.getText().contains("Очистить4353534534535345"), "Не корректное название кнопки Очистить" );
        });
    }

    public void stepCheckBetElementsInCouponAreNotVisible(){
        step("Проверяю наличие элементов в куппоне", () -> {
            betInfo.shouldNotBe(visible, Duration.ofSeconds(30));
            Assert.assertFalse(betInfo.isDisplayed(), "Отображается инфо о ставке");
            Assert.assertFalse(betInfoLeagueName.isDisplayed(), "Отображается название лиги");
            Assert.assertFalse(betInfoTeamsName.isDisplayed(), "Отображается название команд");
            Assert.assertFalse(betInfoCoefficient.isDisplayed(), "Отображается коэффицент");
            Assert.assertFalse(betInfoStakeAmount.isDisplayed(), "Отображается поле сумма ставки");
            Assert.assertFalse(betInfoCounter.isDisplayed(), "Отображается счетчки с кнопакми и каунтером");
            Assert.assertFalse(betInfoMaximumBet.isDisplayed(), "Отображается поле максимальная ставки");
            Assert.assertFalse(betInfoMaximumBetMeaning.isDisplayed(), "Отображается значение максимальное ставки");
            Assert.assertFalse(betInfoPossibleWin.isDisplayed(), "Отображается поле возможный выйгриш");
            Assert.assertFalse(betInfoPossibleWinMeaning.isDisplayed(), "Отображается значение поля возможный выйгрыш");
            Assert.assertFalse(betInfoChangingCoefficient.isDisplayed(), "Отображается поле при изменении коэффицента");
            Assert.assertFalse(betInfoDropDownMenu.isDisplayed(), "Отображается кнопка для открытия выпадающего списка Подтверждать");
            Assert.assertFalse(betInfoPromoCode.isDisplayed(), "Отображается поле Промокод");
            Assert.assertFalse(betInfoPromoCodeTextField.isDisplayed(), "Отображается текстовое поле Промокод");
        });
    }



}
