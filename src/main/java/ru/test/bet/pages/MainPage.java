package ru.test.bet.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.test.bet.BaseActions.BaseActions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BaseActions {
    private SelenideElement dashboard = $x("//*[@class='line-dashboard']/div/div[1]");
    private SelenideElement dashboardTeamsName = dashboard.$x("div[2]/div/a");
    private SelenideElement leagueName = dashboard.$x("div[1]/div[3]");
    private SelenideElement firstTeamsName = dashboardTeamsName.$x("span/span[1]");
    private SelenideElement secondTeamsName = dashboardTeamsName.$x("span/span[2]");
    private SelenideElement acceptCookie = $x("//div[@class='f-policy']/div");
    private SelenideElement coefficient = dashboard.$x("div[2]/div/div[4]/div[1]");
    private SelenideElement coupon = $x("//*[@class='bet-info']");
    private SelenideElement couponClearButton = $x("//*[@class='del-all']");
    private SelenideElement couponDeleteRateButton = $x("//*[@class='del-rate']");
    private SelenideElement couponLeagueName = $x("//*[@class='liga']");
    private SelenideElement couponTeamsName = $x("//*[@class='teams']");
    private SelenideElement couponCoefficient = $x("//*[@class='type']/span[2]/span");
    private SelenideElement couponCoefficientType = $x("//*[@class='type']/span[1]");
    private SelenideElement couponStakeAmount = $x("//*[@id='price_bets']/ul/li[1]/div[1]");
    private SelenideElement couponCounter = $x("//*[@id='price_bets']/ul/li[1]/div[2]");
    private SelenideElement couponMaximumBet = $x("//*[@id='price_bets']//li[4]/div[1]");
    private SelenideElement couponMaximumBetCounter = $x("//*[@id='summ_max']");
    private SelenideElement couponPossibleWin = $x("//*[@id='price_bets']//li[5]/div[1]");
    private SelenideElement couponPossibleWinCounter = $x("//*[@id='price_bets']//li[5]/div[2]");
    private SelenideElement couponChangingCoefficient = $x("//*[@id='price_bets']//li[6]/div[1]");
    private SelenideElement couponDropDown = $x("//*[@id='price_bets']//div/span[(text())=" +
            "'Подтверждать']");
    private SelenideElement couponDropDownAcceptWhenRise = $x("//span[normalize-space(text())=" +
            "'Принять при повышении']");
    private SelenideElement couponDropDownConfirm = $x("//*[@class='multiselect__content']//" +
            "*[(text())='Подтверждать']");
    private SelenideElement couponDropDownAcceptAnyChanges = $x("//span[normalize-space(text())=" +
            "'Принять любое изменение']");
    private SelenideElement couponPromoCode = $x("//div[@title='Промо-код']");
    private SelenideElement couponPromoCodeTextField = $x("//div[@title='Промо-код']" +
            "/following-sibling::div");

    @Step("Открыть главную страницу")
    public static MainPage openPage() {
        open("/");
        return new MainPage();
    }

    @Step("Принять куки")
    public void acceptCookie() {
        acceptCookie.click();
    }

    @Step("Скролл к событию")
    public void scrollEvent() {
        dashboard.scrollIntoView(false);
    }

    @Step("Клик по коэфиценту")
    public void clickCoefficient() {
        coefficient.shouldBe(visible, Duration.ofSeconds(SECONDS)).click();
    }

    @Step("Проверка отображения событий")
    public void checkEventIsVisible() {
        dashboard.shouldBe(visible, Duration.ofSeconds(SECONDS));
    }

    @Step("Проверка, что коэфицент отображается в событии")
    public void checkCoefficientVisible() {
        coefficient.shouldBe(visible, Duration.ofSeconds(SECONDS));
    }

    @Step("Возвращаю коллекцию элементов в купоне")
    public List<SelenideElement> checkElementsCouponAreVisible() {
        //Ожидание появляение купона
        coupon.shouldBe(visible, Duration.ofSeconds(SECONDS));
        //Создаю коллекцию из элементов
        return Arrays.asList(couponLeagueName, couponTeamsName,
                couponCoefficient, couponStakeAmount, couponCounter, couponMaximumBet, couponMaximumBetCounter,
                couponPossibleWin, couponPossibleWinCounter, couponChangingCoefficient, couponChangingCoefficient,
                couponDropDown, couponPromoCode, couponPromoCodeTextField);
    }

    @Step("Возвращаю коллекцию элементов вдропдауне")
    public List<SelenideElement> checkDropDownMenu() {
        couponDropDown.click();
        couponDropDownAcceptWhenRise.shouldBe(visible, Duration.ofSeconds(SECONDS));
        //Создание коллекции из элементов в дропдауне
        List<SelenideElement> elements = Arrays.asList(couponDropDownConfirm, couponDropDownAcceptAnyChanges);
        //Проверка, что отображается каждый элемент в дропдауне
        return elements;
    }

    @Step("Проверить, что название лиги в купоне соответвует лиги в блоке линия")
    public boolean isCouponLeagueCorrect() {
        return isCorrectName(leagueName, couponLeagueName);
    }

    @Step("Проверить, что название команд в купоне как в блоке линия")
    public boolean isCouponNameCorrect() {
        String fullTeamsName = firstTeamsName.getText() + " - " + secondTeamsName.getText();
        return isCorrectText(fullTeamsName, couponTeamsName);
    }

    @Step("Проверить, что коэффицент в купоне такой же как в блоке линия")
    public boolean isCouponCoefficientCorrect() {
        return isCorrectName(couponCoefficient, coefficient);
    }

    @Step("Проверить тип коэффицента в купоне")
    public boolean isCouponCoefficientTypeCorrect() {
        return isCorrectText("1Х2 П1", couponCoefficientType);
    }

    @Step("Клик по кнопке очистить")
    public void clickClear() {
        couponClearButton.click();
    }

    @Step("Клик по кнопке удалить ставку")
    public void clickDeleteRate() {
        couponDeleteRateButton.click();
    }

    @Step("Проверка, что купон не отображается")
    public void IsCouponNotVisible() {
        coupon.shouldNotBe(visible, Duration.ofSeconds(SECONDS));
    }

    @Step("Получить текст кнопки очистить")
    public String getClearButtonText() {
        return couponClearButton.getText();
    }

    @Step("Получить текст поля сумма ставки")
    public String getStakeAmountText() {
        return couponStakeAmount.getText();
    }

    @Step("Получить текст поля максимальная ставка")
    public String getMaximumBetText() {
        return couponMaximumBet.getText();
    }

    @Step("Получить текст поля возможный выйгрыш")
    public String getPossibleWinText() {
        return couponPossibleWin.getText();
    }

}


