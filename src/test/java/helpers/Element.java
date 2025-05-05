package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Element {
    public WebDriver driver;

    public Element(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(WebElement element){
        element.click();
    }
}
