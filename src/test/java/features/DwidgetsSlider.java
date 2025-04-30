package features;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DwidgetsSlider {
    public WebDriver driver;

    @Test
    public void testFrames() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Widgets']"));
        elementsMenu.click();

        WebElement accordianButton = driver.findElement(By.xpath("//span[text()='Slider']"));
        accordianButton.click();

        WebElement slider = driver.findElement(By.className("range-slider"));

        Actions action = new Actions(driver);

        action.clickAndHold(slider).moveByOffset(50,0).release().perform();


    }
}
