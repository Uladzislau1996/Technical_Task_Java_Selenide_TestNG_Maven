package ru.test.bet.configreader;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {
    public static final SelenideConfig selenideConfig = ConfigFactory.create(SelenideConfig.class, System.getProperties());
}
