package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResComponent  {
    public void TableRes() {
        SelenideElement tableTitle = $(".modal-title");
        SelenideElement tableBody = $(".table-responsive");
}
        public void checkResult (String key, String value){
        $(".modal-title").$(byText(key)).parent()
                .shouldHave(text(value));
    }
}