package helperMethods;

import configFile.ConfigFile;
import configFile.configNode.ConfigurationNode;
import configFile.configNode.WindowSizeNode;
import helperMethods.browser.BrowserFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SetupCommon {
    public WebDriver driver;
    public Window window;

    @BeforeMethod
    public void setUp() {
     //   ConfigurationNode configurationNode = ConfigFile.createConfigNode(ConfigurationNode.class);
     //   WindowSizeNode windowSizeNode=ConfigFile.createConfigNode(WindowSizeNode.class);
     //   driver = new ChromeDriver();
     //   driver.get(configurationNode.driverConfigNode.url);
//
     //   driver.manage().window().setSize(new Dimension(configurationNode.driverConfigNode.windowSizeNode.width, configurationNode.driverConfigNode.windowSizeNode.height));

        driver = new BrowserFactory().getBrwoserFactory();
    }

    @AfterMethod
    public void clearBrowser() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
