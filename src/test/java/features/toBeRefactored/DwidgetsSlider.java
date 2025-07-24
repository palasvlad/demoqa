package features.toBeRefactored;

import helperMethods.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DwidgetsSlider extends Hooks {

    @Test
    public void testFrames() throws InterruptedException {

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
