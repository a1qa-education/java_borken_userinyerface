package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HelpForm;
import pages.MainPage;
import pages.WelcomePage;

public class HelpFormTest extends BaseTest {

    @Test
    public void checkHelpFormCanBeHidden() {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.clickHereToGoLink();

        HelpForm helpForm = new MainPage().getHelpForm();
        helpForm.clickSendToBottomBtn();
        Assert.assertTrue(helpForm.state().waitForNotDisplayed(), "Help form should be hidden");
    }
}
