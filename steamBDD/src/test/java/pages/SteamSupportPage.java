package pages;

import org.openqa.selenium.By;

public class SteamSupportPage extends BasePage {

    public SteamSupportPage() {
        super();
    }

    private final By forgotLoginForm = By.xpath("//div[@class=\"forgot_login\"]");

    public boolean isForgotLoginFormDisplayed(){
        return isElementDisplayed(forgotLoginForm);
    }

}
