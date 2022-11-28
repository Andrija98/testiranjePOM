package pages;

import data.CommonString;
import data.time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllItemsPage extends BasePageClass{
    private String targetToProductXPath = "//div[@class=\"inventory_item_img\"]";
    private final String allItemsUrl = CommonString.ALL_ITEMS_PAGE_URL;
    public AllItemsPage(WebDriver driver) {
        super(driver);
    }
    public boolean verifyAllItemsPage(){
        return waitForUrllChange(allItemsUrl, time.SHORTEST);
    }
    public CardPage clickLoginButton(){
        WebElement element = waitForWebElementToBeVisible(By.xpath(targetToProductXPath), time.SHORTEST);
        this.clickWebElement(element);
        CardPage cardPage = new CardPage(driver);
        return cardPage;
    }
}
