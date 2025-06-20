package tests;

import aquality.selenium.browser.AqualityServices;
import config.EnvConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static io.qameta.allure.Allure.step;

public abstract class BaseTest {

    @BeforeMethod
    public void setup() {
        step("Browser maximize");
        AqualityServices.getBrowser().maximize();
        step("Go to the host");
        AqualityServices.getBrowser().goTo(EnvConfigReader.getEnvData().getHost());
    }

    @AfterMethod
    public void teardown() {
        if (AqualityServices.isBrowserStarted()) {
            step("Browser quit");
            AqualityServices.getBrowser().quit();
        }
    }
}
