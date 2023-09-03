package pageObject;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;


public abstract class BasePage extends AbsPageObject{

    private final static String BASE_URL = System.getProperty("base.url");

    public BasePage(WebDriver driver){
        super(driver);
    }

    protected org.apache.logging.log4j.Logger logger = LogManager.getLogger(BasePage.class);


    public void open(String path) {
        driver.get(BASE_URL + path);
    }
}
