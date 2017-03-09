package tests;

import enums.PageObjects;
import org.testng.annotations.Test;
import util.DataProvider;
import util.PropertiesReader;
import util.TestRunner;

import static asserts.HardWebElementAsserts.assertThat;
import static pageobjects.LogInPage.loginButton;

public class LogOutTest extends TestRunner {

    @Test(dataProvider = "testLogOutData", dataProviderClass = DataProvider.class)
    public final void testLogOut(final PageObjects pageObject) {

        final String userName = PropertiesReader.getProperty("user.name");
        final String userPass = PropertiesReader.getProperty("user.pass");

        loginPage
                .doLogInAs(userName, userPass)
                .open(pageObject)
                .logOut();

        assertThat(loginButton).isDisplayed();
    }
}
