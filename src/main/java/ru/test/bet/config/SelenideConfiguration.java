package ru.test.bet.config;

import com.codeborne.selenide.Configuration;

public class SelenideConfiguration {

    public static final String SIZE = "3600x3600";
    public static final String BASE_URL = "https://22bet.co.ke/ru";
    public static final String BROWSER = "chrome";

    public static void config () {
        Configuration.browser = BROWSER;
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.browserSize = SIZE;
        Configuration.baseUrl = BASE_URL;
    }
}
