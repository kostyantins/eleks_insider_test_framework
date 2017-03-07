package tests;

import org.testng.annotations.Test;
import util.PropertiesReader;
import util.TestRunner;

import static asserts.HardWebElementAsserts.assertThat;
import static pageobjects.LogInPage.loginButton;

public class LogOutTest extends TestRunner {

    @Test
    public final void testLogOut() {

        final String userName = PropertiesReader.getProperty("user.name");
        final String userPass = PropertiesReader.getProperty("user.pass");

        loginPage
                .doLogIn(userName, userPass)
                .findLogOutButton()
                .doLogOut();

        assertThat(loginButton).isDisplayed();
    }
}
