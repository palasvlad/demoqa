package features;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CafwCAlerts2 {
    public WebDriver driver;

    @Test
    public void testDownloadbutton() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMenu.click();

        WebElement browserWindows = driver.findElement(By.xpath("//span[text()='Alerts']"));
        browserWindows.click();
        jse.executeScript("window.scrollBy(0,-50)");
        
        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        timerAlertButton.click();

        Thread.sleep(5000);

        driver.switchTo().alert().accept();


    }
}
