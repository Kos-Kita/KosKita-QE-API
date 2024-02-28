package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.KoskitaAboutContactPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KoskitaAboutContactSteps {

    private final WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    KoskitaAboutContactPage koskitaAboutContactPage = new KoskitaAboutContactPage(driver);

    @When("User click to about page")
    public void userClickToAboutPage() {
        koskitaAboutContactPage.setButtonAboutPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    @Then("User already on about page")
    public void userAlreadyOnAboutPage() {
        Assert.assertTrue(koskitaAboutContactPage.setVerifyAboutPage());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @When("User click to contact page")
    public void userClickToContactPage() {
        koskitaAboutContactPage.setButtonContactPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Then("User already on contact page")
    public void userAlreadyOnContactPage() {
        Assert.assertTrue(koskitaAboutContactPage.setVerifyContactPage());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

}
