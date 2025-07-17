package features;

import helperMethods.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ADElementsWebTablesTest extends Hooks {

    @Test
    public void testelementsCheckBox() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMenu.click();

        WebElement textBoxMenuButton = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        textBoxMenuButton.click();

        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        jse.executeScript("window.scrollBy(0,500)");
        addButton.click();

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.click();
        firstName.sendKeys("Vlad");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.click();
        lastName.sendKeys("Palasanu");

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.click();
        userEmail.sendKeys("palas.vlad@gmail.com");

        WebElement age = driver.findElement(By.id("age"));
        age.click();
        age.sendKeys("33");

        WebElement salary = driver.findElement(By.id("salary"));
        salary.click();
        salary.sendKeys("330");

        WebElement department = driver.findElement(By.id("department"));
        department.click();
        department.sendKeys("Testing");

        WebElement submit = driver.findElement(By.id("submit"));
        jse.executeScript("arguments[0].click();", submit);

        List<WebElement> getTableElements = driver.findElements(By.xpath("//div[contains(@class, 'rt-tr') and not(contains(@class, 'padRow')) and (contains(@class, '-odd') or contains(@class, '-even'))]"));
        System.out.println(getTableElements.getFirst().getText());
        for (WebElement getTableElement : getTableElements) {
            System.out.println(getTableElement.getText());
        }

        //assert. check last element that should be the one was added.
        AssertJUnit.assertTrue(getTableElements.getLast().getText().contains("Vlad") &&
                getTableElements.getLast().getText().contains("Palasanu") &&
                getTableElements.getLast().getText().contains("33"));


    }


}
