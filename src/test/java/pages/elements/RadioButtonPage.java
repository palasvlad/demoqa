package pages.elements;

import helperMethods.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage {
    WebDriver driver;
    Element element;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
        this.element = new Element(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Radio Button']")
    private WebElement radioButtonMenuButton;

    @FindBy(css = "label[for='yesRadio']")
    private WebElement yesRadioButton;

    @FindBy(xpath = "//*[@id=\\\"app\\\"]/div/div/div/div[2]/div[2]/p/span")
    private WebElement selectionValidation;

    @FindBy(css = "label[for='impressiveRadio']")
    private WebElement impressiveRadioButton;

    @FindBy(css = "label[for='noRadio']")
    private WebElement disabledNoRadioButton;

    public void clickOnRadioButtonMenuButton(){
        radioButtonMenuButton.click();
    }

    public void clickOnYesRadioButton(){
        yesRadioButton.click();
    }

    public void clickOnSelectionValidation(){
        selectionValidation.click();
    }

    public void clickOnImpressiveRadioButton(){
        impressiveRadioButton.click();
    }

    public void clickOnDisabledNoRadioButton(){
        disabledNoRadioButton.click();
    }



}
