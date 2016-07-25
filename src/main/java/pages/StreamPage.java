package pages;

import org.openqa.selenium.By;
import utils.helpers.UiHelper;

/**
 * Created by maksym.ryumin on 7/22/2016.
 */
public class StreamPage extends CellPage {
    static final By BY_POST_FIELD = new By.ById("contentForm_message_contenteditable");
    static final By BY_WALL_STREAM = new By.ById("wallStream");
    private static final By BY_BTN_SUBMIT_POST = new By.ById("post_submit_button");

    public void addLinkToPost(String link){
        By addedPost = new By.ByXPath(String.format("//*[contains(@href, '%s')]", link));
        UiHelper.click(BY_POST_FIELD);
        UiHelper.sendKeys(BY_POST_FIELD, link);
        UiHelper.click(BY_BTN_SUBMIT_POST);
        UiHelper.waitFor(addedPost);
    }
}
