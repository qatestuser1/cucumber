package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.junit.Assert.assertTrue;

public class Steps {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    SecureAreaPage secureAreaPage;

    @Given("Open Chrome and go to home page")
    public void open_Chrome_and_go_to_home_page() throws Exception {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @When("Click {string} link")
    public void click_link(String link) throws Exception {
        loginPage = homePage.clickLink(link);
    }

    @And("Input username {string} and password {string}")
    public void input_username_and_password(String username, String password) throws Exception {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        secureAreaPage = loginPage.clickLoginButton();
    }
    @Then("Message should be {string}")
    public void message_should_be(String message) throws Exception {
        assertTrue(secureAreaPage.getSuccessLoginResultText().contains(message));
    }

    @And("Close browser")
    public void close_browser() throws Exception {
        driver.quit();
    }
}
