import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.CollectionElement;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;

public class MainPageSteps extends MainPageLocators {

    public void stepAcceptCookie() {
        step("Кликаю на кнопку принятию кукки", () -> {
            acceptCookie.click();
        });
    }

    public void stepScrollToEvent() {
        step("Скрол к событию", () -> {
            blockLine.shouldBe(visible, Duration.ofSeconds(120));
            blockLine.scrollIntoView(false);
            coefficient.shouldBe(visible, Duration.ofSeconds(120));
        });
    }

    public void stepClickCoefficient() {
        step("Кликаю на первый коэффицент", () -> {
            coefficient.click();
        });
    }

    public void stepCheckBetElementsInCouponAreVisible() {
        step("Проверяю наличие элементов в куппоне", () -> {
            coupon.shouldBe(visible, Duration.ofSeconds(30));
            Assert.assertTrue(coupon.isDisplayed(), "Не отображается инфо о ставке");
            Assert.assertTrue(couponLeagueName.isDisplayed(), "Не отображается название лиги");
            Assert.assertTrue(couponTeamsName.isDisplayed(), "Не отображается название команд");
            Assert.assertTrue(couponCoefficient.isDisplayed(), "Не отображается коэффицент");
            Assert.assertTrue(couponStakeAmount.isDisplayed(), "Не отображается поле сумма ставки");
            Assert.assertTrue(couponCounter.isDisplayed(), "Не отображается счетчки с кнопакми и каунтером");
            Assert.assertTrue(couponMaximumBet.isDisplayed(), "Не отображается поле максимальная ставки");
            Assert.assertTrue(couponMaximumBetCounter.isDisplayed(),
                    "Не отображается значение максимальное ставки");
            Assert.assertTrue(couponPossibleWin.isDisplayed(), "Не отображается поле возможный выйгриш");
            Assert.assertTrue(couponPossibleWinCounter.isDisplayed(),
                    "Не отображается значение поля возможный выйгрыш");
            Assert.assertTrue(couponChangingCoefficient.isDisplayed(),
                    "Не отображается поле при изменении коэффицента");
            Assert.assertTrue(couponDropDown.isDisplayed(),
                    "Не отображается кнопка для открытия выпадающего списка Подтверждать");
            Assert.assertTrue(couponPromoCode.isDisplayed(), "Не отображается поле Промокод");
            Assert.assertTrue(couponPromoCodeTextField.isDisplayed(), "Не отображается текстовое поле Промокод");
        });
    }

    public void stepCheckDropDownMenu() {
        step("Проверить пункты меню в дроп даун меню", () -> {
            couponDropDown.click();
            couponDropDownAcceptWhenRise.shouldBe(visible, Duration.ofSeconds(30));
            Assert.assertTrue(couponDropDownAcceptWhenRise.isDisplayed(), "Не отображается кнопка" +
                    " выпадающего списка Принять при повышении");
            Assert.assertTrue(couponDropDownConfirm.isDisplayed(), "Не отображается кнопка выпадающего " +
                    "списка Подтверждать");
            Assert.assertTrue(couponDropDownAcceptAnyChanges.isDisplayed(), "Не отображается кнопка " +
                    "выпадающего списка Принять любые изменения");
        });
    }

    public boolean stepCheckLeagueNameInCoupon() {
        return step("Проверить название лиги в купоне", () -> {
            couponLeagueName.shouldHave(text(leagueName.getText()));
            return couponLeagueName.getText().toLowerCase().contains(leagueName.getText().toLowerCase());
        });
    }

    public boolean stepCheckTeamsNameInCoupon() {
        return step("Проверить название команд в купоне", () -> {
            String fullTeamsName = firstTeamsName.getText() + " - " + secondTeamsName.getText();
            couponTeamsName.shouldHave(text(fullTeamsName));
            return couponTeamsName.getText().contains(fullTeamsName);
        });
    }

    public boolean stepCheckCoefficientInCoupon() {
        return step("Проверить коэффицент в купоне", () -> {
            return couponCoefficient.getText().contains(coefficient.getText());
        });
    }

    public boolean stepCheckCoefficientTypeInCoupon() {
        return step("Проверить тип коэффицента в купоне", () -> {
            return couponCoefficientType.getText().contains("1Х2 П1");
        });
    }

    public void stepClearButtonClick() {
         step("Клик по кнопке очистить", () -> {
             couponClearButton.click();
        });
    }

    public void stepDeleteRateButtonClick() {
        step("Клик по кнопке удалить ставку", () -> {
            couponDeleteRateButton.click();
        });
    }

    public void stepCheckTextInButtonsAndFields() {
        step("Проверить текст в полях и кнопках", () -> {
            Assert.assertTrue(couponStakeAmount.getText().contains("СУММА СТАВКИ (KES):"),
                    "Не корректный текст в поле Сумма ставки");
            Assert.assertTrue(couponMaximumBet.getText().contains("Максимальная ставка:"),
                    "Не корректный текст в поле Максимальная ставка");
            Assert.assertTrue(couponMaximumBetCounter.getText().contains("0"),
                    "Не корректное дефолтное значение в поле Максимальная ставка");
            Assert.assertTrue(couponPossibleWin.getText().contains("Возможный выигрыш:"),
                    "Не корректный текст в поле Возможный выйгрыш");
            Assert.assertTrue(couponPossibleWinCounter.getText().contains("0"),
                    "Не корректное дефолтное значение в поле Возможный выйгрыш");
            Assert.assertTrue(couponChangingCoefficient.getText().contains("При изменении коэффициента:"),
                    "Некорректный текст в поле При изменении коэффициента:");
            Assert.assertTrue(couponDropDown.getText().contains("Подтверждать"),
                    "Не корректное название кнопки в поле Подтверждать");
            Assert.assertTrue(couponPromoCode.getText().contains("Промо-код:"),
                    "Не корректный текст в поле Промо-код");
            Assert.assertTrue(couponClearButton.getText().contains("Очистить4353534534535345"),
                    "Не корректное название кнопки Очистить");
        });
    }

    public void stepCheckBetElementsInCouponAreNotVisible() {
        step("Проверяю наличие элементов в куппоне", () -> {
            coupon.shouldNotBe(visible, Duration.ofSeconds(120));
            Assert.assertFalse(coupon.isDisplayed(), "Отображается инфо о ставке");
            Assert.assertFalse(couponLeagueName.isDisplayed(), "Отображается название лиги");
            Assert.assertFalse(couponTeamsName.isDisplayed(), "Отображается название команд");
            Assert.assertFalse(couponCoefficient.isDisplayed(), "Отображается коэффицент");
            Assert.assertFalse(couponStakeAmount.isDisplayed(), "Отображается поле сумма ставки");
            Assert.assertFalse(couponCounter.isDisplayed(), "Отображается счетчки с кнопакми и каунтером");
            Assert.assertFalse(couponMaximumBet.isDisplayed(), "Отображается поле максимальная ставки");
            Assert.assertFalse(couponMaximumBetCounter.isDisplayed(),
                    "Отображается значение максимальное ставки");
            Assert.assertFalse(couponPossibleWin.isDisplayed(), "Отображается поле возможный выйгриш");
            Assert.assertFalse(couponPossibleWinCounter.isDisplayed(),
                    "Отображается значение поля возможный выйгрыш");
            Assert.assertFalse(couponChangingCoefficient.isDisplayed(),
                    "Отображается поле при изменении коэффицента");
            Assert.assertFalse(couponDropDown.isDisplayed(),
                    "Отображается кнопка для открытия выпадающего списка Подтверждать");
            Assert.assertFalse(couponPromoCode.isDisplayed(), "Отображается поле Промокод");
            Assert.assertFalse(couponPromoCodeTextField.isDisplayed(), "Отображается текстовое поле Промокод");
        });
    }
}
