import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class AutPracticeFormPageObjectTest {

    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    public void successfulRegistration() {
        registrationPage.openPage()
            .setFirstName("Andrei")
            .setLastName("Drzdvsk")
            .setUserEmail("andr@gmail.com")
            .setGenderWrapper("Other")
            .setUserNumber("2911111111 ")
            .setDateOfBirth("02", "September", "1998")
            .selectFavSubject("eng")
            .setHobbiesWrapper("Music")
            .uploadPicture()
            .setCurrentAddress("Some Address")
            .stateDropdownClick()
            .setStateCityWrapper("NCR")
            .setCity()
            .setStateCityWrapper("Delhi")
            .submitButton()

            .checkResult("Student Name", "Andrei Drzdvsk")
            .checkResult("Student Email", "andr@gmail.com")
            .checkResult("Gender", "Other")
            .checkResult("Mobile", "2911111111")
            .checkResult("Date of Birth", "02 September,1998")
            .checkResult("Subjects", "English")
            .checkResult("Hobbies", "Music")
            .checkResult("Picture", "pic1.png")
            .checkResult("Address", "Some Address")
            .checkResult("State and City", "NCR Delhi");
    }
    @Test
    public void successfulRegWithMinimalData() {
        registrationPage.openPage()
                .setFirstName("And-r")
                .setLastName("Drzdv_sk")
                .setGenderWrapper("Male")
                .setUserNumber("4499999999")
                .setDateOfBirth("02", "September", "1998")
                .submitButton()

                .checkResult("Student Name", "And-r Drzdv_sk")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "4499999999")
                .checkResult("Date of Birth", "02 September,1998");

    }
    @Test
    public void clickSubmitWithoutData() {
        registrationPage.openPage()
                .submitButton()
                .nCheckBorderColorFirstName()
                .nCheckBorderColorLastName()
                .nCheckBorderColorPhoneNumber()
                .nCheckTableRespIsNotVisible();
    }
}
