package features;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class ABElementsCheckBoxTest {
    public WebDriver driver;

    @Test
    public void testelementsCheckBox() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMenu.click();

        WebElement textBoxMenuButton = driver.findElement(By.xpath("//span[text()='Check Box']"));
        textBoxMenuButton.click();

        jse.executeScript("window.scrollBy(0,200)");
        WebElement checkboxSpan = driver.findElement(By.className("rct-checkbox"));
        checkboxSpan.click();

        WebElement selectedResult = driver.findElement(By.id("result"));
        Assert.assertTrue(selectedResult.getText().contains("You have selected"));
        Assert.assertTrue(selectedResult.getText().contains("home"));

        WebElement collapseButton = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button"));
        collapseButton.click();

        WebElement collapseButtonDesktop = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button"));
        collapseButtonDesktop.click();

        WebElement collapseButtonDocuments = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button"));
        collapseButtonDocuments.click();

        jse.executeScript("window.scrollBy(0,200)");
        WebElement collapseButtonDownloads = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button"));
        collapseButtonDownloads.click();

        WebElement collapseButtonDocuWorkspace = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/button"));
        collapseButtonDocuWorkspace.click();

        WebElement collapseButtonDocuOffice = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/button"));
        collapseButtonDocuOffice.click();

        //ceva validari poate ar mai merge pe aici since there's almost nada


    }
}
