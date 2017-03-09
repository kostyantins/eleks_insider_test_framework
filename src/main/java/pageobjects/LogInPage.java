package pageobjects;

import enums.PageObjects;
import enums.Users;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import util.PropertiesReader;

@Getter
public class LogInPage extends AbstractPageObject {

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
    public final HomePage doLogInAs(final Users user) {

        final String userName = PropertiesReader.getProperty("user.name");
        final String userPass = PropertiesReader.getProperty("user.pass");

        switch (user) {

            case USER:

                fillInputAs(loginInput, userName);
                fillInputAs(passInput, userPass);
                clickTo(loginButton);
                break;

            case ADMIN:
// TODO chang admin credentials after test admin will be create
                fillInputAs(loginInput, userName);
                fillInputAs(passInput, userPass);
                clickTo(loginButton);
                break;
        }
        return new HomePage();
    }
}
