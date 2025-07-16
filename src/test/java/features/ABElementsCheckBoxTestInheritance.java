package features;

import helperMethods.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ABElementsCheckBoxTestInheritance extends Hooks {

    ABElementsCheckBoxTestInheritance (){
        super();
    }
    @Test
    public void testelementsCheckBox() {

        window.scroll(0,500);

        WebElement elementsMenu = getDriver().findElement(By.xpath("//h5[text()='Elements']"));
        elementsMenu.click();

        WebElement textBoxMenuButton = getDriver().findElement(By.xpath("//span[text()='Check Box']"));
        textBoxMenuButton.click();

        window.scroll(0,200);
        WebElement checkboxSpan = getDriver().findElement(By.className("rct-checkbox"));
        checkboxSpan.click();

        WebElement selectedResult = getDriver().findElement(By.id("result"));
        Assert.assertTrue(selectedResult.getText().contains("You have selected"));
        Assert.assertTrue(selectedResult.getText().contains("home"));

        WebElement collapseButton = getDriver().findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button"));
        collapseButton.click();

        WebElement collapseButtonDesktop = getDriver().findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button"));
        collapseButtonDesktop.click();

        WebElement collapseButtonDocuments = getDriver().findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button"));
        collapseButtonDocuments.click();

        window.scroll(0,200);
        WebElement collapseButtonDownloads = getDriver().findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button"));
        collapseButtonDownloads.click();

        WebElement collapseButtonDocuWorkspace = getDriver().findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/button"));
        collapseButtonDocuWorkspace.click();

        WebElement collapseButtonDocuOffice = getDriver().findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/button"));
        collapseButtonDocuOffice.click();

        //ceva validari poate ar mai merge pe aici since there's almost nada


    }
}
