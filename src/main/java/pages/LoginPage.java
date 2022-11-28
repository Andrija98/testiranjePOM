package pages;

import data.CommonString;
import data.time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePageClass {

    private final By usernameLokator = By.id("user-name");
    private final By passwordLokator = By.id("password");
    private final By buttonLoginLokator = By.id("login-button");
    private final By errorMessageLokator = By.xpath("//div[@class=\"error-message-container error\"]");
    private final String loginPageUrl = CommonString.LOGIN_PAGE_URL;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public LoginPage verifyLoginPage(){
        waitForUrllChange(loginPageUrl, time.SHORTEST);
        return this;
    }
    public LoginPage open(){
        openUrl(loginPageUrl);
        return this;
    }
    public LoginPage typeInUsername(String text){
        WebElement element = waitForWebElementToBeVisible(usernameLokator, time.SHORTEST);
        this.clearAndTypeToWebElement(element, text);
        return this;
    }
    public LoginPage typeInPassword(String text){
        WebElement element = waitForWebElementToBeVisible(passwordLokator, time.SHORTEST);
        this.clearAndTypeToWebElement(element, text);
        return this;
    }
    public LoginPage clickLoginButtonNoProgress(){
        WebElement element = waitForWebElementToBeVisible(buttonLoginLokator, time.SHORTEST);
        this.clickWebElement(element);
        return this;
    }
    public AllItemsPage clickLoginButton(){
        WebElement element = waitForWebElementToBeVisible(buttonLoginLokator, time.SHORTEST);
        this.clickWebElement(element);
        AllItemsPage allitemspage = new AllItemsPage(driver);
        return allitemspage;
    }
    public String getErrorMessage(){
        WebElement element = driver.findElement(errorMessageLokator);
        return getTextFormElement(element);
    }
}
