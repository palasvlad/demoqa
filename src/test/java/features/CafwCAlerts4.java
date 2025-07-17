package features;

import helperMethods.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CafwCAlerts4 extends Hooks {

    @Test
    public void testDownloadbutton() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMenu.click();

        WebElement browserWindows = driver.findElement(By.xpath("//span[text()='Alerts']"));
        browserWindows.click();
        jse.executeScript("window.scrollBy(0,-50)");
        
        WebElement timerAlertButton = driver.findElement(By.id("promtButton"));
        timerAlertButton.click();


        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Vlad");
        promptAlert.accept();


    }
}
