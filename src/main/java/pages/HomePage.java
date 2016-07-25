package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;
import utils.helpers.UiHelper;

/**
 * PageObject class for "Home" page
 */
public class HomePage extends BasePage {

    private static final By BY_ADD_PRIVATE_CELL = new By.ByXPath("//*[contains(@href, 'create?spaceType=private')]");

    private static final By BY_CELL_NAME = new By.ById("space-name");

    private static final By BY_CELL_DESCRIPTION = new By.ById("space-description");

    private static final By BY_BT_NEXT = new By.ById("space-create-submit-button");

    private static final By BY_BT_ENABLE_QA = new By.ById("btn-enable-module-questionAnswer");

    private static final By BY_BT_DONE = new By.ByXPath("//button[contains(@id,'w1')]");

    private static final By BY_INVITES = new By.ById("invite_tag_input_field");



    /**
     *
     * Clicks "Add new cell" action link.
     *
     * @return - CellPage PageObject.
     */
    public CellPage addCell(String cellName, String description) {
        UiHelper.click(BY_ADD_PRIVATE_CELL);
        UiHelper.waitFor(BY_CELL_NAME);
        UiHelper.sendKeys(BY_CELL_NAME, cellName);
        UiHelper.sendKeys(BY_CELL_DESCRIPTION, description);
        UiHelper.click(BY_BT_NEXT);
        UiHelper.waitFor(BY_BT_ENABLE_QA);
        UiHelper.click(BY_BT_DONE);
        UiHelper.waitFor(BY_INVITES);
        UiHelper.click(BY_BT_DONE);

        UiHelper.waitFor(CellPage.BY_POST_FIELD);
        return PageFactory.initElements(Browser.getDriver(), CellPage.class);
    }

    public boolean isCellExisted(String cellName){
        By byExistedCellName = new By.ByXPath(String.format("//div[text()='%s']", cellName));
        return UiHelper.isPresent(byExistedCellName);
    }
    public void selectCell(String cellName) {
        By byExistedCellName = new By.ByXPath(String.format("//div[text()='%s']", cellName));
        UiHelper.click(byExistedCellName);
        UiHelper.waitFor(CellPage.BY_POST_FIELD);
    }
}
