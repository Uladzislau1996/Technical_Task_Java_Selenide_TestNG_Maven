package ru.test.bet.configreader;

@org.aeonbits.owner.Config.LoadPolicy(org.aeonbits.owner.Config.LoadType.MERGE)
@org.aeonbits.owner.Config.Sources({
        "system:properties",
        "file:/Users/test/Documents/GitHub/Appium_iOS_TestNG/Technical_Task_Java_Selenide_TestNG_Maven/src/main/java/ru/test/bet/resources/config.properties",
})

public interface SelenideConfig extends org.aeonbits.owner.Config {
    @Key("browser")
    String browser();

    @Key("base_url")
    String baseUrl();

    @Key("size")
    String size();

    @Key("driverManagerEnabled")
    Boolean driverManagerEnabled();

    @Key("headless")
    Boolean headless();

    @Key("screenshots")
    Boolean screenshots();

    @Key("timeout")
    int timeout();

    @Key("duration")
    int duration();

}
