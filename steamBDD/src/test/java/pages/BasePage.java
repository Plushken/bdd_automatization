package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.BrowserUtil.getWebDriverInstance;

public class BasePage {

    private static final Duration TIMEOUT = Duration.ofSeconds(10);
    private static final Duration POLLING = Duration.ofMillis(100);

    //protected WebDriver driver;
    private final WebDriverWait wait;



    public BasePage() {
        getWebDriverInstance("chrome");
        wait = new WebDriverWait(getWebDriverInstance(), TIMEOUT, POLLING);
    }

    public void open(String url){
        getWebDriverInstance().get(url);
    }

    public void waitElementIsVisible(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }

    public boolean isElementDisplayed(By locator){
        return getWebDriverInstance().findElement(locator).isDisplayed();
    }

    protected String getText(WebElement element) {
        waitElementIsVisible(element);
        return element.getText();
    }

    protected void click(WebElement element) {wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();}

    public String getTitle() {
        return getWebDriverInstance().getTitle();
    }

    public String getCurrentUrl() {
        return getWebDriverInstance().getCurrentUrl();
    }

    public void navigateTo(String url) {
        getWebDriverInstance().navigate().to(url);
    }

    public void refreshPage() {
        getWebDriverInstance().navigate().refresh();
    }

}