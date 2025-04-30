package features;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AGElementsDynamicProperties {
    public WebDriver driver;

    @Test
    public void testDownloadbutton() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMenu.click();

        jse.executeScript("window.scrollBy(0,500)");
        WebElement textBoxMenuButton = driver.findElement(By.xpath("//span[text()='Dynamic Properties']"));
        textBoxMenuButton.click();
        jse.executeScript("window.scrollBy(0,-300)");

        Thread.sleep(5000);
        WebElement enableIn5seconds = driver.findElement(By.id("enableAfter"));
        enableIn5seconds.click();

        WebElement colorChange = driver.findElement(By.id("colorChange"));
        colorChange.click();

        WebElement visibleAfter5sec = driver.findElement(By.id("visibleAfter"));
        visibleAfter5sec.click();



    }
}
