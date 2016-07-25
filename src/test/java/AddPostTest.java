import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.CellPage;
import pages.HomePage;
import utils.Browser;
import utils.tools.Log;

/**
 * Performs test on add youtube link to the system
 */
public class AddPostTest extends AbstractAutoLoginTest {

    @Test
    public void testAddPost() throws InterruptedException {
        String cellName = "autoTestCell1";
        String linkToAdd = "https://www.youtube.com/watch?v=Z_S2uRjLZ14";

        HomePage homePage = PageFactory.initElements(Browser.getDriver(), HomePage.class);

        Log.info(String.format("Selecting cell with name %s", cellName));
        homePage.selectCell(cellName);
        CellPage cellPage = new CellPage();

        Log.info(String.format("Adding youtube link %s", linkToAdd));
        cellPage.addLinkToPost(linkToAdd);

        Log.info(String.format("Verifying link %s was added to the Stream", linkToAdd));
        Assert.assertTrue("Verifying link was posted", cellPage.isLinkAdded(linkToAdd));
    }
}
