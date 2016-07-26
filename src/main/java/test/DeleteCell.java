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
 * Performs test on cell deletion
 */
public class DeleteCell extends AbstractAutoLoginTest {

    @Test
    public void testDeleteCell(){
        String cellName = "autoTestCell2";
        String cellDescription = "AUTO TEST DESCRIPTION";

        HomePage homePage = PageFactory.initElements(Browser.getDriver(), HomePage.class);

        Log.info(String.format("Creating cell %s", cellName));
        CellPage cellPage = homePage.addCell(cellName, cellDescription);

        Log.info(String.format("Deleting cell %s", cellName));
        cellPage.deleteSelectedCell();

        Log.info(String.format("Verifying cell %s is deleted", cellName));
        Assert.assertFalse("Verifying "+ cellName + "is deleted " , homePage.isCellExisted(cellName));
    }
}
