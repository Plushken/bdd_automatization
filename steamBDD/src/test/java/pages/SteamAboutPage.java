package pages;

import org.openqa.selenium.By;

public class SteamAboutPage extends BasePage{
    public SteamAboutPage(){
        super();
    }
    private final By aboutSteamText = By.xpath("//div[@id=\"about_greeting\"]");
    public boolean isAboutSteamTextDisplayed(){
        return isElementDisplayed(aboutSteamText);
    }
}
