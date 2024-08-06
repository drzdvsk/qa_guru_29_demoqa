package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            selectSubject = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            adressInput = $("#currentAddress"),
            stateDropdown = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            city = $("#city"),
            submitButton = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        $(firstNameInput).setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        $(lastNameInput).setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        $(userEmailInput).setValue(value);

        return this;
    }

    public RegistrationPage setGenderWrapper(String value) {
        $(genderWrapper).$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        $(userNumberInput).setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $(calendarInput).click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage selectFavSubject(String value) {
        selectSubject.sendKeys(value);
        selectSubject.pressEnter();

        return this;
    }

    public RegistrationPage setHobbiesWrapper(String value) {
        $(hobbiesWrapper).$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture() {
        $(uploadPicture).uploadFromClasspath("pic1.png");

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        $(adressInput).setValue(value);

        return this;
    }

    public RegistrationPage stateDropdownClick() {
        $(stateDropdown).click();

        return this;
    }

    public RegistrationPage setStateCityWrapper(String value) {
        $(stateCityWrapper).$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity() {
        $(city).click();

        return this;
    }

    public RegistrationPage submitButton() {
        $(submitButton).click();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }

    public RegistrationPage nCheckBorderColorFirstName() {
        $(firstNameInput).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }
    public RegistrationPage nCheckBorderColorLastName() {
        $(lastNameInput).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }
    public RegistrationPage nCheckBorderColorPhoneNumber() {
        $(lastNameInput).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }
    public RegistrationPage nCheckTableRespIsNotVisible() {
        $(".table-responsive").shouldNotBe(visible);

        return this;
    }
}

