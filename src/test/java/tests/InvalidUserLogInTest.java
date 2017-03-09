package tests;

import static asserts.HardWebElementAsserts.assertThat;
import static pageobjects.LogInPage.invalidErrorLogin;

import org.testng.annotations.Test;

import util.DataProviderArraySyntaxTest;
import util.TestRunner;

public class InvalidUserLogInTest extends TestRunner {

	@Test(dataProvider = "testInvalidDataLogIn", dataProviderClass = DataProviderArraySyntaxTest.class)
	public final void testInValidUserLogin (final String invalidEmail, final String invalidPass) {

		loginPage
				.setInvalidEmail(invalidEmail)
				.setInvalidPass(invalidPass)
				.doAuthorization();

		assertThat(invalidErrorLogin).isNotLogIn();
	}

}
