package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TestingPage extends BasePage {



    public TestingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.container.container-lessons > div > div > a:nth-child(5)")
    private WebElement card5;


    public void cardsCounter() {
        int xpathCount = driver.findElements(By.xpath("//*[contains(@class, 'lessons__new-item_hovered')]")).size();
        logger.info("Количество карточек на вебстранице равно: " + xpathCount);
    }

    public TestingPage clickOnCard5 () {

        wait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.cssSelector(String.valueOf(card5))));

        card5.click();
        logger.info("Карточка №5 открыта");

        return this;
    }
}
