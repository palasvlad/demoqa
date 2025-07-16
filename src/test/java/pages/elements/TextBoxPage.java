package pages.elements;

import helperMethods.Element;
import helperMethods.Window;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TextBoxPage {
    WebDriver driver;
    Element element;
    Window window;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        this.element = new Element(driver);
        this.window = new Window(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    WebElement fullNameTextField;

    @FindBy(id = "userEmail")
    WebElement eMailTextField;

    @FindBy(id = "currentAddress")
    WebElement currentAddressField;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(css = "div.border.col-md-12.col-sm-12 p")
    List<WebElement> actualTableElements;

    public void enterUserName(String username) {
        fullNameTextField.sendKeys(username);
    }

    public void enterEmailAddress(String emailAddress) {
        eMailTextField.sendKeys(emailAddress);
    }

    public void enterCurrentAddress(String currentAddressLine1, String currentAddressLine2) {
        currentAddressField.sendKeys(currentAddressLine1);
        currentAddressField.sendKeys(Keys.ENTER);
        currentAddressField.sendKeys(currentAddressLine2);
    }

    public void enterPermanentAddress(String permanentAddressLine1, String permanentAddressLine2) {
        permanentAddress.sendKeys(permanentAddressLine1);
        permanentAddress.sendKeys(Keys.ENTER);
        permanentAddress.sendKeys(permanentAddressLine2);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
