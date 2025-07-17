package pages.elements;

import helperMethods.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckBoxPage {
    WebDriver driver;
    Element element;

    public CheckBoxPage(WebDriver driver){
        this.driver = driver;
        this.element = new Element(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Check Box']")
    WebElement textBoxMenuButton;

    @FindBy(className = "rct-checkbox")
    WebElement checkboxSpan;

    @FindBy(id = "result")
    WebElement selectedResult;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/span/button")
    WebElement collapseButton;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button")
    WebElement collapseButtonDesktop;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button")
    WebElement collapseButtonDocuments;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/button")
    WebElement collapseButtonDocuWorkspace;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button")
    WebElement collapseButtonDownloads;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/button")
    WebElement collapseButtonDocuOffice;


    public void clickOntextBoxMenuButton(){
        textBoxMenuButton.click();
    }

    public void clickOncheckboxSpan(){
        checkboxSpan.click();
    }

    public void clickOnSelectedResult(){
        selectedResult.click();
    }

    public void clickOnCollapseButton(){
        collapseButton.click();
    }

    public void clickOnCollapseButtonDesktop(){
        collapseButtonDesktop.click();
    }

    public void clickOnCollapseButtonDocuments(){
        collapseButtonDocuments.click();
    }

    public void clickOnCollapseButtonDocuWorkspace(){
        collapseButtonDocuWorkspace.click();
    }

    public void clickOnCollapseButtonDownloads(){
        collapseButtonDownloads.click();
    }

    public void clickOnCollapseButtonDocuOffice(){
        collapseButtonDocuOffice.click();
    }
}
