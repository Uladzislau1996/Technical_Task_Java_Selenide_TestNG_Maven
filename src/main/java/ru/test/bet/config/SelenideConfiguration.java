package ru.test.bet.config;

import com.codeborne.selenide.Configuration;
import ru.test.bet.configreader.ConfigReader;

public class SelenideConfiguration {

    private static final String BROWSER = ConfigReader.selenideConfig.browser();
    private static final Boolean MANAGERENABLED = ConfigReader.selenideConfig.driverManagerEnabled();
    private static final Boolean HEADLESS = ConfigReader.selenideConfig.headless();
    private static final String BROWSERSIZE = ConfigReader.selenideConfig.size();
    private static final String BASEURL = ConfigReader.selenideConfig.baseUrl();
    private static final int TIMEOUT = ConfigReader.selenideConfig.timeout();

    public static void config() {
        Configuration.browser = BROWSER;
        Configuration.driverManagerEnabled = MANAGERENABLED;
        Configuration.headless = HEADLESS;
        Configuration.browserSize = BROWSERSIZE;
        Configuration.baseUrl = BASEURL;
        Configuration.pageLoadTimeout = TIMEOUT;
    }

}
