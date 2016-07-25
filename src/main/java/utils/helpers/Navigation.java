package utils.helpers;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import utils.Browser;
import utils.data.PropertiesHolder;

/**
 * Created by maksym.ryumin on 7/18/2016.
 */
public class Navigation {
    private static final Logger logger = LoggerFactory.getLogger(Navigation.class);

    /**
     * Performs logging in as an admin.
     * Note: it is supposed that current page is Login(Index) page.
     *
     * TODO: Add check for currentPage=LoginPage, Nav to Login if not.
     * @return HomePage object.
     */
    public static HomePage loginAsAdmin() {
        logger.debug("Logging in as admin.");
        LoginPage loginPage = PageFactory.initElements(Browser.getDriver(), LoginPage.class);

        return loginPage.loginAs(PropertiesHolder.getAdminLoginName(), PropertiesHolder.getAdminPassword());
    }

    /**
     * Performs logging out.
     *
     * @return LoginPage object.
     */
    public static void logout() {
        logger.debug("Logging out");
        BasePage basePage = PageFactory.initElements(Browser.getDriver(), BasePage.class);
        basePage.logout();
    }
}
