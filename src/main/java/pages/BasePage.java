package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.helpers.UiHelper;


/**
 * Created by maksym.ryumin on 7/14/2016.
 */

public class BasePage {

    protected WebDriver driver;

    /**
     * Default constructor. Need it to use <a href="http://selenium.googlecode.com/svn/trunk/docs/api/java/index.html">PageFactory</a>
     * @param driver - current WebDriver(browser) object.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage(){
    }

    @FindBy(how = How.ID, using = "user-account-image")
    private WebElement tbExpandMainMenu;

    @FindBy(how = How.XPATH, using = "//*[contains(@href, 'logout')]")
    private WebElement tblogout;

    /**
     * Clicks logout link. The link is always available, so this method is here, in BasePage.
     *
     * @return - LoginPage PageObject.
     */
    public void logout() {
        tbExpandMainMenu.click();
        tblogout.click();
    }

    public boolean isLoggedUserImageShown(){
        return UiHelper.isPresent(By.id("user-account-image"));
    }
}
