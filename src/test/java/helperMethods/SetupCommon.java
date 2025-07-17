package helperMethods;

import helperMethods.browser.BrowserFactory;
import logger.LoggerUtility;
import org.openqa.selenium.WebDriver;

public class SetupCommon {
    public WebDriver driver;
    public Window window;

    public void setUp() {

        driver = new BrowserFactory().getBrwoserFactory();
        LoggerUtility.infoLog("The browser was opened with success");

    }

    public void clearBrowser() {
        driver.quit();
        LoggerUtility.infoLog("The browser was closed with success");
    }

    public WebDriver getDriver() {
        return driver;
    }
}
