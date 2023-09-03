package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final static String LOGIN = System.getProperty("login");
    private final static String PASSWORD = System.getProperty("password");


    @FindBy(css = "div.new-input-line_slim:nth-child(3) > input:nth-child(1)")
    private WebElement loginTextBox;

    @FindBy(css = ".js-psw-input")
    private WebElement passwordTextBox;

    @FindBy(css = "div.new-input-line_last:nth-child(5) > button:nth-child(1)")
    private WebElement loginButton;

    private String inputTextBox = "div.new-input-line_slim:nth-child(3) > input:nth-child(1)";

    private String loginModalWindow = "//div[contains(@class, 'modal-container')][1]";


    public LoginPage waitVisibleInputBox() {
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector(inputTextBox)))
                .isDisplayed();

        return this;
    }

    public LoginPage waitModalWindowInvisible() {
        wait.until(ExpectedConditions
                .invisibilityOfElementLocated(By.xpath(loginModalWindow)));

        return this;
    }

    public LoginPage authorizationUser() {
        loginTextBox.sendKeys(LOGIN);
        passwordTextBox.sendKeys(PASSWORD);
        loginButton.submit();

        return this;
    }
}
