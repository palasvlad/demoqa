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
import pages.elements.TextBoxPage;

import java.util.ArrayList;
import java.util.List;

public class ElementsTextBoxTest extends Hooks {

    public SetupCommon setupCommon;
    public List<String> expectedListInTextBoxAfterSubmit = new ArrayList<>();
    public Element element;
    public Window window;
    public HomePage homePage;
    public SubMenuPage subMenuPage;
    public TextBoxPage textBoxPage;

    @Test
    public void testElementesTextBox() {
        setupCommon= new SetupCommon();
        setupCommon.setUp();
        element = new Element(driver);
        window = new Window(driver);
        homePage = new HomePage(driver);
        textBoxPage = new TextBoxPage(driver);
        subMenuPage = new SubMenuPage(driver);

        ExtentReportManager.log(Status.INFO,"Test Started");
        homePage.goToMenuItem("Elements");
        ExtentReportManager.log(Status.PASS, "Successfully navigated to Elements page");
        subMenuPage.goToDesiredSubMenu("Text Box");
        ExtentReportManager.log(Status.PASS, "Successfully navigated to Text Box");
        textBoxPage.enterUserName("Vlad Palasanu");

        textBoxPage.enterEmailAddress("palas.vlad@gmail.com");

        textBoxPage.enterCurrentAddress("Tara: Romania","Oras: Iasi");

        window.scroll(0, 250);

        textBoxPage.enterPermanentAddress("Tara: Permanent Romania","Oras: Permanent Iasi");

        window.scroll(0, 250);
        textBoxPage.clickSubmitButton();

        List<WebElement> returnedElements = driver.findElements(By.cssSelector("div.border.col-md-12.col-sm-12 p"));
        buildExpectedList();
        for (WebElement element : returnedElements) {
            System.out.println(element.getText());
            Assert.assertTrue(expectedListInTextBoxAfterSubmit.contains(element.getText()));
        }

        ExtentReportManager.log(Status.PASS, "Assertions passed");

    }

    public void buildExpectedList() {
        expectedListInTextBoxAfterSubmit.add("Name:Vlad Palasanu");
        expectedListInTextBoxAfterSubmit.add("Email:palas.vlad@gmail.com");
        expectedListInTextBoxAfterSubmit.add("Current Address :Tara: Romania Oras: Iasi");
        expectedListInTextBoxAfterSubmit.add("Permananet Address :Tara: Permanent Romania Oras: Permanent Iasi");
    }

}
