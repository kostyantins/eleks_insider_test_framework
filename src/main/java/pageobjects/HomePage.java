package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Image;
import ru.yandex.qatools.htmlelements.element.Link;

@Getter
public class HomePage extends AbstractPageObject {

    //unique HomePage element to check if user log in
    @Name("Eleks insider logo")
    @FindBy(xpath = "//*[@id='hamburger-menu']/a[1]")
    @Timeout(30)
    public static Image eleksInsiderLogo;

    @Name("Log out link")
    @FindBy(xpath = "//*[@id='user-menu']//li/a")
    @Timeout(30)
    private Link logOutLink;

    @Name("User face")
    @FindBy(xpath = "//*[@id='user-menu']/div/a/div")
    @Timeout(30)
    private WebElement userFace;

    @Step
    public final LogInPage doLogOut() {

        logOut();

        return new LogInPage();
    }

    @Step
    public HomePage findLogOutButton() {

        moveToElement(userFace);

        return this;
    }
}
