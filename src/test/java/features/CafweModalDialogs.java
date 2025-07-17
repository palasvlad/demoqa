package features;

import helperMethods.Hooks;
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

public class CafweModalDialogs extends Hooks {

    @Test
    public void testFrames() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMenu.click();

        WebElement framesButton = driver.findElement(By.xpath("//span[text()='Modal Dialogs']"));
        framesButton.click();

        WebElement showSmallModal = driver.findElement(By.id("showSmallModal"));
        showSmallModal.click();

        WebElement validateSmallModal = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]"));
        System.out.println(validateSmallModal.getText());
        AssertJUnit.assertTrue(validateSmallModal.getText().contains("small modal"));

        WebElement closeModal = driver.findElement(By.id("closeSmallModal"));
        closeModal.click();

        WebElement largeModel = driver.findElement(By.id("showLargeModal"));
        largeModel.click();

        Thread.sleep(1000);
        WebElement validateLargeModal = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/p"));
        AssertJUnit.assertTrue(validateLargeModal.getText().contains("Lorem Ipsum"));

        WebElement closeLargeModal = driver.findElement(By.id("closeLargeModal"));
        closeLargeModal.click();



    }

}
