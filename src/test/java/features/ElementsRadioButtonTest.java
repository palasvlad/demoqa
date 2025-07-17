package features;

import helperMethods.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pages.elements.RadioButtonPage;

public class ElementsRadioButtonTest extends Hooks {
    RadioButtonPage radioButtonPage;
    @Test
    public void testelementsCheckBox() {
        radioButtonPage = new RadioButtonPage(driver);

        window.scroll(0,500);
        homePage.goToMenuItem("Elements");

        radioButtonPage.clickOnRadioButtonMenuButton();

        window.scroll(0,-50);
        radioButtonPage.clickOnYesRadioButton();
        WebElement selectionValidation = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/p/span"));
        System.out.println(selectionValidation.getText());
        AssertJUnit.assertTrue(selectionValidation.getText().contains("Yes"));

        WebElement impressiveRadioButton = driver.findElement(By.cssSelector("label[for='impressiveRadio']"));
        radioButtonPage.clickOnImpressiveRadioButton();
        System.out.println(impressiveRadioButton.getText());
        AssertJUnit.assertTrue(impressiveRadioButton.getText().contains("Impressive"));

        radioButtonPage.clickOnDisabledNoRadioButton();


    }

}
