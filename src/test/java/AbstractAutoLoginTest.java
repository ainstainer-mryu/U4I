import org.junit.Before;
import utils.helpers.Navigation;
import utils.tools.Log;

/**
 * Base test class with auto-logging in as an admin before actual testing.
 */
public class AbstractAutoLoginTest extends AbstractTest {
    @Before
    public void loginAsAdminBeforeTest(){
        Log.info("Login to the system");
        Navigation.loginAsAdmin();
    }
}
