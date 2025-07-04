package helperMethods;

import org.openqa.selenium.*;

import java.util.List;

public class Element {
    public WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public Element(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void forceClickElement(WebElement element){
        js.executeScript("arguments[0].click();", element);
    }

    public void writeOnElement(WebElement element, String textToSend) {
        element.sendKeys(textToSend);
    }

    public void enterOnElement(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    public void selectElementFromListByText(List<WebElement> element, String text) {
        for (int i = 0; i < element.size(); i++) {
            if (element.get(i).getText().equals(text)) {
                element.get(i).click();
                break;
            }
        }
    }

    public void uploadFileOnElement(WebElement element, String pathToFile) {
        element.sendKeys(pathToFile);
    }
}
