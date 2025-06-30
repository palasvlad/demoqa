package helperMethods;

import configFile.ConfigFile;
import configFile.configNode.ConfigurationNode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SetupCommon {
    public WebDriver driver;
    public Window window;

    @BeforeMethod
    public void setUp() {
        ConfigurationNode configurationNode = ConfigFile.createConfigNode(ConfigurationNode.class);
        driver = new ChromeDriver();
        driver.get(configurationNode.driverConfigNode.url);
        driver.manage().window().maximize();
        window = new Window(driver);
    }

    @AfterMethod
    public void clearBrowser() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
