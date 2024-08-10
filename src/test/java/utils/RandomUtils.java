package utils;

import com.github.javafaker.Faker;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class RandomUtils {
    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String userPhoneNumber = faker.numerify("##########");
    public String userAddress = faker.address().fullAddress();
    public Date dateOfBirth = faker.date().birthday();

    public String getDay() {
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        return dayFormat.format(dateOfBirth);
    }

    public String getMonth() {
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        return monthFormat.format(dateOfBirth);
    }

    public String getYear() {
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        return yearFormat.format(dateOfBirth);
    }

    public String chooseGender = faker.options()
            .option("Male", "Female", "Other");
    public String userHobbies = faker.options()
            .option("Music", "Sports");
    public String userFavSubject = faker.options()
            .option("English", "Math");
    public String userState = faker.options()
            .option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    public String userCity(String state) {
        if ("NCR".equals(state)) {
            return faker.options()
                    .option("Delhi", "Gurgaon", "Noida");
        } else if ("Uttar Pradesh".equals(state)) {
            return faker.options()
                    .option("Agra", "Lucknow", "Merrit");
        } else if ("Haryana".equals(state)) {
            return faker.options()
                    .option("Karnal", "Panipat");
        } else if ("Rajasthan".equals(state)) {
            return faker.options()
                    .option("Jaipur", "Jaiselmer");
        }
        return state;
    }
}



