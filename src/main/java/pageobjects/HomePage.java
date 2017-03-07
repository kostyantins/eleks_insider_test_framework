package pageobjects;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Image;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Getter
public class HomePage extends AbstractPageObject {

    //unique HomePage element to check if user log in
    @Name("Eleks people of the future party")
    @FindBy(id = "//img[@class='centered-and-cropped']")
    @Timeout(30)
    public static Image eleksParty;
}
