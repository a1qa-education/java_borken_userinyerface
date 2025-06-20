package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CookieForm extends Form {
    private final IButton acceptCookiesBtn = getElementFactory().getButton(By.xpath("//div[@class='cookies']//button[contains(text(),'Yes')]"), "Accept Cookies");

    CookieForm() {
        super(By.className("cookies"), "Cookie form");
    }

    @Step("Click Accept Cookies button")
    public void clickAcceptCookiesBtn() {
        acceptCookiesBtn.clickAndWait();
    }
}
