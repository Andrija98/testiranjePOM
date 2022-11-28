package pages;

import data.time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePageClass {
    protected WebDriver driver;

    public BasePageClass(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); //DA BI MOGLI DA KORISTIMO LOKATORE
    }

    protected void openUrl(String url){
        driver.get(url);
    }
    protected String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    protected boolean waitForUrllChange(String url, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.urlToBe(url));
    }

    protected WebElement waitForWebElementToBeVisible(By identifyer, int time){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(identifyer));
    }
    protected WebElement waitForWebElementToBeVisible(WebElement element, int time){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void typeTextToWebElement(WebElement element, String text){
        waitForWebElementToBeVisible(element, time.SHORTER);
        element.sendKeys(text);
    }
    protected String getTextFormElement(WebElement element){
        return element.getText();
    }

    protected void clearTextFromWebElement(WebElement element){
        waitForWebElementToBeVisible(element, time.SHORTER);
        element.clear();
    }
    protected void clickWebElement(WebElement element){
        waitForWebElementToBeVisible(element, time.SHORTER);
        element.click();
    }
    protected void clearAndTypeToWebElement(WebElement element, String text){
        clearTextFromWebElement(element);
        typeTextToWebElement(element, text);
    }


}
