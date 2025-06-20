package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import constants.Domains;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SignUpForm extends Form {
    private static final By PASSWORD_FIELD_LOC = By.xpath("//div[contains(@class,'login-form')]/input");
    private final ITextBox passwordField = getElementFactory().getTextBox(PASSWORD_FIELD_LOC, "Password field");
    private final ITextBox emailField = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'email')]"), "Email field");
    private final ITextBox domainField = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Domain')]"), "Domain field");
    private final IButton domainDropdown = getElementFactory().getButton(By.xpath("//div[contains(@class,'login-form')]//div[contains(@class,'opener')]"), "Domain dropdown");
    private final IButton nextBtn = getElementFactory().getButton(By.xpath("//div[contains(@class,'login-form')]//a[text()='Next']"), "Next");

    SignUpForm() {
        super(PASSWORD_FIELD_LOC, "Sign Up form");
    }

    @Step("Type password: {password}")
    public void typePassword(String password) {
        passwordField.clearAndType(password);
    }

    @Step("Type email: {email}")
    public void typeEmail(String email) {
        emailField.clearAndType(email);
    }

    @Step("Type domain: {domain}")
    public void typeDomain(String domain) {
        domainField.clearAndType(domain);
    }

    @Step("Select domain postfix: {domain}")
    public void selectDomain(Domains domain) {
        domainDropdown.click();
        // TODO: complete the method to select a desired domain
    }

    @Step("Click Next button")
    public void clickNextBtn() {
        nextBtn.click();
    }
}
