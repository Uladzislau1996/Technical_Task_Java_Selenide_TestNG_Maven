package ru.test.bet.pages;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPageSteps extends MainPageLocators {

    public static final int SECONDS = 10;

    public static MainPageSteps openPage() {
        open("/");
        return new MainPageSteps();
    }

    public void acceptCookie() {
        step("Клик на кнопку принять кукки", () -> {
            acceptCookie.click();
        });
    }

    public void scrollEvent() {
        step("Скрол к событию", () -> {
            blockLine.scrollIntoView(false);
        });
    }

    public void clickCoefficient() {
        step("Клик по первому коэффиценту", () -> {
            coefficient.click();
        });
    }

    public void checkElementsCouponAreVisible() {
        step("Проверить, отображение элементов в куппоне", () -> {
            //Ожидание появляение купона
            coupon.shouldBe(visible, Duration.ofSeconds(SECONDS));
            //Создаю коллекцию из элементов
            List<SelenideElement> elements = Arrays.asList(couponLeagueName, couponTeamsName,
                    couponCoefficient, couponStakeAmount, couponCounter, couponMaximumBet, couponMaximumBetCounter,
                    couponPossibleWin, couponPossibleWinCounter, couponChangingCoefficient, couponChangingCoefficient,
                    couponDropDown, couponPromoCode, couponPromoCodeTextField);
            //Проверка, что отображается каждый элемент
            checkElementsCollectionVisible(elements);
        });
    }

    public void checkDropDownMenu() {
        step("Проверить пункты меню в дропдауне", () -> {
            couponDropDown.click();
            couponDropDownAcceptWhenRise.shouldBe(visible, Duration.ofSeconds(SECONDS));
            //Создание коллекции из элементов в дропдауне
            List<SelenideElement> elements = Arrays.asList(couponDropDownConfirm, couponDropDownAcceptAnyChanges);
            //Проверка, что отображается каждый элемент в дропдауне
            checkElementsCollectionVisible(elements);
        });
    }

    public void checkEventIsVisible() {
        step("Проверить, что событие отображаеться", () -> {
            checkElementVisible(blockLine);
        });
    }

    public boolean isCouponLeagueCorrect() {
        return step("Проверить, что название лиги в купоне соответвует лиги в блоке линия", () -> {
            return isCorrectName(leagueName, couponLeagueName);
        });
    }

    public boolean isCouponNameCorrect() {
        return step("Проверить, что название команд в купоне как в блоке линия", () -> {
            String fullTeamsName = firstTeamsName.getText() + " - " + secondTeamsName.getText();
            return isCorrectText(fullTeamsName, couponTeamsName);
        });
    }

    public boolean isCouponCoefficientCorrect() {
        return step("Проверить, что коэффицент в купоне такой же как в блоке линия", () -> {
            return isCorrectName(couponCoefficient, coefficient);
        });
    }

    public boolean isCouponCoefficientTypeCorrect() {
        return step("Проверить тип коэффицента в купоне", () -> {
            return isCorrectText("1Х2 П1", couponCoefficientType);
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

    public void checkBetIsNotVisible() {
        step("Проверка, что купон не отображается", () -> {
            coupon.shouldNotBe(visible, Duration.ofSeconds(SECONDS));
        });
    }

    public void checkCoefficientVisible() {
        step("Проверка, что коэфицент отображается в событии", () -> {
            checkElementVisible(coefficient);
        });
    }

    private boolean isCorrectName(SelenideElement eventName, SelenideElement couponName){
        return couponName.getText().toLowerCase().contains(eventName.getText().toLowerCase());
    }

    private boolean isCorrectText(String expectedName, SelenideElement actualName){
        return expectedName.toLowerCase().contains(actualName.getText().toLowerCase());
    }

    private static void checkElementVisible(SelenideElement element){
        element.shouldBe(visible, Duration.ofSeconds(SECONDS));
    }

    private static void checkElementsCollectionVisible(List<SelenideElement> elements){
        for (SelenideElement element : elements) {
            element.shouldBe(visible);
        }
    }
}
