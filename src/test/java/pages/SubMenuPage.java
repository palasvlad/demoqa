package pages;

import helperMethods.Element;
import helperMethods.Window;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SubMenuPage {
    WebDriver driver;
    Element element;
    Window window;

    public SubMenuPage(WebDriver driver) {
        this.driver = driver;
        this.element = new Element(driver);
        this.window = new Window(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class='text']")
    List<WebElement> elements;

    public void goToDesiredSubMenu(String submenu){
        element.selectElementFromListByText(elements,submenu);
    }
}
