package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class BrowserUtil {

    private static WebDriver instance;

    public static WebDriver getWebDriverInstance() {
        if (null == instance) {
            return getWebDriverInstance("chrome");
        }
        return instance;
    }

    public static WebDriver getWebDriverInstance(String browser) {
        if (null == instance) {
            switch (Browser.valueOf(browser.toUpperCase())){
                case CHROME:
                    ChromeOptions optionsChrome = new ChromeOptions();
                    optionsChrome.addArguments("--lang=en", "--start-maximized", "--incognito", "--disable-popup-blocking", "--ignore-certificate-errors");
                    instance = new ChromeDriver(optionsChrome);
                    instance.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    instance.manage().deleteAllCookies();
                    break;
                case FIREFOX:
                    FirefoxOptions optionsFirefox = new FirefoxOptions();
                    optionsFirefox.addArguments("--start-maximized", "--incognito", "--disable-popup-blocking", "--ignore-certificate-errors");
                    instance = new FirefoxDriver(optionsFirefox);
                    instance.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    instance.manage().deleteAllCookies();
                    break;
            }
        }
        return instance;
    }

    public void closeDriver() {
        if (null != instance){
            instance.close();
        }
        instance = null;
    }

    public void quitDriver() {
        if (null != instance){
            instance.quit();
        }
        instance = null;
    }

}