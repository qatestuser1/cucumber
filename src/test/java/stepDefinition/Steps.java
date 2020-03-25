package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.BeforeClass;
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

    @Given("^Open Chrome and go to home page$")
    public void open_chrome_and_go_to_home_page(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }
    @When("Click \"([^\\\"]*)\" link")
    public void click_link(String link){
        loginPage = homePage.clickLink(link);
    }

    @And("^Input \"([^\\\"]*)\" and \"([^\\\"]*)\"$")
    public void input_username_and_password(String username, String password){
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        secureAreaPage = loginPage.clickLoginButton();
    }
    @Then("^Message should be \"([^\\\"]*)\"$")
    public void message_should_be(String message){
        assertTrue(secureAreaPage.getSuccessLoginResultText().contains(message));
    }
}
