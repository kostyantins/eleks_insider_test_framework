package tests;

import org.testng.annotations.Test;

import util.PropertiesReader;
import util.TestRunner;

import static asserts.HardWebElementAsserts.assertThat;
import static pageobjects.HomePage.eleksParty;

public class validUserLoginTest extends TestRunner{
	
	@Test
	public final void testValidUserLogin(){

		final String userName = PropertiesReader.getProperty("valid.email");
		final String userPass = PropertiesReader.getProperty("valid.pass");

		loginPage
				.doLogIn(userName, userPass);

		assertThat(eleksParty).isDisplayed();
	}

}
