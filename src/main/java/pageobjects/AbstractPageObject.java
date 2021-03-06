package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import static util.Wait.getClickableElement;
import static util.WebDriverFactory.getDriver;

@Getter
public abstract class AbstractPageObject {

    public AbstractPageObject() {

        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(getDriver())), this);
    }

    @Step
    public final AbstractPageObject clickTo(final WebElement element) {

        findElementToClick(element).click();

        return this;
    }

    @Step
    public final AbstractPageObject fillInputAs(final WebElement input, final String textToInput) {

        findElementToInput(input).sendKeys(textToInput);

        return this;
    }

    @Step
    public final WebElement findElementToClick(final WebElement pageElement) {

        return getClickableElement(pageElement);
    }

    @Step
    public final WebElement findElementToInput(final WebElement pageElement) {

        pageElement.clear();

        return pageElement;
    }

    @Step
    public final AbstractPageObject acceptAlert() {

        getDriver()
                .switchTo()
                .alert()
                .accept();

        return this;
    }

    @Step
    public final AbstractPageObject dismissAlert() {

        getDriver()
                .switchTo()
                .alert()
                .dismiss();

        return this;
    }

    @Step
    public final AbstractPageObject refreshPage() {

        getDriver()
                .navigate()
                .refresh();

        return this;
    }

    @Step
    public final void moveToElement(final WebElement elementToMove) {

        final Actions actions = new Actions(getDriver());

        actions
                .moveToElement(getClickableElement(elementToMove))
                .perform();
    }

    @Step
    public final void goBack() {

        getDriver()
                .navigate()
                .back();
    }

    @Step
    public final LogInPage logOut() {

        final HomePage homePage = new HomePage();

        moveToElement(homePage.getUserFaceBlock());

        clickTo(homePage.getLogOutLink());

        return new LogInPage();
    }
}
