import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.Browser;


/**
 * Created by maksym.ryumin on 7/14/2016.
 */
public class AbstractTest {
        @Before
        public void initClass(){
            Browser.getBrowser();
        }

        @After
        public void tearDownClass() {
           Browser.quit();
        }
}
