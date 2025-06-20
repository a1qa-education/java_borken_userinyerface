package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HelpForm extends Form {
    private final IButton sendToBottomBtn = getElementFactory().getButton(By.xpath("//button[contains(@class,'send-to-bottom')]"), "Send to bottom");

    HelpForm() {
        super(By.className("help-form"), "Help form");
    }

    @Step("Click Send to bottom button")
    public void clickSendToBottomBtn() {
        sendToBottomBtn.clickAndWait();
    }
}
