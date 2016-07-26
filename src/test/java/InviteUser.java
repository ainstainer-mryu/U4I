import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.CellPage;
import pages.HomePage;
import utils.Browser;
import utils.tools.Log;

/**
 * Created by maksym.ryumin on 7/25/2016.
 */
public class InviteUser extends AbstractAutoLoginTest {
    @Test
    public void testDeleteCell(){
        String cellName = "autoTestCell2";
        String cellDescription = "AUTO TEST DESCRIPTION";

        HomePage homePage = PageFactory.initElements(Browser.getDriver(), HomePage.class);

        Log.info(String.format("Creating cell %s", cellName));
        CellPage cellPage = homePage.addCell(cellName, cellDescription);

        Log.info(String.format("Deleting cell %s", cellName));
        cellPage.inviteUser("test ryumin");

        Log.info(String.format("Verifying cell %s is deleted", cellName));
    }
}
