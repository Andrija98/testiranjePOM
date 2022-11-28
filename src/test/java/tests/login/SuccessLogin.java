package tests.login;

import data.CommonString;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AllItemsPage;
import pages.LoginPage;
import tests.BaseTestClass;

public class SuccessLogin extends BaseTestClass {

    private WebDriver driver;
    private String username;
    private String password;

    @BeforeMethod
    public void setUpTest(){
        driver = setUpDriver();
        username = CommonString.USERNAME;
        password = CommonString.PASSWORD;
    }

    @Test
    public void testSuccessLogin(){
        LoginPage login = new LoginPage(driver).open();
        AllItemsPage allitems = login.typeInUsername(username).typeInPassword(password).clickLoginButton();
        Assert.assertTrue(allitems.verifyAllItemsPage(), "Url is not expected!!!");
    }



    @AfterMethod(alwaysRun = true)
    public void tearDownTest(){
        quitDriver(driver);
    }



}
