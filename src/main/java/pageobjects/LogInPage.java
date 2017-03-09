package pageobjects;

import lombok.Getter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Getter
public class LogInPage extends AbstractPageObject {
		
	@Name("Invalid Login Error")
    @FindBy(xpath = "//label[@class='error-label']")
    @Timeout(30)
    public static WebElement invalidErrorLogin;

    @Name("User login input field")
    @FindBy(id = "userLogin")
    @Timeout(30)
    private TextInput loginInput;

    @Name("User password input field")
    @FindBy(id = "userPassword")
    @Timeout(30)
    private TextInput passInput;

    @Name("Login button")
    @FindBy(id = "LoginButton")
    @Timeout(30)
    public static Button loginButton;

    @Step
    public final HomePage doLogIn(final String userName, final String userPass) {

        fillInputAs(loginInput, userName);

        fillInputAs(passInput, userPass);

        clickTo(loginButton);

        return new HomePage();
    }

    @Step
	public final LogInPage setInvalidEmail(String invalidEmail) {
		
    	fillInputAs(loginInput, invalidEmail);
    	
		return this;
	}

    @Step
	public final LogInPage setInvalidPass(String invalidPass) {
		
		fillInputAs(passInput, invalidPass);
		
		return this;
	}

    @Step
	public final HomePage doAuthorization() {
		
    	clickTo(loginButton);
    	
		return new HomePage();
		
	}
}
