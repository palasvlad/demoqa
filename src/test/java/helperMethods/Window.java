package helperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Window {
    public WebDriver driver;

    public Window(WebDriver driver) {
        this.driver = driver;
    }


    public void scroll(int horizontal, int vertical){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy("+horizontal+","+vertical+")");    }

}
