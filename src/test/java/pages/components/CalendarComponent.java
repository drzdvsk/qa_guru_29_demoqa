package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement selectMonth = $(".react-datepicker__month-select");
    private final SelenideElement selectYear = $(".react-datepicker__year-select");

    private void selectDay(String day) {
        String daySelector = String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day);
        $(daySelector).click();
    }
    public void setDate(String day, String month, String year) {
        selectYear.selectOption(year);
        selectMonth.selectOption(month );
        selectDay(day);
    }
}