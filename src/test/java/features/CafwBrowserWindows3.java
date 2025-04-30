package features;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CafwBrowserWindows3 {
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

        WebElement browserWindows = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        browserWindows.click();

        WebElement newTabButton = driver.findElement(By.id("messageWindowButton"));
        newTabButton.click();

        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        System.out.println(handles);


        driver.switchTo().window(handles.getLast());
        //driver.switchTo( ).alert( );

         WebElement validateNewTab = driver.findElement(By.xpath("/html/body/text()"));

        //AssertJUnit.assertTrue(validateNewTab.getText().contains("Knowledge"));

        //****************************TO DO **************************
        // fix timeout



    }
}
