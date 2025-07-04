package helperMethods.browser.service;

import configFile.configNode.DriverConfigNode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Objects;

public class ChromeBrowserService implements BrowserService{

    private WebDriver driver;

    @Override
    public void openBrowser(DriverConfigNode driverConfigNode) {
        ChromeOptions options=(ChromeOptions) getBrowserOptions(driverConfigNode);
        driver = new ChromeDriver(options);
        driver.get(driverConfigNode.url);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public Object getBrowserOptions(DriverConfigNode driverConfigNode) {
        ChromeOptions options= new ChromeOptions();
        if (driverConfigNode.headless.contains("headless")){
            options.addArguments(driverConfigNode.headless);
            options.addArguments("--window-size=1920,1080");
        }
        return options;
    }
}
