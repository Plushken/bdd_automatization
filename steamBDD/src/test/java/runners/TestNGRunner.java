package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;

import static utils.BrowserUtil.getWebDriverInstance;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        plugin = {"pretty", "json:target/cucumber.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    @AfterTest()
    public void tearDown(){
        getWebDriverInstance().quit();
    }

}
