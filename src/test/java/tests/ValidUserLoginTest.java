package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LogInPage;
import util.TestRunner;

import static asserts.HardWebElementAsserts.assertThat;
import static enums.Users.USER;
import static pageobjects.HomePage.eleksInsiderLogo;

public class ValidUserLoginTest extends TestRunner {

    @Test
    public final void testValidUserLogin() {

        loginPage
                .doLogInAs(USER);

        assertThat(eleksInsiderLogo).isDisplayed();
    }

    @AfterMethod
    public final LogInPage logOut() {

        homePage = new HomePage();

        homePage.logOut();

        return new LogInPage();
    }
}
