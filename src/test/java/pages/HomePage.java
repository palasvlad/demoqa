package pages;

import helperMethods.Element;
import helperMethods.Window;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    WebDriver driver;
    Element element;
    Window window;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.element = new Element(driver);
        this.window = new Window(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h5")
    List<WebElement> elements;

    public void goToMenuItem(String menu){
        window.scroll(0,500);
        element.selectElementFromListByText(elements, menu);
    }


}
