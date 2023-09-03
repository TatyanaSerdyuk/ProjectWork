package pageObject;

import data.CoursesData;
import data.MainMenuData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".header2__auth")
    private WebElement loginButton;

    @FindBy(css = ".ic-blog-default-avatar")
    private WebElement userIcon;

    @FindBy(className = "header2-menu__dropdown-text")
    private WebElement userProfileButton;

    @FindBy(xpath = "//div[contains(@class, 'header2__right__menu__item')])[1]")
    private WebElement buttonProfile;

    @FindBy(xpath = "//*[contains(@class, 'header2-menu_main')]/*[contains(@class, 'header2-menu__item')][.//*[text()='Курсы']]")
    private WebElement coursesButton;

    @FindBy(xpath = "//*[contains(@class,'header2-menu__item header2-menu__item_dropdown header2-menu__item_open')]//*[contains(@title,'Тестирование')])")
    private WebElement dropDownTesting;

    @FindBy(xpath = "//div[contains(@class,'header2-menu_main')]//p[contains(@class,'header2-menu__item-text')][contains(text(),'События')]")
    private WebElement eventsButton;

    @FindBy(xpath = "//div[contains(@class,'header2-menu_main')]//a[@title='Календарь мероприятий'][contains(text(),'Календарь мероприятий')]")
    private WebElement dropDownCalendar;

    @FindBy(css = "#categories_id>.course-categories__nav-box>.container>.nav__items>:nth-child(7)")
    private WebElement buttonCourseTesting;

    private String mainMenuLocator = "//*[contains(@class, 'header2-menu_main')]/*[contains(@class, 'header2-menu__item')][.//*[text()='%s']]";

    private String subMenuLocator = mainMenuLocator + "//a[@title='%s']";



    public MainPage moveCoursorOnUserIcon() {
        actions.moveToElement(userIcon).build().perform();

        return this;
    }

    public MainPage clickUserProfile(){
        userProfileButton.click();

        return this;
    }
    public MainPage clickButtonLogin(){
        loginButton.click();
        return this;
    }


    public MainPage clickMainMenuCourses(MainMenuData mainMenuData) {
        String locator = String.format(mainMenuLocator, mainMenuData.getName());

        WebElement mainMenu = driver.findElement(By.xpath(locator));
        actions.moveToElement(mainMenu).build().perform();

        return this;
    }

    public MainPage clickCoursesByName(CoursesData coursesData) {
        String locator = String.format(subMenuLocator, MainMenuData.COURCES.getName(), coursesData.getName());
        WebElement subMenu = driver.findElement(By.xpath(locator));
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(locator)))
                .isDisplayed();
        actions.moveToElement(subMenu).click().build().perform();

        return this;
    }


    public MainPage clickOnEventsButton() {
        eventsButton.click();

        return this;
    }

    public MainPage clickOnCalendarButton() {
        dropDownCalendar.click();

        return this;
    }

    public MainPage clickCourseTesting() {
        buttonCourseTesting.click();

        return this;
    }
}
