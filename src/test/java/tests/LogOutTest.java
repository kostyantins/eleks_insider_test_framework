package tests;

import enums.PageObjects;
import org.testng.annotations.Test;
import util.DataProvider;
import util.TestRunner;

import static asserts.HardWebElementAsserts.assertThat;
import static enums.Users.USER;
import static pageobjects.LogInPage.loginButton;

public class LogOutTest extends TestRunner {

    @Test(dataProvider = "testLogOutData", dataProviderClass = DataProvider.class)
    public final void testLogOut(final PageObjects pageObject) {

        loginPage
                .doLogInAs(USER)
                .open(pageObject)
                .logOut();

        assertThat(loginButton).isDisplayed();
    }
}
