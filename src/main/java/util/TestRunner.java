package util;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ru.yandex.qatools.allure.annotations.Step;

import java.net.MalformedURLException;

import static util.WebDriverFactory.getDriver;
import static util.WebDriverFactory.setDriver;

public class TestRunner {

    @Step
    @Parameters({"browser", "version", "platform"})
    @BeforeMethod
    public final void setUp(@Optional("default") final String browser,
                            @Optional("47") final String version,
                            @Optional("mac") final String platform) throws MalformedURLException {

        final String homePageUrl = PropertiesReader.getProperty("home.page.url");

        setDriver(browser, version, platform);

        getDriver()
                .manage()
                .window()
                .maximize();

        getDriver()
                .get(homePageUrl);
    }

    @Step
    @AfterTest
    public final void tarnDown() {

        if (getDriver() != null) {
            try {
                getDriver().quit();
            } catch (WebDriverException e) {
                System.out.println("***** CAUGHT EXCEPTION IN DRIVER TEARDOWN *****" + e);
            }
        }
    }
}
