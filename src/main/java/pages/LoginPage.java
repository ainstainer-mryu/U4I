package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;
import utils.helpers.UiHelper;

/**
 * PageObject class for "Login" page
 */
public class LoginPage extends BasePage{

    @FindBy(how = How.ID, using = "login_username")
    private WebElement tbLoginName;

    @FindBy(how = How.ID, using = "login_password")
    private WebElement tbPassword;

    @FindBy(how = How.ID, using = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage loginAs(String loginName, String password){
        UiHelper.sendKeys(tbLoginName, loginName);
        UiHelper.sendKeys(tbPassword, password);
        loginButton.click();

        return PageFactory.initElements(Browser.getDriver(), HomePage.class);
    }
}
