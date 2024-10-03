package pages;

import org.openqa.selenium.By;

public class SteamRegistrationPage extends BasePage {

    public SteamRegistrationPage() {
        super();
    }

    private final By fieldInputName = By.xpath("//div[@class=\"join_form\"]");

    public boolean isFieldInputNameDisplayed(){
        return isElementDisplayed(fieldInputName);
    }

}
