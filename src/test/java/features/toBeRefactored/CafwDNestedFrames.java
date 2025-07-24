package features.toBeRefactored;

import helperMethods.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CafwDNestedFrames extends Hooks {

    @Test
    public void testFrames() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMenu.click();

        WebElement framesButton = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
        framesButton.click();

        List<String> handles = new ArrayList<>(driver.getWindowHandles());

        System.out.println(handles);

        WebElement iframe1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(iframe1);
        String frame1Text = driver.findElement(By.tagName("body")).getText();
        System.out.println(frame1Text);
        Assert.assertEquals(frame1Text, "Parent frame");


        WebElement iframe2 = driver.findElement(By.xpath("/html/body/iframe"));
        driver.switchTo().frame(iframe2);
        String frame2Text = driver.findElement(By.tagName("body")).getText();
        System.out.println(frame2Text);
        Assert.assertEquals(frame2Text, "Child Iframe");



    }

}
