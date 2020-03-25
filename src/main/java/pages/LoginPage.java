package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.className("radius");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void inputUsername(String inputUsername){
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(inputUsername);
    }

    public void inputPassword(String inputPassword){
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(inputPassword);
    }

    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }


}
