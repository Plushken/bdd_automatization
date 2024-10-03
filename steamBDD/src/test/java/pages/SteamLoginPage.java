package pages;

import org.openqa.selenium.By;

import static utils.BrowserUtil.getWebDriverInstance;

public class SteamLoginPage extends BasePage {

    public SteamLoginPage() {
        super();
    }

    //поле для ввода имени аккаунта
    private final By fieldInputName = By.xpath("//input[@type=\"text\" and not(@placeholder)]");

    //поле для ввода пароля
    private final By fieldInputPassword = By.xpath("//input[@type=\"password\"] ");

    //кнопка входа в аккаунт
    private final By buttonSignIn = By.xpath(" //button[@type=\"submit\"]");

    //забыл пароль
    private final By linkForgotPassword = By.xpath("//a[contains(text(),\"Помогите\")]");

    //кнопка зарегистрироваться
    private final By linkRegistrationAccount = By.xpath(" //a[contains(@class,\"login_create_btn\")]");

    //сслыка узнать больше о Steam
    private final By linkMoreAboutSteam = By.xpath(" //a[contains(@class,\"about_link\")]");

    //вверный ввод
    private final By loginSuccessMessage = By.xpath("//div[@class =\"_2SE9Zaci337LtSMV5BSDLv\"]");

    //неверный ввод
    private final By loginErrorMessage = By.xpath("//div[@class=\"_1Mcy9wnDnt1Q72FijsNtHC\"]");


    public void inputValues(String name, String password) {
        if(name.equals("csb")){
            getWebDriverInstance().findElement(fieldInputPassword).sendKeys(password);
        }
        else if (password.equals("csb")) {
            getWebDriverInstance().findElement(fieldInputName).sendKeys(name);
        }
        else {
            getWebDriverInstance().findElement(fieldInputPassword).sendKeys(password);
            getWebDriverInstance().findElement(fieldInputName).sendKeys(name);
        }
    }

    public void clickOnLoginButton() {
        click(getWebDriverInstance().findElement(buttonSignIn));
    }

    public boolean isLoginSuccessMessageDisplayed(){
        return isElementDisplayed(loginSuccessMessage);
    }

    public boolean isLoginErrorMessageDisplayed(){
        return isElementDisplayed(loginErrorMessage);
    }

    public void navigateToSupportPage() {click(getWebDriverInstance().findElement(linkForgotPassword));}

    public void navigateToInfoSteamPage() {
        click(getWebDriverInstance().findElement(linkMoreAboutSteam));
    }

    public void navigateToSignInPage() {
        click(getWebDriverInstance().findElement(linkRegistrationAccount));
    }
}
