package features;

import com.aventstack.extentreports.Status;
import extentUtility.ExtentReportManager;
import helperMethods.Element;
import helperMethods.Hooks;
import helperMethods.SetupCommon;
import helperMethods.Window;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SubMenuPage;

import java.util.ArrayList;
import java.util.List;

public class AAElementsTextBoxTest_Refactored extends Hooks {

    public WebDriver driver;
    public SetupCommon setupCommon;
    public String expectedTextinTextBox = "Text Box";
    public List<String> expectedListInTextBoxAfterSubmit = new ArrayList<>();
    public Element element;
    public Window window;
    public HomePage homePage;
    public SubMenuPage subMenuPage;

    @Test
    public void testElementesTextBox() {
        setupCommon= new SetupCommon();
        setupCommon.setUp();
        driver = setupCommon.getDriver();
        element = new Element(driver);
        window = new Window(driver);
        homePage = new HomePage(driver);
        subMenuPage = new SubMenuPage(driver);

        homePage.goToMenuItem("Elements");
        subMenuPage.goToDesiredSubMenu("Text Box");


        WebElement textBoxText = driver.findElement(By.xpath("//h1[text()='Text Box']"));
        ExtentReportManager.log(Status.INFO,"Test Started");
        String actualtext = textBoxText.getText();
        Assert.assertEquals(expectedTextinTextBox, actualtext);

        WebElement fullNameTextField = driver.findElement(By.id("userName"));
        element.clickElement(fullNameTextField);
        element.writeOnElement(fullNameTextField, "Vlad Palasanu");
        ExtentReportManager.log(Status.PASS, "Test passed");

        WebElement eMailTextField = driver.findElement(By.id("userEmail"));
        element.clickElement(eMailTextField);
        ExtentReportManager.log(Status.PASS, "Test passed");
        element.writeOnElement(eMailTextField, "palas.vlad@gmail.com");

        WebElement currentAdressField = driver.findElement(By.id("currentAddress"));
        element.clickElement(currentAdressField);
        element.writeOnElement(currentAdressField, "Tara: Romania");
        element.enterOnElement(currentAdressField);
        element.writeOnElement(currentAdressField, "Oras: Iasi");
        window.scroll(0, 250);
        ExtentReportManager.log(Status.PASS, "Test passed");

        WebElement permanentAdressField = driver.findElement(By.id("permanentAddress"));
        element.clickElement(permanentAdressField);
        element.writeOnElement(permanentAdressField, "Tara: Permanent Romania");
        element.enterOnElement(permanentAdressField);
        element.writeOnElement(permanentAdressField, "Oras: Permanent Iasi");

        WebElement submitButton = driver.findElement(By.id("submit"));
        window.scroll(0, 250);
        element.clickElement(submitButton);

        List<WebElement> returnedElements = driver.findElements(By.cssSelector("div.border.col-md-12.col-sm-12 p"));
        buildExpectedList();
        for (WebElement element : returnedElements) {
            System.out.println(element.getText());
            Assert.assertTrue(expectedListInTextBoxAfterSubmit.contains(element.getText()));
        }


        ExtentReportManager.log(Status.PASS, "Test passed");


    }

    public void buildExpectedList() {
        expectedListInTextBoxAfterSubmit.add("Name:Vlad Palasanu");
        expectedListInTextBoxAfterSubmit.add("Email:palas.vlad@gmail.com");
        expectedListInTextBoxAfterSubmit.add("Current Address :Tara: Romania Oras: Iasi");
        expectedListInTextBoxAfterSubmit.add("Permananet Address :Tara: Permanent Romania Oras: Permanent Iasi");
    }

}
