package features;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.List;

public class BForms {
    public WebDriver driver;

    @Test
    public void testDownloadbutton() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementsMenu.click();

        WebElement practiceForm = driver.findElement(By.xpath("//span[text() = 'Practice Form']"));
        practiceForm.click();
        jse.executeScript("window.scrollBy(0,150)");

        WebElement name = driver.findElement(By.id("firstName"));
        name.click();
        name.sendKeys("Vlad");

        WebElement lname = driver.findElement(By.id("lastName"));
        lname.click();
        lname.sendKeys("Palasanu");

        jse.executeScript("window.scrollBy(0,250)");
        WebElement email = driver.findElement(By.id("userEmail"));
        email.click();
        email.sendKeys("palas.vlad@gmail.com");


        WebElement maleRadButton = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label"));
        maleRadButton.click();

        WebElement userNumber = driver.findElement(By.id("userNumber"));
        userNumber.click();
        userNumber.sendKeys("1234567896");


        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirth.click();

        WebElement yearDropdown = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select"));

        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText("2020");

        WebElement dateToSelect = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[4]"));
        dateToSelect.click();

        WebElement subjectsField = driver.findElement(By.className("subjects-auto-complete__value-container"));
        subjectsField.click();
        WebElement inputField = driver.findElement(By.id("subjectsInput"));
        inputField.sendKeys("English");
        inputField.sendKeys(Keys.ENTER);

        WebElement hobbiesSports = driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label"));
        hobbiesSports.click();

        WebElement chooseFileButton = driver.findElement(By.id("uploadPicture"));
        chooseFileButton.sendKeys("C:/Users/vpalasanu/Downloads" + "/sampleFile.jpeg");

        jse.executeScript("window.scrollBy(0,250)");
        WebElement address = driver.findElement(By.id("currentAddress"));
        address.click();
        address.sendKeys("IAsi ");
        jse.executeScript("window.scrollBy(0,250)");

        WebElement state = driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]/div[1]"));
        state.click();
        WebElement stateSelection = driver.findElement(By.id("react-select-3-input"));
        stateSelection.sendKeys("NCR");
        stateSelection.sendKeys(Keys.ENTER);

        WebElement city = driver.findElement(By.xpath("//*[@id=\"city\"]/div/div[1]/div[1]"));
        city.click();
        WebElement citySelection = driver.findElement(By.id("react-select-4-input"));
        citySelection.sendKeys(Keys.ARROW_DOWN);
        citySelection.sendKeys(Keys.ENTER);


        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        List<WebElement> tableContent = driver.findElements(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr"));

        for (WebElement element : tableContent) {
            System.out.println("verify:" + element.getText());

            if (element.getText().contains("Student Name")){
                AssertJUnit.assertTrue(element.getText().contains("Vlad Palasanu"));
            }

        }
    }

}
