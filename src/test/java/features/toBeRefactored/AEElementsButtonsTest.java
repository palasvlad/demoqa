package features.toBeRefactored;

import helperMethods.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class AEElementsButtonsTest extends Hooks {

    @Test
    public void testelementsCheckBox() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMenu.click();
        Thread.sleep(2000);

        jse.executeScript("window.scrollBy(0,500)");
        WebElement textBoxMenuButton = driver.findElement(By.xpath("//span[text()='Buttons']"));
        textBoxMenuButton.click();
        Thread.sleep(2000);

        jse.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);

        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();
        WebElement validateDoubleClick = driver.findElement(By.id("doubleClickMessage"));
        AssertJUnit.assertTrue(validateDoubleClick.getText().contains("You have done a double click"));

        Thread.sleep(2000);
        WebElement buttonToRightClick = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(buttonToRightClick).perform();
        WebElement validateRightClick = driver.findElement(By.id("rightClickMessage"));
        AssertJUnit.assertTrue(validateRightClick.getText().contains("You have done a right click"));

        Thread.sleep(2000);
        WebElement clickMeNormalCLick = driver.findElement(By.xpath("//button[text()='Click Me']"));
        actions.click(clickMeNormalCLick).perform();
        WebElement validateClickMeNormalClick = driver.findElement(By.id("dynamicClickMessage"));
        AssertJUnit.assertTrue(validateClickMeNormalClick.getText().contains("You have done a dynamic click"));


    }

}
