package features;

import com.aventstack.extentreports.Status;
import extentUtility.ExtentReportManager;
import helperMethods.DriverHelper;
import helperMethods.Hooks;
import helperMethods.Window;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.elements.CheckBoxPage;

import static org.testng.AssertJUnit.assertTrue;

public class ElementsCheckBoxTest extends Hooks {
    CheckBoxPage checkBoxPage;

    @Test
    public void testelementsCheckBox() {
        checkBoxPage =  new CheckBoxPage(driver);

        window.scroll(0,500);
        ExtentReportManager.log(Status.INFO, "Test started");
        homePage.goToMenuItem("Elements");

        checkBoxPage.clickOntextBoxMenuButton();

        window.scroll(0,200);

        checkBoxPage.clickOncheckboxSpan();

        WebElement selectedResult = driver.findElement(By.id("result"));
        Assert.assertTrue(selectedResult.getText().contains("You have selected"));
        Assert.assertTrue(selectedResult.getText().contains("home"));

        checkBoxPage.clickOnCollapseButton();
        checkBoxPage.clickOnCollapseButtonDesktop();
        checkBoxPage.clickOnCollapseButtonDocuments();
        window.scroll(0,200);
        checkBoxPage.clickOnCollapseButtonDownloads();
        checkBoxPage.clickOnCollapseButtonDocuWorkspace();
        checkBoxPage.clickOnCollapseButtonDocuOffice();
    }
}
