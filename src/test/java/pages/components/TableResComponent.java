package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResComponent  {
        private final
        SelenideElement tableTitle = $(".modal-title");
        SelenideElement tableBody = $(".table-responsive");

        public void checkResult (String key, String value) {
            $(tableBody).$(byText(key)).parent()
                    .shouldHave(text(value));
        }
        public void nCheckResult() {
            tableTitle.shouldNot(visible);
            }
    }
