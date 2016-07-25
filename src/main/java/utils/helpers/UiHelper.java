package utils.helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Browser;

/**
 * Created by maksym.ryumin on 7/14/2016.
 */
public class UiHelper {
    private static final Logger logger = LoggerFactory.getLogger(UiHelper.class);

    //TODO: Make configurable.
    protected static final int WAITFOR_TIMEOUT = 32; // seconds

    private static final int DEFAULT_SLEEP_TIMEOUT = 1000; // milliseconds

    /**
     * Pauses test execution for specified amount of time.
     *
     * @param milliseconds time to sleep, in milliseconds
     */
    public static void sleep(int milliseconds) {
        try {
            logger.debug("sleep() for" + milliseconds);
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            //ToDo log exception
        }
    }

    /**
     * Waits for an element .
     * //TODO: Provide waitFor(By by, long timeout)
     *
     * @param by element's locator.
     *
     * @return indicates if an element is found
     */
    public static boolean waitFor(By by) {
        logger.debug("waitFor() " + by);

        WebElement element = (new WebDriverWait(Browser.getDriver(), WAITFOR_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(by));
        if (null == element){
            //ToDo log exception
            return false;
        }
        return true;
    }

    /**
     * Yet another "waitFor". Just an example of an own ExpectedCondition.
     *
     * @param xpath	XPATH that distinguish an element
     *
     * @return indicates if an element has been found.
     */
    public static boolean waitFor(final String xpath) {
        logger.debug("waitFor() " + xpath);

        return (new WebDriverWait(Browser.getDriver(), WAITFOR_TIMEOUT)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                WebElement element = Browser.getDriver().findElement(By.xpath(xpath));
                return element.isDisplayed();
            }
        });
    }

    /**
     * Waits for text to be present in the element specified.
     *
     * @param by target element's locator.
     * @param text text to wait for.
     *
     * @return indicates whether the element contain the text finally.
     */
    public static boolean waitForText(By by, String text) {
        logger.info(String.format("wait For Text('%s') at %s", text, by));

        return  (new WebDriverWait(Browser.getDriver(), WAITFOR_TIMEOUT))
                .until(ExpectedConditions.textToBePresentInElementLocated(by, text));
    }

    /**
     * Simple wrapper around driver.findElement().
     * Simplifies logging and extending.
     *
     * @param by - element-to-find locator.
     *
     * @return WebElement found.
     */
    public static WebElement findElement(By by) {
        logger.debug("findElement() By: " + by.toString());

        return Browser.getDriver().findElement(by);
    }

    /**
     * Sends keys to the element specified.
     *
     * @param element - target element.
     * @param value string to be typed.
     */
    public static void sendKeys(WebElement element, CharSequence value) {
        logger.debug(String.format("Sending Keys '%s' to %s ",value.toString(), element.toString()));
        element.sendKeys(value);
    }

    /**
     * Finds and sends keys to the element specified by locator.
     *
     * @param by - target element's locator.
     * @param value string to be typed.
     */
    public static void sendKeys(By by, CharSequence value) {
        sendKeys(findElement(by), value);
    }

    /**
     * Finds element by the locator specified and left-mouse clicks it.
     *
     * @param by - element's locator.
     */
    public static void click(By by) {
        WebElement element = findElement(by);

        logger.debug("click() element By: " + by.toString());
        element.click();
    }

    /**
     * Checks whether element specified by the locator is present on current page.
     *
     * @param by - locator of the element.
     *
     * @return True if the element present on the page.
     */
    public static boolean isPresent(By by) {
        logger.debug("isPresent() By: " + by.toString());

        return Browser.getDriver().findElements(by).size() > 0;
    }

    /**
     * Checks whether element specified by id is present on current page.
     *
     * @param id - element's id.
     *
     * @return True if the element present on the page.
     */
    public static boolean isPresentById(String id) {
        logger.debug("isPresentById(): " + id);
        return isPresent(By.id(id));
    }

    /**
     * Tries to raise submit on the element.
     * @param element - the target element.
     */
    public static void submit(WebElement element) {
        logger.debug("Submitting " + element);
        element.submit();
    }

    /**
     * Tries to raise submit on element specified by the locator.
     *
     * @param by- the target element's locator.
     */
    public static void submit(By by) {
        submit(findElement(by));
    }

    /**
     * Gets element's text if the element can be found.
     *
     * @param by - element-to-find-and-derive-text-from locator.
     *
     * @return WebElement's text.
     */
    public static String getText(By by) {
        WebElement el = findElement(by);
        if (null != el){
            return el.getText();
        }

        logger.error(String.format("Element(%s) Not Found, cannot get its text.", by));

        return "{NOT FOUND, NOTHING TO GET, SEE THE LOG.}";
    }

    /**
     * Gets element attribute's value if the element can be found.
     *
     * @param by - element-to-find-and-get-attribute-value-from locator.
     * @param attributeName - attribute-to-use name.
     *
     * @return WebElement's attribute value.
     */
    public static String getAttributeValue(By by, String attributeName) {
        WebElement el = findElement(by);
        if (null != el){
            return el.getAttribute(attributeName);
        }

        logger.error(String.format("Element(%s) Not Found, cannot get its attribute(%s) value.", by, attributeName));

        return "{NOT FOUND, NOTHING TO GET, SEE THE LOG.}";
    }

    //=====================================================================
    /**
     * Gets the actions for the active driver/</br>
     * Note: "Actions" is WebDriver specific thing, so this could break upon switching from WebDriver to something else.
     *
     * @return   WebDriver's Actions.
     */
    private static Actions getWebDriverActions() {
        return new Actions(Browser.getDriver());
    }

}
