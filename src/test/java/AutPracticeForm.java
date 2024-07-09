import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AutPracticeForm {
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
        $("#firstName").setValue("Andrei");
        $("#lastName").setValue("Drzdvsk");
        $("#userEmail").setValue("andr@gmail.com");
        $("#gender-radio-3").parent().click();
        $("#userNumber").setValue("2911111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(8);
        $(".react-datepicker__year-select").selectOptionByValue("1998");
        $(".react-datepicker__day--002").click();
        $("#subjectsInput").setValue("eng").pressEnter();
        $("#hobbies-checkbox-3").parent().click();
        File imageFile = new File("C:\\Users\\Power\\Pictures\\pic1.png");
        $("#uploadPicture").uploadFile(imageFile);
        $("#currentAddress").setValue("Some Address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
    }
}
