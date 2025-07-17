package features;

import helperMethods.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AHElementsUpload extends Hooks {

    @Test
    public void testDownloadbutton() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMenu.click();

        jse.executeScript("window.scrollBy(0,500)");
        WebElement textBoxMenuButton = driver.findElement(By.xpath("//span[text()='Upload and Download']"));
        textBoxMenuButton.click();
        jse.executeScript("window.scrollBy(0,-200)");

        WebElement chooseFileButton = driver.findElement(By.id("uploadFile"));
        chooseFileButton.sendKeys("C:/Users/vpalasanu/Downloads" + "/sampleFile.jpeg");

        WebElement resultAfterupload = driver.findElement(By.id("uploadedFilePath"));
        System.out.println(resultAfterupload.getText());
        Assert.assertTrue(resultAfterupload.getText().contains("sampleFile.jpeg"));
    }
}
