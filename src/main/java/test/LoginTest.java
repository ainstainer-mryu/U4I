package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.LoginPage;
import utils.Browser;
import utils.data.PropertiesHolder;
import utils.tools.Log;

/**
 * Performs test on login to the system
 */
public class LoginTest extends AbstractTest{

    @Test
    public void testLogin() {
        LoginPage loginPage = PageFactory.initElements(Browser.getDriver(), LoginPage.class);

        Log.info("Logging as Admin");
        BasePage basePage = loginPage.loginAs(PropertiesHolder.getAdminLoginName(), PropertiesHolder.getAdminPassword());

        Log.info("Verifying user is logged in");
        Assert.assertTrue("Verifying user is logged in", basePage.isUserLoggedIn(PropertiesHolder.getAdminUserName()));
    }
}
