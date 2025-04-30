package features;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CafwDFrames {
    public WebDriver driver;

    @Test
    public void testFrames() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMenu.click();

        WebElement framesButton = driver.findElement(By.xpath("//span[text()='Frames']"));
        framesButton.click();

        List<String> handles = new ArrayList<>(driver.getWindowHandles());

        System.out.println(handles);

        WebElement iframe1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(iframe1);
        String frame1Text = driver.findElement(By.tagName("body")).getText();
        System.out.println(frame1Text);
        Assert.assertEquals(frame1Text, "This is a sample page");

        driver.switchTo().defaultContent();

        WebElement iframe2 = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(iframe2);
        String frame2Text = driver.findElement(By.tagName("body")).getText();
        System.out.println(frame2Text);
        Assert.assertEquals(frame2Text, "This is a sample page");



    }

}
