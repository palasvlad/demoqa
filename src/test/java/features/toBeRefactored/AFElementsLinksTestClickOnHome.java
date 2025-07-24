package features.toBeRefactored;

import helperMethods.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class AFElementsLinksTestClickOnHome extends Hooks {

    @Test
    public void testelementsCheckBox() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMenu.click();

        jse.executeScript("window.scrollBy(0,500)");
        WebElement textBoxMenuButton = driver.findElement(By.xpath("//span[text()='Links']"));
        textBoxMenuButton.click();
        String originalHandle= driver.getWindowHandle();

        WebElement homeLink = driver.findElement(By.id("simpleLink"));
        homeLink.click();

        Thread.sleep(3000);
        String allWindows = driver.getWindowHandles().toString();
        System.out.println(allWindows);

        jse.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        List<WebElement> verifyHomeMenu = driver.findElements(By.xpath("//strong[text()='Following links will open new tab']"));
        System.out.println(verifyHomeMenu.getFirst().getText());


        Set<String> sessions = driver.getWindowHandles();
        System.out.println(sessions);

        for (String handle : sessions){
            if(!handle.equals(originalHandle)){
                driver.switchTo().window(handle);
                break;
            }
        }


        jse.executeScript("window.scrollBy(0,500)");
        WebElement elementsMenu1 = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMenu1.click();

        jse.executeScript("window.scrollBy(0,500)");
        WebElement textBoxMenuButton1 = driver.findElement(By.xpath("//span[text()='Links']"));
        textBoxMenuButton1.click();

        WebElement homeJYFwb = driver.findElement(By.id("dynamicLink"));
        homeJYFwb.click();

        Set<String> sessions3 = driver.getWindowHandles();
        System.out.println(sessions3.size());
        Assert.assertEquals(sessions3.size(),3);




    }
}
