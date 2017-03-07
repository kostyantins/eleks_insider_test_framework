package pageobjects;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Getter
public class LoginPage extends AbstractPageObject {

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
    private Button loginButton;

    @Step
    public final HomePage doLogIn(final String userName, final String userPass) {

        fillInputAs(loginInput, userName);

        fillInputAs(passInput, userPass);

        clickTo(loginButton);

        return new HomePage();
    }
}
