import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static pages.RegistrationPage.firstNameInput;


public class AutPracticeFormPageObject {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void autPracticeForm() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        new RegistrationPage().setFirstName("Andrei");

        $("#lastName").setValue("Drzdvsk");
        $("#userEmail").setValue("andr@gmail.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("2911111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(8);
        $(".react-datepicker__year-select").selectOptionByValue("1998");
        $(".react-datepicker__day--002").click();
        $("#subjectsInput").setValue("eng").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("pic1.png");
        $("#currentAddress").setValue("Some Address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content")
                .shouldHave(text("Thanks for submitting the form"))
                .shouldHave(text("Andrei Drzdvsk"))
                .shouldHave(text("2911111111"))
                .shouldHave(text("02 September,1998"))
                .shouldHave(text("English"))
                .shouldHave(text("Music"))
                .shouldHave(text("pic1.png"))
                .shouldHave(text("Some Address"))
                .shouldHave(text("NCR Delhi"))
                .shouldHave(text("Other"));
    }
}
