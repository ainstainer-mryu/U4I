package pages;

import org.openqa.selenium.By;
import utils.data.PropertiesHolder;
import utils.helpers.UiHelper;

/**
 * Page Object page for "Cell" page
 */
public class CellPage extends HomePage {

    static final By BY_POST_FIELD = new By.ById("contentForm_message_contenteditable");
    private static final By BY_BTN_SUBMIT_POST = new By.ById("post_submit_button");
    private static final By BY_BTN_SETTINGS = new By.ByXPath("//*[contains(@class, 'dropdown-navigation')]");
    private static final By BY_SETTINGS_GENERAL = new By.ByXPath("//span[text()='General']");
    private static final By BY_TAB_BASIC = new By.ByXPath("//a[text()='Basic']");
    private static final By BY_TAB_SECURITY = new By.ByXPath("//a[text()='Security']");
    private static final By BY_TAB_DELETE = new By.ByXPath("//a[text()='Delete']");
    private static final By BY_DELETE_PASSWORD = new By.ById("deleteform-currentpassword");
    private static final By BY_BTN_DELETE = new By.ByXPath("//button[text()='Delete']");
    private static final By BY_WALL_STREAM = new By.ById("wallStream");
    private static final By BY_BTN_INVITE = new By.ByXPath("//*[contains(@href, 'membership/invite')]");
    private static final By BY_ADD_USER = new By.ById("invite_tag_input_field");
    private static final By BY_BTN_SEND = new By.ByXPath("//button[text()='Send']");
    private static final By BY_USER_BECOME_MEMBER = new By.ByXPath("//*[text()='User has become a member.']");
    private static final By BY_BTN_OK = new By.ByXPath("//button[text()='Ok']");

    public void addLinkToPost(String link){
        By addedPost = new By.ByXPath(String.format("//*[contains(@href, '%s')]", link));
        UiHelper.click(BY_POST_FIELD);
        UiHelper.sendKeys(BY_POST_FIELD, link);
        UiHelper.click(BY_BTN_SUBMIT_POST);
        UiHelper.waitFor(addedPost);
    }

    public boolean isLinkAdded(String link){
        By addedPost = new By.ByXPath(String.format("//*[contains(@href, '%s')]", link));
        return UiHelper.isPresent(addedPost);
    }

    public void deleteSelectedCell(){
        //TODO Add case if password is incorrect
        UiHelper.click(BY_BTN_SETTINGS);
        UiHelper.click(BY_SETTINGS_GENERAL);
        UiHelper.waitFor(BY_TAB_DELETE);
        UiHelper.click(BY_TAB_DELETE);
        UiHelper.waitFor(BY_DELETE_PASSWORD);
        UiHelper.sendKeys(BY_DELETE_PASSWORD, PropertiesHolder.getPassword());
        UiHelper.click(BY_BTN_DELETE);
        UiHelper.waitFor(BY_WALL_STREAM);
    }

    public void inviteUser(String username){
        //TODO add case if user does not exist or already a member
        By userToInvite = new By.ByXPath(String.format("//span[text()='%s']]", username));
        UiHelper.click(BY_BTN_INVITE);
        UiHelper.waitFor(BY_ADD_USER);
        UiHelper.sendKeys(BY_ADD_USER, username);
        UiHelper.click(userToInvite);
        UiHelper.click(BY_BTN_SEND);
        UiHelper.waitFor(BY_USER_BECOME_MEMBER);
        UiHelper.click(BY_BTN_OK);
        UiHelper.waitFor(BY_WALL_STREAM);
    }
}
