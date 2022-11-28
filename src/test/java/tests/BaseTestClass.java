package tests;

import org.openqa.selenium.WebDriver;
import utils.WebDriverUtils;

import java.io.IOException;

public class BaseTestClass {

    protected WebDriver setUpDriver(){
        return WebDriverUtils.setupWebDriver();
    }

    protected void quitDriver(WebDriver driver){
        try{
            WebDriverUtils.quitDriver(driver);
        }catch (IOException error){
            System.out.println(error);
        }
    }

}
