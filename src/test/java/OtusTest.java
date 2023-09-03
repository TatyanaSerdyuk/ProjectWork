import data.CoursesData;
import data.MainMenuData;
import pageObject.*;
import utils.BaseTest;
import org.junit.jupiter.api.*;


public class OtusTest extends BaseTest {


    @Test
    public void test() {
        new MainPage(driver)
                .clickButtonLogin();

        new LoginPage(driver)
                .waitVisibleInputBox()
                .authorizationUser()
                .waitModalWindowInvisible();

        new MainPage(driver)
                .clickMainMenuCourses(MainMenuData.COURCES)
                .clickCoursesByName(CoursesData.TESTING);

        new TestingPage(driver)
                .cardsCounter();
    }

    @Test
    public void test2() {
        new MainPage(driver)
                .clickButtonLogin();

        new LoginPage(driver)
                .waitVisibleInputBox()
                .authorizationUser()
                .waitModalWindowInvisible();

        new TestingPage(driver)
                .open("/categories/testing/");
        new TestingPage(driver)
                .clickOnCard5();
        new TestCardPage(driver)
                .getTitleCard5()
                .getDescriptionCard5()
                .getDurationCard5()
                .getFormatCard5();
    }
    @Test
    public void test3() {
        new MainPage(driver)
                .clickOnEventsButton()
                .clickOnCalendarButton();

        new CalendarEventsPage(driver)
                //.clickOnCalendarEventsElement()
                .getSumEventsElemets()
                .getEventDays();
    }

    @Test
    public void test4() {
        new MainPage(driver)
                .clickOnEventsButton()
                .clickOnCalendarButton();

        new CalendarEventsPage(driver)
                .openEventsTypeSelector()
                .selectEventType();
    }
}
