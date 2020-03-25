package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public LoginPage clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
        return new LoginPage(driver);
    }

}
