package driverFactory;

import data.DriverData;
import exceptions.BrowserNotSupportedExeception;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;
import java.util.Locale;

public class WebDriverFactory {

    public static DriverData setDriverType() {
        String browserType = System.getProperty("browser").toUpperCase(Locale.ROOT);

        DriverData driverName = DriverData.valueOf(browserType);
        return driverName;
    }

    public WebDriver create(DriverData driverName, List<String> options) throws BrowserNotSupportedExeception {
        switch (driverName) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                if (options.size() > 0) {
                    for (String option : options) {
                        chromeOptions.addArguments(option);
                    }
                }
                return new ChromeDriver(chromeOptions);
            case OPERA:
                OperaOptions operaOptions = new OperaOptions();
                if (options.size() > 0) {
                    for (String option : options) {
                        operaOptions.addArguments(option);
                    }
                }
                return new OperaDriver(operaOptions);
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (options.size() > 0) {
                    for (String option : options) {
                        firefoxOptions.addArguments(option);
                    }
                }
                return new FirefoxDriver(firefoxOptions);
            default:
                throw new BrowserNotSupportedExeception(driverName);
        }
    }

    public void initDriver() throws BrowserNotSupportedExeception {

        switch (setDriverType()) {
            case CHROME:
                WebDriver driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                break;
            case OPERA:
                WebDriverManager.operadriver().setup();
                break;
            default:
                throw new BrowserNotSupportedExeception(setDriverType());
        }
    }
}
