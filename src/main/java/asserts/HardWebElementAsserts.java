package asserts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class HardWebElementAsserts {

    private WebElement actual;

    private HardWebElementAsserts(final WebElement actual) {
        this.actual = actual;
    }

    public static final HardWebElementAsserts assertThat(final WebElement actual) {
        return new HardWebElementAsserts(actual);
    }

    @Step
    private final HardWebElementAsserts isNotNull() {

        if (actual == null) {
            Assert.fail("Element should be not null");
        }
        return this;
    }

    @Step
    public final HardWebElementAsserts isDisplayed() {

        isNotNull();

        if (!actual.isDisplayed()) {

            Assert.fail("Element {" + actual + "} should be displayed !");
        }
        return this;
    }

    @Step
    public final HardWebElementAsserts isTextContains(final String elementsText) {

        isNotNull();

        if (!actual
                .getText()
                .contains(elementsText)) {

            Assert.fail("Element's {" + actual + "} text {" + actual.getText() +
                    "} should contain {" + elementsText + "} !");
        }
        return this;
    }

    @Step
    public final HardWebElementAsserts isEqual(final String elementsText) {

        isNotNull();

        if (!actual
                .getText()
                .equalsIgnoreCase(elementsText)) {

            Assert.fail("Element's {" + actual + "} text {" + actual.getText() +
                    "} should be equal {" + elementsText + "} !");
        }
        return this;
    }

    @Step
    public final HardWebElementAsserts isCreatedAs(final String userName) {

        isNotNull();

        if (!actual
                .getText()
                .equalsIgnoreCase(userName)) {

            Assert.fail("Element's {" + actual + "} text {" + actual.getText() +
                    "} should be equal {" + userName + "} !");
        }
        return this;
    }

    @Step
    public final HardWebElementAsserts isLogInAs(final String userName) {

        isNotNull();

        if (!actual
                .getText()
                .equalsIgnoreCase(userName)) {

            Assert.fail("Element's {" + actual + "} text {" + actual.getText() +
                    "} should be equal {" + userName + "} !");
        }
        return this;
    }

    @Step
    public final HardWebElementAsserts isNotLogIn() {

        isNotNull();

        if (!actual.isDisplayed()) {

            Assert.fail(actual + "should be displayed !");
        }
        return this;
    }

    @Step
    public final HardWebElementAsserts isCreated() {

        isNotNull();

        if (!actual.isDisplayed()) {

            Assert.fail("Element {" + actual + "} should be displayed !");
        }
        return this;
    }

    @Step
    public final HardWebElementAsserts isChangedAs(final String language) {

        isNotNull();

        if (!actual
                .getText()
                .equalsIgnoreCase(language)) {

            Assert.fail("Element's {" + actual + "} text {" + actual.getText() +
                    "} should be equal {" + language + "} !");
        }
        return this;
    }

    @Step
    public final HardWebElementAsserts isChangedOn(final String title) {

        isNotNull();

        if (!actual
                .getAttribute("title")
                .equalsIgnoreCase(title)) {

            Assert.fail("Element's {" + actual + "} attribute {" + actual.getAttribute("title") +
                    "} should be equal {" + title + "} !");
        }
        return this;
    }
}
