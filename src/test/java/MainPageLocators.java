import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.SelenideElementDescriber;

import static com.codeborne.selenide.Selenide.*;

public class MainPageLocators {

   String averageTagName = ".line-dashboard>div>.c-events:nth-child(1)>";
   String averageFullTagName = ".line-dashboard>div>.c-events:nth-child(1)>.c-events__item_col:nth-child(2)>";

   public SelenideElement game = $(averageFullTagName);
   public SelenideElement leagueName = $(averageTagName+"div>.c-events__name");
   public SelenideElement firstTeamsName = $(averageFullTagName+"div>a>span>span:first-child");
   public SelenideElement secondTeamsName = $(averageFullTagName+"div>a>span>span:last-child");
   public ElementsCollection bets = $$(averageFullTagName+"div>.c-bets");
   public SelenideElement acceptCookie = $(".js-cookie-accept");
   public SelenideElement betCoefficients1 = $(averageFullTagName+"div>.c-bets>div:nth-child(1)>span");
   public SelenideElement betInfo = $(".bet-info");
   public SelenideElement betInfoDeleteRatesButton = $(".del-all");
   public SelenideElement betInfoDeleteRateButton = $(".del-rate");
   public SelenideElement betInfoLeagueName = $(".liga");
   public SelenideElement betInfoTeamsName = $(".teams");
   public SelenideElement betInfoCoefficient = $(".coef-change");

   public SelenideElement betInfoCoefficientType = $(".rate>.type>.type-name");

   public SelenideElement betInfoStakeAmount = $("#price_bets>ul>li:nth-child(1)>div:nth-child(1)");
   public SelenideElement betInfoCounter = $("#price_bets>ul>li>.rc");
   public SelenideElement betInfoMaximumBet = $("#price_bets>ul>li:nth-child(4)>div:nth-child(1)");
   public SelenideElement betInfoMaximumBetMeaning = $("#summ_max");
   public SelenideElement betInfoPossibleWin = $("#price_bets>ul>li:nth-child(5)>div");
   public SelenideElement betInfoPossibleWinMeaning = $("#price_bets>ul>li:nth-child(5)>div:nth-child(2)");
   public SelenideElement betInfoChangingCoefficient = $("#price_bets>ul>li:nth-child(6)>div:nth-child(1)");
   public SelenideElement betInfoDropDownMenu = $("#price_bets>ul>li:nth-child(6)>div:nth-child(2)");
   public SelenideElement betInfoDropDownMenuAcceptWhenRise = $("#price_bets>ul>li:nth-child(6)>div:nth-child(2)>div>div:nth-child(3)>ul>li");
   public SelenideElement betInfoDropDownMenuConfirm = $("#price_bets>ul>li:nth-child(6)>div:nth-child(2)>div>div:nth-child(3)>ul>li:nth-child(2)");
   public SelenideElement betInfoDropDownAcceptAnyChanges = $("#price_bets>ul>li:nth-child(6)>div:nth-child(2)>div>div:nth-child(3)>ul>li:nth-child(3)");
   public SelenideElement betInfoPromoCode = $("#price_bets>ul>li:nth-child(7)>div:first-child");
   public SelenideElement betInfoPromoCodeTextField = $("#price_bets>ul>li:nth-child(7)>div:nth-child(2)");
























}
