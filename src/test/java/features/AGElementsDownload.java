package features;

import helperMethods.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class AGElementsDownload extends Hooks {
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

        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        downloadButton.click();

        File downloadedFile = new File("C:/Users/vpalasanu/Downloads" + "/sampleFile.jpeg");
        boolean isDownloaded = waitForFile(downloadedFile);
        System.out.println("Valoarea lui is downloaded este : " + isDownloaded);
        assert isDownloaded;

    }

    private static boolean waitForFile(File file) throws InterruptedException {
        int elapsedTime = 0;
        while (elapsedTime < 10) {
            if (file.exists()) {
                return true;
            }
            Thread.sleep(1000);
            elapsedTime++;
        }
        return false;
    }
}
