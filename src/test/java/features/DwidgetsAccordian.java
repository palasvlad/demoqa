package features;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DwidgetsAccordian {
    public WebDriver driver;

    @Test
    public void testFrames() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Widgets']"));
        elementsMenu.click();

        WebElement accordianButton = driver.findElement(By.xpath("//span[text()='Accordian']"));
        accordianButton.click();

        WebElement firstAccordian = driver.findElement(By.id("section1Heading"));
        firstAccordian.click();

        WebElement accordianText = driver.findElement(By.xpath("//*[@id=\"section1Content\"]"));
        System.out.println(accordianText.getText());

    }
}
