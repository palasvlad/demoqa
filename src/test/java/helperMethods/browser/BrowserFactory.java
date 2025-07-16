package helperMethods.browser;

import configFile.ConfigFile;
import configFile.configNode.ConfigurationNode;
import helperMethods.browser.service.ChromeBrowserService;
import logger.LoggerUtility;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class BrowserFactory {
    public WebDriver getBrwoserFactory() {
        String ciCd = System.getProperty("ciCdlocalorRemote");
        String browser = System.getProperty("browser").toLowerCase(Locale.ROOT);

        LoggerUtility.infoLog("Ruleaza pe: "+ browser);

        ConfigurationNode configurationNode = ConfigFile.createConfigNode(ConfigurationNode.class);

        if (Boolean.parseBoolean(ciCd)) {
            System.out.println("tet");
          //  configurationNode.driverConfigNode.headless = "--headless";
        } else {
            browser = configurationNode.driverConfigNode.localBrowser;
        }

        switch (browser){
            case BrowserType.BROWSER_CHROME:
                ChromeBrowserService chromeBrowserService = new ChromeBrowserService();
                chromeBrowserService.openBrowser(configurationNode.driverConfigNode);
                return chromeBrowserService.getDriver();
            case BrowserType.BROWSER_EDGE:
                System.out.println("To be implemented");
        }
        return null;
    }
}
