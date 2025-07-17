package features;

import helperMethods.DriverHelper;
import helperMethods.Element;
import helperMethods.Hooks;
import helperMethods.Window;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PracticeFormPage;
import pages.SubMenuPage;

public class BForms_Refactored extends Hooks {
    public PracticeFormPage practiceFormPage;

    @Test
    public void testPracticeForm() {
        practiceFormPage = new PracticeFormPage(driver);

        homePage.goToMenuItem("Forms");
        subMenuPage.goToDesiredSubMenu("Practice Form");
        practiceFormPage.setFNameLnameEmail("Vlad", "Pala", "pala@gmail.com");
        window.scroll(0, 150);
        practiceFormPage.selectMaleGender();
        practiceFormPage.setMobile("0101010011");

        window.scroll(0, 250);

        practiceFormPage.setDateOfBirth("2025");

        practiceFormPage.setSubjectField("Subiect interesant");

        practiceFormPage.clickOnHobbiesSports();

        practiceFormPage.uploadPicture();

        window.scroll(0, 250);

        practiceFormPage.setCurrentAddress();

        window.scroll(0, 250);

        practiceFormPage.setStateAndCity();

        practiceFormPage.submitForm();

        practiceFormPage.verifyIfEntryExists("Student Name", "Vlad Pala");


    }
}
