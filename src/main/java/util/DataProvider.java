package util;

import static enums.PageObjects.*;

public class DataProvider {

    private DataProvider() {
    }

    @org.testng.annotations.DataProvider
    public static Object[][] testInvalidDataLogIn() {
        return new Object[][]{
                {"", ""},
                {PropertiesReader.getProperty("user.name"), ""},
                {PropertiesReader.getProperty("user.name"), PropertiesReader.getProperty("user.name")},

                {"", PropertiesReader.getProperty("user.pass")},
                {PropertiesReader.getProperty("user.pass"), PropertiesReader.getProperty("user.pass")},
                {"@#$!%^&*(){}|", "!@#$%^&*()_{}"},
                {"qwerty@eleks.com", "qwerty"}
        };
    }

    @org.testng.annotations.DataProvider
    public static Object[][] testLogOutData() {
        return new Object[][]{
                {HOME_PAGE},
                {BUSINESS_PAGE},
                {EDUCATION_PAGE},
                {ELEKS_LIFE_PAGE},
                {PEOPLE_PAGE},
                {PROJECTS_PAGE},
                {TECHNOLOGIES_PAGE},
        };
    }

//    @org.testng.annotations.DataProvider
//    public static Object[][] testNavigateData() {
//        return new Object[][]{
//                {CREATE_ACCOUNT_PAGE, CREATE_BUTTON},
//                {REMIND_PASS_PAGE, REMIND_PASS_BUTTON}
//        };
//    }
}
