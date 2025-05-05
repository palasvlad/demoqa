package features;

import helpers.Element;
import helpers.Window;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AAElementsTextBoxTest {

    public WebDriver driver;
    public String expectedTextinTextBox = "Text Box";
    public List<String> expectedListInTextBoxAfterSubmit = new ArrayList<>();
    public Element element;
    public Window window;

    @Test
    public void testElementesTextBox() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        element = new Element(driver);
        window = new Window(driver);



        //  JavascriptExecutor jse = (JavascriptExecutor) driver;
      //  jse.executeScript("window.scrollBy(0,500)");
        window.scroll(0,500);

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        element.clickElement(elementsMenu);

        WebElement textBoxMenuButton = driver.findElement(By.xpath("//span[text()='Text Box']"));
        element.clickElement(textBoxMenuButton);

        WebElement textBoxText = driver.findElement(By.xpath("//h1[text()='Text Box']"));

        String actualtext = textBoxText.getText();
        Assert.assertEquals(expectedTextinTextBox, actualtext);

        WebElement fullNameTextField = driver.findElement(By.id("userName"));
        element.clickElement(fullNameTextField);
        fullNameTextField.sendKeys("Vlad Palasanu");

        WebElement eMailTextField = driver.findElement(By.id("userEmail"));
        element.clickElement(eMailTextField);
        eMailTextField.sendKeys("palas.vlad@gmail.com");

        WebElement currentAdressField = driver.findElement(By.id("currentAddress"));
        element.clickElement(currentAdressField);
        currentAdressField.sendKeys("Tara: Romania");
        currentAdressField.sendKeys(Keys.ENTER);
        currentAdressField.sendKeys("Oras: Iasi");
        //jse.executeScript("window.scrollBy(0,250)");
        window.scroll(0,250);

        WebElement permanentAdressField = driver.findElement(By.id("permanentAddress"));
        element.clickElement(permanentAdressField);
        permanentAdressField.sendKeys("Tara: Permanent Romania");
        permanentAdressField.sendKeys(Keys.ENTER);
        permanentAdressField.sendKeys("Oras: Permanent Iasi");

        WebElement submitButton = driver.findElement(By.id("submit"));
       // jse.executeScript("window.scrollBy(0,250)");
        window.scroll(0,250);
        element.clickElement(submitButton);

        List<WebElement> returnedElements = driver.findElements(By.cssSelector("div.border.col-md-12.col-sm-12 p"));
        buildExpectedList();


        for (WebElement element : returnedElements) {
            System.out.println(element.getText());
            Assert.assertTrue(expectedListInTextBoxAfterSubmit.contains(element.getText()));
        }


    }

    public void buildExpectedList() {
        expectedListInTextBoxAfterSubmit.add("Name:Vlad Palasanu");
        expectedListInTextBoxAfterSubmit.add("Email:palas.vlad@gmail.com");
        expectedListInTextBoxAfterSubmit.add("Current Address :Tara: Romania Oras: Iasi");
        expectedListInTextBoxAfterSubmit.add("Permananet Address :Tara: Permanent Romania Oras: Permanent Iasi");
    }

}
