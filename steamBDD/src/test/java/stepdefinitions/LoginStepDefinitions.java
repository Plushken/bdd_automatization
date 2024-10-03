package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.SteamAboutPage;
import pages.SteamLoginPage;
import pages.SteamRegistrationPage;
import pages.SteamSupportPage;

public class LoginStepDefinitions{

    SteamLoginPage loginPage = new SteamLoginPage();
    SteamRegistrationPage registrationPage = new SteamRegistrationPage();
    SteamAboutPage aboutPage = new SteamAboutPage();
    SteamSupportPage supportPage = new SteamSupportPage();


    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.open("https://store.steampowered.com/login/");
    }

    @When("I enter the correct login and password")
    public void iEnterTheCorrectLoginAndPassword() {
        loginPage.inputValues("dimon82211", "DABXCCBSB4TB");
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @Then("I should be redirected to the authenticator page")
    public void iShouldBeRedirectedToTheAuthenticatorPage() {
        Assert.assertTrue(loginPage.isLoginSuccessMessageDisplayed(), "The correct input element is not displayed.");
    }

    @When("I enter a {string} or {string}")
    public void iEnterAOr(String name, String password) {
        loginPage.inputValues(name, password);
    }


    @Then("I should see an error message indicating that the name or password is incorrect")
    public void iShouldSeeAnErrorMessageIndicatingThatTheNameOrPasswordIsIncorrect() {
        Assert.assertTrue(loginPage.isLoginErrorMessageDisplayed(), "The wrong input element is not displayed.");
    }

    @When("I click to forgot account link")
    public void iClickToForgotAccountLink() {
        loginPage.navigateToSupportPage();
    }

    @Then("I should be redirected to steam support page")
    public void iShouldBeRedirectedToSteamSupportPage() {
        Assert.assertTrue(supportPage.isForgotLoginFormDisplayed(), "The forgot login form is not displayed.");
    }

    @When("I click to learn more about steam link")
    public void iClickToLearnMoreAboutSteamLink() {
        loginPage.navigateToInfoSteamPage();
    }

    @Then("I should be redirected to about Steam page")
    public void iShouldBeRedirectedToAboutSteamPage() {
        Assert.assertTrue(aboutPage.isAboutSteamTextDisplayed(), "The about steam element is not displayed.");
    }

    @When("I click to create account link")
    public void iClickToCreateAccountLink() {
        loginPage.navigateToSignInPage();
    }

    @Then("I should be redirected to create account page")
    public void iShouldBeRedirectedToCreateAccountPage() {
        Assert.assertTrue(registrationPage.isFieldInputNameDisplayed(), "The sign in element is not displayed.");
    }
}

