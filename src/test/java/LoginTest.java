import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
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
        HomePage homePage = loginPage.loginAs(PropertiesHolder.getUserName(), PropertiesHolder.getPassword());

        Log.info("Verifying user is logged in");
        Assert.assertTrue("Verifying user is logged in", homePage.isLoggedUserImageShown());
    }

}
