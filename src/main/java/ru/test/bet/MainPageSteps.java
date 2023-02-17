package ru.test.bet;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPageSteps extends MainPageLocators {

    public static final int SECONDS = 10;

    public static MainPageSteps openPage(){
        open("/");
        return new MainPageSteps();
    }

    public void acceptCookie() {
        step("Кликаю на кнопку принятию кукки", () -> {
            acceptCookie.click();
        });
    }

    public void scrollEvent() {
        step("Скрол к событию", () -> {
            blockLine.scrollIntoView(false);
        });
    }

    public void clickCoefficient() {
        step("Кликаю на первый коэффицент", () -> {
            coefficient.click();
        });
    }

    public void elementsCouponAreVisible() {
        step("Проверяю наличие элементов в куппоне", () -> {
            //Ожидаю появляение купона
            coupon.shouldBe(visible, Duration.ofSeconds(SECONDS));
            //Создаю коллекцию из элемментов
            List<SelenideElement> elements = new ArrayList<>(Arrays.asList(coupon, couponLeagueName, couponTeamsName,
                    couponCoefficient, couponStakeAmount, couponCounter, couponMaximumBet, couponMaximumBetCounter,
                    couponPossibleWin, couponPossibleWinCounter, couponChangingCoefficient, couponChangingCoefficient,
                    couponDropDown, couponPromoCode, couponPromoCodeTextField));
            //Проверяю что отображается каждый элемент
            for (SelenideElement element : elements){
               element.shouldBe(visible);
            };
        });
    }

    public void dropDownMenu() {
        step("Проверить пункты меню в дропдауне", () -> {
            couponDropDown.click();
            couponDropDownAcceptWhenRise.shouldBe(visible, Duration.ofSeconds(SECONDS));
            //Создаю коллекцию из элементов в дропдауне
            List<SelenideElement> elements = new ArrayList<>(Arrays.asList(couponDropDownAcceptWhenRise,
                    couponDropDownConfirm, couponDropDownAcceptAnyChanges ));
            //Проверяю что отображается каждый элемент в дропдауне
            for (SelenideElement element : elements){
                element.shouldBe(visible);;
            }
        });
    }

    public boolean isCouponLeagueCorrect() {
        return step("Проверить название лиги в купоне", () -> {
            return couponLeagueName.getText().toLowerCase().contains(leagueName.getText().toLowerCase());
        });
    }

    public void isEventVisible() {
         step("Проверить отображение события", () -> {
             blockLine.shouldBe(visible, Duration.ofSeconds(SECONDS));
        });
    }

    public boolean isCouponNameCorrect() {
        return step("Проверить название команд в купоне", () -> {
            String fullTeamsName = firstTeamsName.getText() + " - " + secondTeamsName.getText();
            return couponTeamsName.getText().contains(fullTeamsName);
        });
    }

    public boolean isCouponCoefficientCorrect() {
        return step("Проверить коэффицент в купоне", () -> {
            return couponCoefficient.getText().contains(coefficient.getText());
        });
    }

    public boolean isCouponCoefficientTypeCorrect() {
        return step("Проверить тип коэффицента в купоне", () -> {
            return couponCoefficientType.getText().contains("1Х2 П1");
        });
    }

    public void clickClear() {
         step("Клик по кнопке очистить", () -> {
             couponClearButton.click();
        });
    }

    public void clickDeleteRate() {
        step("Клик по кнопке удалить ставку", () -> {
            couponDeleteRateButton.click();
        });
    }

    public void betIsNotVisible() {
        step("Проверяю что купон не отображается", () -> {
            coupon.shouldNotBe(visible, Duration.ofSeconds(SECONDS));
        });
    }

    public void isCoefficientVisible() {
        step("Проверяю наличие коэфицента в событии", () -> {
            coefficient.shouldBe(visible, Duration.ofSeconds(SECONDS));
        });
    }


}
