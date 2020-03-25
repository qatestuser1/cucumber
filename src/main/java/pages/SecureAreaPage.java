package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private WebDriver driver;
    private By successLoginResult = By.className("flash");

    public SecureAreaPage(WebDriver driver){
        this.driver = driver;
    }

    public String getSuccessLoginResultText(){
        return driver.findElement(successLoginResult).getText();
    }
}
