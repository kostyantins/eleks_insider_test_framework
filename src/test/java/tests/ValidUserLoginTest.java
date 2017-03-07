package tests;

import org.testng.annotations.Test;
import util.PropertiesReader;
import util.TestRunner;

import static asserts.HardWebElementAsserts.assertThat;
import static pageobjects.HomePage.eleksInsiderLogo;

public class ValidUserLoginTest extends TestRunner {

    @Test
    public final void testValidUserLogin() {

        final String userName = PropertiesReader.getProperty("user.name");
        final String userPass = PropertiesReader.getProperty("user.pass");

        loginPage
                .doLogIn(userName, userPass);

        assertThat(eleksInsiderLogo).isDisplayed();
    }
}
