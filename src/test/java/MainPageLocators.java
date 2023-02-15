import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPageLocators {
   SelenideElement blockLine = $x("//*[@class='line-dashboard']/div/div[1]");
   SelenideElement blockLineTeamsName = blockLine.$x("div[2]/div/a");
   SelenideElement leagueName = blockLine.$x("div[1]/div[3]");
   SelenideElement firstTeamsName = blockLineTeamsName.$x("span/span[1]");
   SelenideElement secondTeamsName = blockLineTeamsName.$x("span/span[2]");
   SelenideElement acceptCookie = $(".js-cookie-accept");
   SelenideElement coefficient = blockLine.$x("div[2]/div/div[4]/div[1]");
   SelenideElement coupon = $(".bet-info");
   SelenideElement couponClearButton = $(".del-all");
   SelenideElement couponDeleteRateButton = $(".del-rate");
   SelenideElement couponLeagueName = $(".liga");
   SelenideElement couponTeamsName = $(".teams");
   SelenideElement couponCoefficient = $(".coef-change");
   SelenideElement couponCoefficientType = $(".rate>.type>.type-name");
   SelenideElement couponStakeAmount = $(".sum-st>.lc");
   SelenideElement couponCounter = $("#price_bets>ul>li>.rc");
   SelenideElement couponMaximumBet = $x("//*[@id='price_bets']//li[4]/div[1]");
   SelenideElement couponMaximumBetCounter = $("#summ_max");
   SelenideElement couponPossibleWin = $x("//*[@id='price_bets']//li[5]/div[1]");
   SelenideElement couponPossibleWinCounter = $x("//*[@id='price_bets']//li[5]/div[2]");
   SelenideElement couponChangingCoefficient = $x("//*[@id='price_bets']//li[6]/div[1]");
   SelenideElement couponDropDown = $x("//*[@id='price_bets']//div/span[(text())='Подтверждать']");
   SelenideElement couponDropDownAcceptWhenRise = $x("//span[normalize-space(text())=" +
           "'Принять при повышении']");
   SelenideElement couponDropDownConfirm = $x("//*[@class='multiselect__content']//*[(text())=" +
           "'Подтверждать']");
   SelenideElement couponDropDownAcceptAnyChanges = $x("//span[normalize-space(text())=" +
           "'Принять любое изменение']");
   SelenideElement couponPromoCode = $x("//div[@title='Промо-код']");
   SelenideElement couponPromoCodeTextField = $x("//div[@title='Промо-код']/following-sibling::div");

}
