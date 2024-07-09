import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Andrei D");
        $("#userEmail").setValue("andr@mail.com");
        $("#currentAddress").setValue("Some Street1");
        $("#permanentAddress").setValue("Some Street2");
        $("#submit").click();

        $("#output").$("#name").shouldHave(text("Andrei D"));
        $("#output").$("#email").shouldHave(text("andr@mail.com"));
        $("#output").$("#currentAddress").shouldHave(text("Some Street1"));
        $("#output").$("#permanentAddress").shouldHave(text("Some Street2"));

    }
}