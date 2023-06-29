package ru.test.bet.BaseActions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import ru.test.bet.configreader.ConfigReader;

public class BaseActions {

    public static final int SECONDS = ConfigReader.selenideConfig.duration();

    public boolean isCorrectName(SelenideElement expectedName, SelenideElement actualName) {
        return actualName.getText().toLowerCase().contains(expectedName.getText().toLowerCase());
    }

    public boolean isCorrectText(String expectedName, SelenideElement actualName) {
        return expectedName.toLowerCase().contains(actualName.getText().toLowerCase());
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }


}
