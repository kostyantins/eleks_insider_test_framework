package util;

import org.testng.annotations.DataProvider;

public class DataProviderArraySyntaxTest {
	
	@DataProvider
	public static Object[][] testInvalidDataLogIn(){
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
	
}
