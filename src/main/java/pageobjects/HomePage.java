package pageobjects;

import enums.PageObjects;
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

    @Name("Business page link")
    @FindBy(xpath = "(//*[@id='navigation-menu']//a)[3]")
    @Timeout(30)
    private Link businessPageLink;

    @Name("Education page link")
    @FindBy(xpath = "(//*[@id='navigation-menu']//a)[7]")
    @Timeout(30)
    private Link educationPageLink;

    @Name("Eleks life page link")
    @FindBy(xpath = "(//*[@id='navigation-menu']//a)[8]")
    @Timeout(30)
    private Link eleksLifePageLink;

    @Name("People page link")
    @FindBy(xpath = "(//*[@id='navigation-menu']//a)[6]")
    @Timeout(30)
    private Link peoplePageLink;

    @Name("Technologies page link")
    @FindBy(xpath = "(//*[@id='navigation-menu']//a)[4]")
    @Timeout(30)
    private Link technologiesPageLink;

    @Name("Project page link")
    @FindBy(xpath = "(//*[@id='navigation-menu']//a)[5]")
    @Timeout(30)
    private Link projectPageLink;

    @Name("User face")
    @FindBy(xpath = "//*[@id='user-menu']/div/a/div")
    @Timeout(30)
    private WebElement userFaceBlock;

    @Step
    public final AbstractPageObject open(final PageObjects pageObject) {

        AbstractPageObject object = null;
        final HomePage homePage = new HomePage();

        switch (pageObject) {

            case HOME_PAGE:
                object =  clickTo(eleksInsiderLogo);
                break;

            case BUSINESS_PAGE:
                object = homePage.openBusinessPage();
                break;

            case EDUCATION_PAGE:
                object = homePage.openEducationPage();
                break;

            case ELEKS_LIFE_PAGE:
                object = homePage.openEleksLifePage();
                break;

            case PEOPLE_PAGE:
                object = homePage.openPeoplePage();
                break;

            case PROJECTS_PAGE:
                object = homePage.openProjectPage();
                break;

            case TECHNOLOGIES_PAGE:
                object = homePage.openTechnologiesPage();
                break;
        }

        return object;
    }

    @Step
    private BusinessPage openBusinessPage() {

        clickTo(businessPageLink);

        return new BusinessPage();
    }

    @Step
    private EducationPage openEducationPage() {

        clickTo(educationPageLink);

        return new EducationPage();
    }

    @Step
    private EleksLifePage openEleksLifePage() {

        clickTo(eleksLifePageLink);

        return new EleksLifePage();
    }

    @Step
    private PeoplePage openPeoplePage() {

        clickTo(peoplePageLink);

        return new PeoplePage();
    }

    @Step
    private ProjectsPage openProjectPage() {

        clickTo(projectPageLink);

        return new ProjectsPage();
    }

    @Step
    private TechnologiesPage openTechnologiesPage() {

        clickTo(technologiesPageLink);

        return new TechnologiesPage();
    }
}
