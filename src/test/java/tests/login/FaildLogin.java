package tests.login;

import data.CommonString;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.BaseTestClass;

public class FaildLogin extends BaseTestClass {
    private WebDriver driver;
    private String username;
    private String password;
    private String expectedMessageError;
    @BeforeMethod
    public void setUpTest(){
        driver = setUpDriver();
        username = CommonString.FAILD_USERNAME;
        password = CommonString.FAILD_PASSWORD;
    }

    @Test
    public void testFaildLogin(){
        LoginPage login = new LoginPage(driver).open();
        expectedMessageError = CommonString.ERROR_MESSAGE_STRING;
        String errorMessage =  login.typeInUsername(username).typeInPassword(password).clickLoginButtonNoProgress().getErrorMessage();
        Assert.assertEquals(errorMessage, expectedMessageError, "Message is not as expected");
    }


    @AfterMethod(alwaysRun = true)
    public void tierDown(){
        quitDriver(driver);
    }
}
