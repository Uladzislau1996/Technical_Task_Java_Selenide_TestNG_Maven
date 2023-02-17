package ru.test.bet;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPageLocators {
   protected SelenideElement blockLine = $x("//*[@class='line-dashboard']/div/div[1]");
   protected SelenideElement blockLineTeamsName = blockLine.$x("div[2]/div/a");
   protected SelenideElement leagueName = blockLine.$x("div[1]/div[3]");
   protected SelenideElement firstTeamsName = blockLineTeamsName.$x("span/span[1]");
   protected SelenideElement secondTeamsName = blockLineTeamsName.$x("span/span[2]");
   protected SelenideElement acceptCookie = $(".js-cookie-accept");
   protected SelenideElement coefficient = blockLine.$x("div[2]/div/div[4]/div[1]");
   protected SelenideElement coupon = $(".bet-info");
   protected SelenideElement couponClearButton = $(".del-all");
   protected SelenideElement couponDeleteRateButton = $(".del-rate");
   protected SelenideElement couponLeagueName = $(".liga");
   protected SelenideElement couponTeamsName = $(".teams");
   protected SelenideElement couponCoefficient = $(".coef-change");
   protected SelenideElement couponCoefficientType = $(".rate>.type>.type-name");
   protected SelenideElement couponStakeAmount = $(".sum-st>.lc");
   protected SelenideElement couponCounter = $("#price_bets>ul>li>.rc");
   protected SelenideElement couponMaximumBet = $x("//*[@id='price_bets']//li[4]/div[1]");
   protected SelenideElement couponMaximumBetCounter = $("#summ_max");
   protected SelenideElement couponPossibleWin = $x("//*[@id='price_bets']//li[5]/div[1]");
   protected SelenideElement couponPossibleWinCounter = $x("//*[@id='price_bets']//li[5]/div[2]");
   protected SelenideElement couponChangingCoefficient = $x("//*[@id='price_bets']//li[6]/div[1]");
   protected SelenideElement couponDropDown = $x("//*[@id='price_bets']//div/span[(text())='Подтверждать']");
   protected SelenideElement couponDropDownAcceptWhenRise = $x("//span[normalize-space(text())=" +
           "'Принять при повышении']");
   protected SelenideElement couponDropDownConfirm = $x("//*[@class='multiselect__content']//*[(text())=" +
           "'Подтверждать']");
   protected SelenideElement couponDropDownAcceptAnyChanges = $x("//span[normalize-space(text())=" +
           "'Принять любое изменение']");
   protected SelenideElement couponPromoCode = $x("//div[@title='Промо-код']");
   protected SelenideElement couponPromoCodeTextField = $x("//div[@title='Промо-код']/following-sibling::div");

}
