package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "div.dod_new-events__list.js-dod_new_events")
    private WebElement calendarEventsElement;
    @FindBy(xpath = "//*[contains(@class,'dod_new-events__list')]//a")
    private List<WebElement> countCalendarEvents;

    @FindBy(xpath = "(//div[contains(@class, 'dod_new-events-dropdown__input')])[1]")
    private WebElement eventsTypeSelector;

    @FindBy(xpath = "(//a[contains(@title, 'Открытый вебинар')])[1]")
    private WebElement eventType;

    private List<WebElement> titleEventsElement = driver.findElements(By.xpath("//*[contains(@class, 'js-dod-new-event-title')]"));

    public CalendarEventsPage clickOnCalendarEventsElement() {
        calendarEventsElement.click();

        return this;
    }

    public CalendarEventsPage getSumEventsElemets() {
        logger.info("Количество отображаемых карточек событий на вебстранице равно: " + countCalendarEvents.size());

        return this;
    }

    public CalendarEventsPage openEventsTypeSelector() {
        actions.moveToElement(eventsTypeSelector).build().perform();
        eventsTypeSelector.click();

        return this;
    }

    public CalendarEventsPage selectEventType() {
        actions.moveToElement(eventType).click().build().perform();

        return this;
    }


    private String getCurrentData() {
        Calendar cal = Calendar.getInstance();
        String currentData = new SimpleDateFormat("dd MMMM", new Locale("ru")).format(cal.getTime());

        return currentData;
    }


    public String getEventDays() {
        List<WebElement> elements = driver.findElements(By.xpath(" //span[contains(@class,'dod_new-event__calendar-icon')]/following-sibling::span"));
        String cardDate = null;

        for (WebElement element : elements ) {
            cardDate = element.getText();
            if (getCurrentData().equals(cardDate)) {
                logger.info("Данное мероприятие равно текущей дате " + getCurrentData());
            } else {
                logger.info("Данное мероприятие больше текущей даты " + getCurrentData());
            }
        }
        return cardDate;
    }

}
