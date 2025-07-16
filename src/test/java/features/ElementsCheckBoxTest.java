package features;

import helperMethods.DriverHelper;
import helperMethods.Window;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class ElementsCheckBoxTest {
    public WebDriver driver;
    public Window window;

    @Test
    public void testelementsCheckBox() {
        driver = new ChromeDriver();
        driver = DriverHelper.setupWebDriver("https://demoqa.com/");
        window = new Window(driver);

        window.scroll(0,500);

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMenu.click();

        WebElement textBoxMenuButton = driver.findElement(By.xpath("//span[text()='Check Box']"));
        textBoxMenuButton.click();

        window.scroll(0,200);
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

        window.scroll(0,200);
        WebElement collapseButtonDownloads = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button"));
        collapseButtonDownloads.click();

        WebElement collapseButtonDocuWorkspace = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/button"));
        collapseButtonDocuWorkspace.click();

        WebElement collapseButtonDocuOffice = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/button"));
        collapseButtonDocuOffice.click();

        //ceva validari poate ar mai merge pe aici since there's almost nada


    }
}
