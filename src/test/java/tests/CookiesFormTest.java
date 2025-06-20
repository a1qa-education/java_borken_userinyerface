package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CookiesFormTest extends BaseTest {

    @Test
    public void checkCookiesFormCanBeHidden() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.clickHereToGoLink();

        CookieForm cookieForm = new MainPage().getCookieForm();
        cookieForm.clickAcceptCookiesBtn();
        Assert.assertTrue(cookieForm.state().waitForNotDisplayed(), "Cookies form should be hidden");
    }
}
