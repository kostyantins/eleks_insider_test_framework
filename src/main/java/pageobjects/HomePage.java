package pageobjects;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Image;

@Getter
public class HomePage extends AbstractPageObject {

    //unique HomePage element to check if user log in
    @Name("Eleks insider logo")
    @FindBy(xpath = "//*[@id='hamburger-menu']/a[1]")
    @Timeout(30)
    public static Image eleksInsiderLogo;
}
