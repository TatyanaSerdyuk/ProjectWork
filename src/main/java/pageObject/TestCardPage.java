package pageObject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestCardPage extends BasePage{

    public TestCardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".course-header2__title")
    private WebElement titleCard;

    public TestCardPage getTitleCard5() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.cssSelector(String.valueOf(titleCard))));
        String titleCardActual = titleCard.getText();
        String titleCardExpected = "Автоматизация тестирования OpenStack";
        Assertions.assertEquals(titleCardExpected, titleCardActual);
        logger.info("Название: " + titleCardExpected);

        return this;
    }
    public TestCardPage getDescriptionCard5() {
        String descriptionActual = driver.findElement(By.cssSelector(".course-header2__subtitle")).getText();
        String descriptionExpected = "Лучшие практики по автоматизации тестирования облачной платформы OpenStack на Tempest";
        Assertions.assertEquals(descriptionExpected, descriptionActual);
        logger.info("Описание курса: " + descriptionExpected);

        return this;
    }
    public TestCardPage getDurationCard5() {
        String durationCard4Actual = driver.findElement(By.xpath("//*[contains(@class,'container__col_md-4')]//p[contains(@class,'course-header2-bottom__item-text')]")).getText();
        String durationCard4Expected = "4 месяца";
        Assertions.assertEquals(durationCard4Expected, durationCard4Actual);
        logger.info("Длительность: " + durationCard4Expected);

        return this;
    }
    public TestCardPage getFormatCard5() {
        String formatCard3Actual = driver.findElement(By.xpath("//*[contains(@class,'container__col_md-2')]//*[contains(@class,'course-header2-bottom__item-text')]")).getText();
        String formatCard3Expected = "Online";
        Assertions.assertEquals(formatCard3Expected, formatCard3Actual);
        logger.info("Формат: " + formatCard3Expected);

        return this;
    }

}
