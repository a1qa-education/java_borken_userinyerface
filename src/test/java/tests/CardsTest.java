package tests;

import constants.Domains;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.RandomUtils;

public class CardsTest extends BaseTest {
    private static final int MIN_PASSWORD_LENGTH = 10;
    private static final int NUMBER_OF_INTERESTS_TO_SELECT = 3;
    private static final String FILE_TO_UPLOAD_NAME = "avatar.png";

    @Test
    public void checkCards() {
        WelcomePage welcomePage = new WelcomePage();
        Assert.assertTrue(welcomePage.state().waitForDisplayed(), "Welcome page should be displayed");

        welcomePage.clickHereToGoLink();
        SignUpForm signUpForm = new MainPage().getSignUpForm();
        Assert.assertTrue(signUpForm.state().waitForDisplayed(), "Sign Up card should be displayed");

        String email = RandomUtils.getRandomAlphabeticString();
        String password = RandomUtils.generatePassword(MIN_PASSWORD_LENGTH);
        String domain = RandomUtils.getRandomAlphabeticString();
        Domains domainPostfix = RandomUtils.getRandomDomain();
        signUpForm.typePassword(password);
        signUpForm.typeEmail(email);
        signUpForm.typeDomain(domain);
        signUpForm.selectDomain(domainPostfix);
        signUpForm.clickNextBtn();
        InterestsForm interestsForm = new MainPage().getInterestsForm();
        Assert.assertTrue(interestsForm.state().waitForDisplayed(), "Interests card should be displayed");

        interestsForm.clickRandomInterests(NUMBER_OF_INTERESTS_TO_SELECT);
        interestsForm.uploadAvatar(FILE_TO_UPLOAD_NAME);
        interestsForm.clickNextBtn();
        PersonalDetailsForm personalDetailsForm = new MainPage().getPersonalDetailsForm();
        Assert.assertTrue(personalDetailsForm.state().waitForDisplayed(), "Personal Details card should be displayed");
    }
}
