package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "UserName")
    WebElement userName;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(id = "Login")
    WebElement loginBtn;

    public void login(String uname, String pwd) {
        userName.clear();
        userName.sendKeys(uname);
        password.clear();
        password.sendKeys(pwd);
        loginBtn.click();
    }
}
