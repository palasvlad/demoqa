package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;

import java.util.List;

public class PracticeFormPageMostenire extends HomePage {

    public PracticeFormPageMostenire(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstNameElement;

    @FindBy(id = "lastName")
    WebElement lastNameElement;

    @FindBy(id = "userEmail")
    WebElement userEmailElement;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")
    WebElement maleRadioButtonElement;

    @FindBy(id = "userNumber")
    WebElement userNumberElement;

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthElement;

    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select")
    WebElement yearDropdown;

    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[4]")
    WebElement dateToSelect;

    @FindBy(className = "subjects-auto-complete__value-container")
    WebElement subjectsField;

    @FindBy(id = "subjectsInput")
    WebElement subjectsInputField;

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")
    WebElement hobbiesSports;

    @FindBy(id = "uploadPicture")
    WebElement chooseFileUploadButton;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(xpath = "//*[@id=\"state\"]/div/div[1]/div[1]")
    WebElement stateAndCity;

    @FindBy(id = "react-select-3-input")
    WebElement stateSelection;

    @FindBy(xpath = "//*[@id=\"city\"]/div/div[1]/div[1]")
    WebElement cityDropdown;

    @FindBy(id = "react-select-4-input")
    WebElement citySelection;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr")
    List<WebElement> tableContentAfterSubmission;


    public void setFNameLnameEmail(String firstName, String lastName, String email) {
        element.writeOnElement(firstNameElement, firstName);
        element.writeOnElement(lastNameElement, lastName);
        element.writeOnElement(userEmailElement, email);

    }

    public void selectMaleGender() {
        maleRadioButtonElement.click();
    }

    public void setMobile(String mobileNo) {
        userNumberElement.sendKeys(mobileNo);
    }

    public void setDateOfBirth(String year) {
        dateOfBirthElement.click();
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText(year);
        dateToSelect.click();

    }

    public void setSubjectField(String subjectFieldContent) {
        subjectsField.click();
        element.writeOnElement(subjectsInputField, "English");
        element.enterOnElement(subjectsInputField);
    }

    public void clickOnHobbiesSports() {
        hobbiesSports.click();
    }

    public void uploadPicture() {
        element.uploadFileOnElement(chooseFileUploadButton, "C:\\Endava\\EndevLocal\\demoqa\\src\\test\\resources\\sampleFile.jpeg");
    }

    public void setCurrentAddress() {
        element.clickElement(currentAddress);
        element.writeOnElement(currentAddress, "Iasi Valea Ursului");
    }

    public void setStateAndCity() {
        element.clickElement(stateAndCity);
        element.writeOnElement(stateSelection, "NCR");
        element.enterOnElement(stateSelection);
        element.clickElement(cityDropdown);
        element.writeOnElement(citySelection, "Delhi");
        element.enterOnElement(citySelection);
    }

    public void submitForm() {
        element.clickElement(submitButton);
    }

    public void verifyIfEntryExists(String firstColumnEntry, String secondColumnExpected) {
        for (WebElement element : tableContentAfterSubmission) {
            System.out.println("verify:" + element.getText());

            if (element.getText().contains(firstColumnEntry)) {
                AssertJUnit.assertTrue(element.getText().contains(secondColumnExpected));
            }

        }
    }
}
