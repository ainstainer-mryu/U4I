package test;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.CellPage;
import pages.HomePage;
import test.AbstractAutoLoginTest;
import utils.Browser;
import utils.tools.Log;

/**
 * Performs creation cell test
 */
public class CreateCellTest extends AbstractAutoLoginTest {

    @Test
    public void testCreateCell() {

        String cellName = "autoTestCell1";
        String cellDescription = "AUTO TEST DESCRIPTION";
        HomePage homePage = PageFactory.initElements(Browser.getDriver(), HomePage.class);

        Log.info(String.format("Creating cell %s", cellName));
        CellPage cellPage = homePage.addCell(cellName, cellDescription);

        Log.info(String.format("Verifying cell %s is added", cellName));
        Assert.assertTrue("Verifying cell was created", cellPage.isCellExisted(cellName));
    }
}
