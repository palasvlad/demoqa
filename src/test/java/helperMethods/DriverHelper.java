package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

public class DriverHelper {

    public static WebDriver setupWebDriver(String testURL) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(testURL);
        return driver;
    }

}
