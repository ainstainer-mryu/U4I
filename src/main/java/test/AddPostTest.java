package test;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.StreamPage;
import test.AbstractAutoLoginTest;
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
        StreamPage streamPage = new StreamPage();

        Log.info(String.format("Adding youtube link %s", linkToAdd));
        streamPage.addLinkToPost(linkToAdd);

        Log.info(String.format("Verifying link %s was added to the Stream", linkToAdd));
        Assert.assertTrue("Verifying link was posted", streamPage.isLinkAdded(linkToAdd));
    }
}
