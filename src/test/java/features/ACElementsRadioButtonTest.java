package features;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class ACElementsRadioButtonTest {
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

        WebElement textBoxMenuButton = driver.findElement(By.xpath("//span[text()='Radio Button']"));
        textBoxMenuButton.click();

        jse.executeScript("window.scrollBy(0,-50)");
        WebElement yesRadioButton = driver.findElement(By.cssSelector("label[for='yesRadio']"));
        yesRadioButton.click();

        //add validation
        WebElement selectionValidation = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/p/span"));
        System.out.println(selectionValidation.getText());
        AssertJUnit.assertTrue(selectionValidation.getText().contains("Yes"));


        WebElement impressiveRadioButton = driver.findElement(By.cssSelector("label[for='impressiveRadio']"));
        impressiveRadioButton.click();
        System.out.println(impressiveRadioButton.getText());
        AssertJUnit.assertTrue(impressiveRadioButton.getText().contains("Impressive"));

        //add validation

        WebElement disabledNoRadioButton = driver.findElement(By.cssSelector("label[for='noRadio']"));
        disabledNoRadioButton.click();

        //add validation

    }

}
