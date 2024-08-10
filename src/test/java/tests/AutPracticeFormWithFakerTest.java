package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;


public class AutPracticeFormWithFakerTest {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    public void successfulRegistrationTest() {
        String userState = randomUtils.userState;
        String userCity = randomUtils.userCity(userState);

        registrationPage.openPage()
            .setFirstName(randomUtils.firstName)
            .setLastName(randomUtils.lastName)
            .setUserEmail(randomUtils.userEmail)
            .setGenderWrapper(randomUtils.chooseGender)
            .setUserNumber(randomUtils.userPhoneNumber)
            .setDateOfBirth(randomUtils.getDay(), randomUtils.getMonth(), randomUtils.getYear())
            .selectFavSubject(randomUtils.userFavSubject)
            .setHobbiesWrapper(randomUtils.userHobbies)
            .uploadPicture()
            .setCurrentAddress(randomUtils.userAddress)
            .stateDropdownClick()
            .setStateCityWrapper(userState)
            .setCity()
            .setStateCityWrapper(userCity)
            .submitButton()

                .checkResult("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                .checkResult("Student Email", randomUtils.userEmail)
                .checkResult("Gender", randomUtils.chooseGender)
                .checkResult("Mobile", randomUtils.userPhoneNumber)
                .checkResult("Date of Birth",
                        randomUtils.getDay() + " " + randomUtils.getMonth() + "," + randomUtils.getYear())
                .checkResult("Subjects", randomUtils.userFavSubject)
                .checkResult("Hobbies", randomUtils.userHobbies)
                .checkResult("Picture", "pic1.png")
                .checkResult("Address", randomUtils.userAddress)
                .checkResult("State and City", userState + " " + userCity);
    }
    @Test
    public void successfulRegWithMinimalDataTest() {
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
    public void clickSubmitWithoutDataTest() {
        registrationPage.openPage()
                .submitButton()
                .nCheckBorderColorFirstName()
                .nCheckBorderColorLastName()
                .nCheckBorderColorPhoneNumber()
                .nCheckTableRespIsNotVisible();
    }
}
